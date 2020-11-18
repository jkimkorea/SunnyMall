package com.sunny.service;

import java.util.Date;

import com.sunny.domain.BackupMemberVO;
import com.sunny.domain.MemberDetailVO;
import com.sunny.domain.MemberVO;
import com.sunny.dto.MemberDTO;

public interface Member_Service {
	
	//아이디 중복체크
	public String checkIdDuplicate(String mb_id) throws Exception;
	//회원가입
	public void register(MemberVO vo) throws Exception;
	//회원탈퇴
	public void deleteUser(String mb_id) throws Exception;
	//로그인
	public MemberDTO login(MemberDTO dto) throws Exception;
	//회원정보 수정
	public void modify(MemberVO vo) throws Exception;
	//로그인 정보 쿠키 저장
	public void saveCookie(String id, Date sessionLimit, String mb_id) throws Exception;
	//비밀번호 변경
	public void changePw(MemberDTO dto) throws Exception;
	//회원 정보 불러오기
	public MemberVO readUserInfo(String mb_id) throws Exception;
	//회원 탈퇴 사유 저장
	public void insertComent(BackupMemberVO vo) throws Exception;
}
