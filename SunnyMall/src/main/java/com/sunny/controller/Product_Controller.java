package com.sunny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.service.Product_Service;
import com.sunny.service.Review_Service;
import com.sunny.util.Criteria;
import com.sunny.util.FileUtils;
import com.sunny.util.PageMaker;
import com.sunny.util.SearchCriteria;

@Controller
@RequestMapping("/product/*")
public class Product_Controller {

	@Inject
	private Product_Service serivce;
	
	@Inject
	private Review_Service reviewService;
	
	@Resource(name="uploadPath")
	private String uploadPath;	
	
	private static final Logger logger = LoggerFactory.getLogger(Product_Controller.class);
	
	
	
	@ResponseBody
	@RequestMapping(value = "displayFile",method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		return FileUtils.getFile(uploadPath,fileName);
	}
	//카테고리에 따른 상품 리스트 출력
	@RequestMapping(value = "productList",method=RequestMethod.GET)
	public void list(@ModelAttribute("cri") SearchCriteria cri,
					 @ModelAttribute("cg_code") String cg_code,
					 Model model) throws Exception {
		logger.info("==========productList() execute==============");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("cg_code",cg_code);
		map.put("rowStart",cri.getRowStart());
		map.put("rowEnd",cri.getRowEnd());
		String cg_name=serivce.getCGName(cg_code);
		logger.info("============cg_code:" + cg_code);
		
		List<ProductVO> list= serivce.productListCG(map);
		model.addAttribute("vo", list);
		model.addAttribute("cg_name",cg_name);
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		int count = serivce.productCount(cg_code);
		pm.setTotalCount(count);
		logger.info("============count:" + count);
		
		model.addAttribute("pm",pm);
	}
	//1차 카테고리에 해당 하는 2차 카테고리 출력
	@ResponseBody
	@RequestMapping(value = "subCGList/{cg_code}",method=RequestMethod.GET)
	public ResponseEntity<List<CategoryVO>> subCGList(@PathVariable("cg_code") String cg_code){
		
		logger.info("==========subCGList() execute==============");
		ResponseEntity<List<CategoryVO>> entity=null;
		try {
			entity=new ResponseEntity<List<CategoryVO>>(serivce.subCGList(cg_code),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<List<CategoryVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//상품 페이지
	@RequestMapping(value = "readProduct",method=RequestMethod.GET)
	public void readProduct(@ModelAttribute("crt") Criteria cri,
							@RequestParam("prd_no") int prd_no,
							@RequestParam("cg_code") String cg_code,
							Model model) throws Exception {
		logger.info("============readProduct() execute============");
		ProductVO vo = serivce.readProduct(prd_no);
		model.addAttribute("vo", vo);
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		model.addAttribute("pm", pm);
		model.addAttribute("reviewCount", reviewService.reviewCount(vo.getPrd_no()));
		model.addAttribute("cg_name", serivce.getCGName(cg_code));
	}
	@RequestMapping(value = "listSearch",method=RequestMethod.GET)
	public void listSearch(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		
		logger.info("==============listSearch() execute=============");
		logger.info("==============cri:"+cri);
		List<ProductVO> list=serivce.allProductList(cri);
		model.addAttribute("vo", list);
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		int count = serivce.allProductCount(cri);
		pm.setTotalCount(count);
		model.addAttribute("pm", pm);
		
	}
	
}
