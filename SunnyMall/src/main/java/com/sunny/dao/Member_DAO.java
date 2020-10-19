package com.sunny.dao;

import java.util.Map;

import com.sunny.domain.MemberVO;
import com.sunny.dto.MemberDTO;

public interface Member_DAO {

	//회원가입
	public void register(MemberVO vo) throws Exception;
	//아이디 중복체크
	public String checkIdDuplicate(String mb_id) throws Exception;
	//로그인
	public MemberDTO login(MemberDTO dto) throws Exception;
	//로그인 시간 업데이트
	public void loginUpdate(String mb_id) throws Exception;
	//회원탈퇴
	public void deleteUser(String mb_id) throws Exception;
	//로그인 정보 쿠키저장
	public void saveCookie(Map<String,Object> map) throws Exception;
	//쿠키에 저장된 세션값으로 로그인 정보 가져옴
	public MemberVO checkUserSession(String value) throws Exception;
	//회원정보 수정
	public void modify(MemberVO vo) throws Exception;
	//비밀번호 변경
	public void changePw(MemberDTO dto) throws Exception;
	//회원 정보 불러오기
	public MemberVO readUserInfo(String mb_id) throws Exception;
}
