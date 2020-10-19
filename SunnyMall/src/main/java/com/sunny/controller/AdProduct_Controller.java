package com.sunny.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.service.AdProduct_Service;
import com.sunny.util.FileUtils;
import com.sunny.util.PageMaker;
import com.sunny.util.SearchCriteria;
@Controller
@RequestMapping("/admin/product/*")
public class AdProduct_Controller {

		@Inject
		private AdProduct_Service service;
		
		@Resource(name="uploadPath")
		private String uploadPath;
		
		private static final Logger logger = LoggerFactory.getLogger(AdProduct_Controller.class);
		
		//관리자 리스트
		@RequestMapping(value = "/list",method = RequestMethod.GET)
		public void listPage(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
			logger.info("==========listPage() execute================");
			logger.info("=====cri : " + cri.toString());
			model.addAttribute("productList",service.searchListProduct(cri));
			
			PageMaker pm=new PageMaker();
			pm.setCri(cri);
			
			int count=service.searchListCount(cri);
			
			logger.info("===========일치하는 상품 개수:"+count);
			pm.setTotalCount(count);
			model.addAttribute("pm", pm);
		
		}
		//상품 등록 패이지 + 1차 카태고리 리스트
		@RequestMapping(value = "/admin_insertPage",method=RequestMethod.GET)
		public void admin_insertPage(Model model) {
			logger.info("=============admin_insertPage() execute======");
			model.addAttribute("cateList", service.mainCGList());
		}
		//서브 카테고리 불러오기
		@ResponseBody
		@RequestMapping(value="subCGList/{cg_code}", method=RequestMethod.GET)
		public ResponseEntity<List<CategoryVO>> subCGListPOST(@PathVariable("cg_code") String cg_code){
			
			logger.info("===== subCGListGET() execute========");
			// 2차 카테고리 리스트
			ResponseEntity<List<CategoryVO>> entity = null;
			try {
				entity = new ResponseEntity<List<CategoryVO>>(service.subCGList(cg_code), HttpStatus.OK);
				logger.info("===============entity:"+entity);
			} catch(Exception e){
				entity = new ResponseEntity<List<CategoryVO>>(HttpStatus.BAD_REQUEST);
			}
			return entity; 
		}
		//ckeditor에 이미지 업로드
		@RequestMapping(value = "imgUpload",method=RequestMethod.POST)
		public void imgUpload(HttpServletRequest req,HttpServletResponse res,MultipartFile upload) {
			logger.info("=============imgUpload() excute============");
			OutputStream out = null;
			PrintWriter printWriter = null;
			
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			
			try {
				String fileName = upload.getOriginalFilename();
				byte[] bytes = upload.getBytes();
				
				String uploadPath = req.getSession().getServletContext().getRealPath("/");
				uploadPath = uploadPath + "resources\\upload\\"+fileName;
				
				logger.info("========uploadPath: " + uploadPath);
				
				out = new FileOutputStream(new File(uploadPath));
				out.write(bytes);
				printWriter = res.getWriter();
				String fileUrl = "/upload/" + fileName;
				
				printWriter.println("{\"filename\":\"" + fileName + "\", \"uploaded\":1,\"url\":\"" + fileUrl + "\"}");
				printWriter.flush();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(out!=null) {
					try {out.close();}catch(Exception e) {e.printStackTrace();}
				}
				if(printWriter!=null) {
					try {printWriter.close();}catch(Exception e) {e.printStackTrace();}
		     }
          }

       }
		//상품 등록
		@RequestMapping(value = "insert",method = RequestMethod.POST)
		public String insertProduct(ProductVO vo,RedirectAttributes rttr) throws Exception{
			vo.setPrd_img(FileUtils.uploadFile(uploadPath, vo.getFile1().getOriginalFilename(),vo.getFile1().getBytes()));
			service.insertProduct(vo);
			logger.info("================insertProduct vo:"+vo);
			rttr.addFlashAttribute("msg","INSERT_SUCCESS");
			
			return "redirect:/admin/product/list";
		}
		//상품 삭제
		@RequestMapping(value = "delete",method=RequestMethod.POST)
		public String deleteChecked(@RequestParam("prd_no") int prd_no,
									@RequestParam("prd_img")String prd_img,
								    RedirectAttributes rttr,SearchCriteria cri) throws Exception {
			deleteFile(prd_img);
			service.deleteProduct(prd_no);
			rttr.addFlashAttribute("cri",cri);
			rttr.addFlashAttribute("msg", "DELETE_SUCCESS");
			
			return "redirect:/admin/product/list";
		}
		//이미지 파일 삭제
		private void deleteFile(String prd_img) {
			logger.info("========delete FileName:" + prd_img);
			FileUtils.deleteFile(uploadPath, prd_img);
			
		}
		//상품리스트에 이미지 띄우기
		@RequestMapping(value = "displayFile", method=RequestMethod.GET)
		public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
			return FileUtils.getFile(uploadPath, fileName);
		}
		//선택된 상품 삭제
		@RequestMapping(value = "deleteChecked",method=RequestMethod.POST)
		public ResponseEntity<String> deleteChecked(@RequestParam("checkArr[]") List<Integer> checkArr,
													@RequestParam("imgArr[]") List<String> imgArr){
			ResponseEntity<String> entity=null;
			logger.info("=========deleteChecked() execute========");
			try {
				for(int i=0; i<checkArr.size(); i++) {
					deleteFile(imgArr.get(i));
					service.deleteProduct(checkArr.get(i));
				}
				entity=new ResponseEntity<String>(HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
		//상품 수정(상품정보와 함께 상품수정 페이지 불러오기)
		@RequestMapping(value = "edit",method=RequestMethod.GET)
		public void productEditGet(@ModelAttribute("cri") SearchCriteria cri,
									 @RequestParam("prd_no") int prd_no,
									 Model model) throws Exception {
			logger.info("========productEditGet() execute=============");
			ProductVO vo = service.readProduct(prd_no);
			
			List<CategoryVO> subCateList = service.subCGList(vo.getCg_parent());
			String originFile = vo.getPrd_img().substring(vo.getPrd_img().lastIndexOf("-")+1);
			
			model.addAttribute("vo", vo);
			model.addAttribute("originFile", originFile);
			model.addAttribute("cateList",service.mainCGList());
			model.addAttribute("subCateList",service.subCGList(vo.getCg_parent()));
			
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			
			model.addAttribute("pm",pm);
		}
}











