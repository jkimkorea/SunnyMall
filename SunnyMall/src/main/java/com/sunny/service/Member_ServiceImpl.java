package com.sunny.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.dao.Member_DAO;
import com.sunny.domain.MemberVO;
import com.sunny.dto.MemberDTO;

@Service
public class Member_ServiceImpl implements Member_Service {

	@Autowired
	Member_DAO dao;
	@Inject
	private BCryptPasswordEncoder crptPassEnc;

	
	//아이디 중복체크
	@Override
	public String checkIdDuplicate(String mb_id) throws Exception {
		return dao.checkIdDuplicate(mb_id);
	}
	//회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}
	//회원탈퇴
	@Override
	public void deleteUser(String mb_id) throws Exception {
		dao.deleteUser(mb_id);
	}
	//로그인
	@Transactional
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		MemberDTO memDTO= dao.login(dto);
		//암호화된 비밀번호 확인
		if(memDTO != null) {
			if(crptPassEnc.matches(dto.getMb_pw(), memDTO.getMb_pw())) {
				dao.loginUpdate(memDTO.getMb_id());
			}else {
				memDTO=null;
			}
		}
		return memDTO;
	}
	//회원정보 수정
	@Override
	public void modify(MemberVO vo) throws Exception {
		dao.modify(vo);
	}
	//로그인 정보 쿠키 저장.
	@Override
	public void saveCookie(String sessionKey, Date sessionLimit, String mb_id) throws Exception {
		Map<String,Object> map=new HashMap<String, Object>();
		
		dao.saveCookie(map);
	}
	//비밀번호 변경
	@Override
	public void changePw(MemberDTO dto) throws Exception {
		dao.changePw(dto);
	}
	//회원정보 불러오기
	@Override
	public MemberVO readUserInfo(String mb_id) throws Exception {
		return dao.readUserInfo(mb_id);
	}

	
	
	
}
