package com.sunny.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunny.domain.MemberVO;
import com.sunny.dto.MemberDTO;
import com.sunny.service.Member_Service;

@Controller
@RequestMapping("/member/*")
public class Member_Controller {

	private static final Logger logger = LoggerFactory.getLogger(Member_Controller.class);

	@Inject
	Member_Service service;
	@Inject
	private BCryptPasswordEncoder crptPassEnc;

	//로그인 페이지
	@RequestMapping(value = "/loginPage",method = RequestMethod.GET)
	public void loginPage() {
	}
	//로그인
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(MemberDTO dto,HttpSession session,RedirectAttributes rttr) throws Exception {
		logger.info("============login() execute=====");
		MemberDTO memDTO = service.login(dto);
		if(memDTO !=null) {
			logger.info("============login() succed=====");
			session.setAttribute("user", memDTO);
			if(memDTO.isUseCookie()) {
				int amount=60*60*24*7;
				Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));
				service.saveCookie(session.getId(),sessionLimit,memDTO.getMb_id());
			}
			rttr.addFlashAttribute("msg", "LOGIN_SUCCESS");
			return "redirect:/";
		}else {
		rttr.addFlashAttribute("msg","LOGIN_FAIL");
		return "redirect:/member/loginPage";
		}
	}
	//로그아웃
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession session,RedirectAttributes rttr) {
		logger.info("=============logout() execute=======");
		session.invalidate();
		rttr.addFlashAttribute("msg", "LOGOUT_SUCCESS");
		return "redirect:/";
	}
	//회원가입 페이지
	@RequestMapping(value = "/registerForm",method = RequestMethod.GET)
	public void registerForm(MemberVO vo,RedirectAttributes rttr) {
		
		logger.info("==============registerForm() execute=========");
	}
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/checkIdDuplicate",method=RequestMethod.POST)
	public ResponseEntity<String> checkIdDuplicate(HttpSession session,@RequestParam("mb_id") String mb_id) {
		
		logger.info("=============checkIdDuplicate() execute========");
		ResponseEntity<String> entity=null;
		try {
			String checkId=service.checkIdDuplicate(mb_id);
			if(checkId != null) {
				entity=new ResponseEntity<String>("FAIL",HttpStatus.OK);
			}else {
				entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//이메일 인증코드 확인
	@ResponseBody
	@RequestMapping(value = "/checkAuthcode",method=RequestMethod.POST)
	public ResponseEntity<String> checkAuthcode(@RequestParam("code") String code,HttpSession session) {
		logger.info("============checkAuthode() execute===========");
		logger.info("============checkAuthode:"+code);
		ResponseEntity<String> entity=null;
		try {
			if(code.equals(session.getAttribute("authcode"))) {
				entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}else {
				entity=new ResponseEntity<String>("FAIL",HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//비밀번효 확인
	@ResponseBody
	@RequestMapping(value = "/checkPw",method=RequestMethod.POST)
	public ResponseEntity<String> checkPw(@RequestParam("mb_pw") String mb_pw,
			                              HttpSession session,Model model) {
		logger.info("=============checkPW() execute==========");
		logger.info("=============pw:"+mb_pw);
		ResponseEntity<String> entity=null;
		MemberDTO dto=(MemberDTO)session.getAttribute("user");
		if(crptPassEnc.matches(mb_pw, dto.getMb_pw())) {
			logger.info("===========checkPw success============");
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}else {
			logger.info("=============checkPw fail=================");
			entity=new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);
		} 
		return entity;
	}
	//회원가입
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String register(MemberVO vo,RedirectAttributes rttr) throws Exception {
		logger.info("=============register() execute============");
		logger.info("================입력데이타:"+vo.toString());
		//비밀번호의 암호화 처리
		vo.setMb_pw(crptPassEnc.encode(vo.getMb_pw()));
		service.register(vo);
		rttr.addFlashAttribute("msg","REGISTER_SUCCESS");
		return "redirect:/";
	}
	//회원정보 수정 페이지
	@RequestMapping(value = "/modifyGet",method = RequestMethod.GET)
	public String modifyGet(Model model,HttpSession session) throws Exception {
		logger.info("=========modifyGet() execute===========");
		MemberDTO dto=(MemberDTO)session.getAttribute("user");
		String mb_id=dto.getMb_id();
		logger.info("==============mb_id:"+mb_id);
		
		MemberVO vo=service.readUserInfo(mb_id);
		logger.info("==============vo:"+vo);
	
		model.addAttribute("vo",vo);
		return "/member/modifyForm";
		}
	
	//회원정보 수정
	@RequestMapping(value = "/modify",method=RequestMethod.POST)
	public String modify(MemberVO vo,RedirectAttributes rttr,HttpSession session) throws Exception {
		logger.info("===============modify() execute============");
		logger.info("===============memberVO:"+vo);
		MemberDTO dto=new MemberDTO();
		dto.setMb_id(vo.getMb_id());
		dto.setMb_pw(vo.getMb_pw());
		vo.setMb_pw(crptPassEnc.encode(vo.getMb_pw()));
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY_USER_SUCCESS");
		return "redirect:/";
	}
	//비밀번호 변경 페이지
	@RequestMapping(value = "/changePwPage",method = RequestMethod.GET)
	public void changePwPage() {
		
	}
	//비밀번호 변경
	@RequestMapping(value = "/changePw",method = RequestMethod.POST)
	public String changePw(MemberDTO dto,HttpSession session,RedirectAttributes rttr) throws Exception {
		logger.info("==========changePw() execute=======");
		dto.setMb_pw(crptPassEnc.encode(dto.getMb_pw()));
		service.changePw(dto);
		MemberDTO memDTO=(MemberDTO) session.getAttribute("user");		
		memDTO.setMb_pw(dto.getMb_pw());
		session.setAttribute("user", memDTO);
		rttr.addFlashAttribute("msg","CHANGE_PW_SUCCESS");
		return "redirect:/";
	}
	//회원 탈퇴
	@RequestMapping(value = "/deleteUser",method=RequestMethod.GET)
	public String deleteUser(HttpSession session,RedirectAttributes rttr) throws Exception {
			logger.info("===========deleteUser() execute=========");
			MemberDTO dto=(MemberDTO) session.getAttribute("user");
			service.deleteUser(dto.getMb_id());
			session.invalidate();
			rttr.addFlashAttribute("msg", "DELETE_USER_SUCCESS");
			
			logger.info("===========DELETE_USER_SUCCESS");
		return "redirect:/";
	}
}
