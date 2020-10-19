package com.sunny.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunny.domain.MemberVO;
import com.sunny.dto.MemberDTO;

@Repository
public class Member_DAOImpl implements Member_DAO {

	@Autowired
	private SqlSession session;
	private final static String NS="com.sunny.mapper.MemberMapper";
	
	
	//아이디 중복체크
	@Override
	public String checkIdDuplicate(String mb_id) throws Exception {
		return session.selectOne(NS+".checkIdDuplicate",mb_id);
	}
	//회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		session.insert(NS+".register", vo);
	}
	//로그인
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return session.selectOne(NS+".login",dto);
	}
	//로그인 시간 업데이트
	@Override
	public void loginUpdate(String mb_id) throws Exception {
		session.update(NS+".loginUpdate", mb_id);
	}
	//회원탈퇴
	@Override
	public void deleteUser(String mb_id) throws Exception {
		session.delete(NS+".deleteUser", mb_id);
	}
	//로그인 정보 쿠키에 저장
	@Override
	public void saveCookie(Map<String, Object> map) throws Exception {
		session.update(NS+".saveCookie", map);
	}
	//쿠키에 저장된 세션값으로 로그인 정보 가져옴.
	@Override
	public MemberVO checkUserSession(String value) throws Exception {
		return session.selectOne(NS+".", value);
	}
	//회원정보 수정
	@Override
	public void modify(MemberVO vo) throws Exception {
		session.update(NS+".modify",vo);
	}
	//비밀번호 변경
	@Override
	public void changePw(MemberDTO dto) throws Exception {
		session.update(NS+".changePw", dto);
		
	}
	//회원정보 불러오기
	@Override
	public MemberVO readUserInfo(String mb_id) throws Exception {
		return session.selectOne(NS+".readUserInfo", mb_id);
	}
	
	
}
