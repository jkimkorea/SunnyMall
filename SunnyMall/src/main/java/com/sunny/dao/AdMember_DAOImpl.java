package com.sunny.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.BackupMemberVO;
import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

@Repository
public class AdMember_DAOImpl implements AdMember_DAO{

	@Inject
	private SqlSession session;
	private final static String NS ="com.sunny.mappers.AdMember_Mapper";
	
	//회원 목록
	@Override
	public List<MemberVO> memberList(SearchCriteria cri) throws Exception {
		return session.selectList(NS+".memberList",cri);
	}
	//회원 총 인원수
	@Override
	public int memberCount(SearchCriteria cri) throws Exception {
		return session.selectOne(NS+".memberCount",cri);
	}
	//회원 탈퇴 처리
	@Override
	public void deleteMember(String mb_id) throws Exception {
		session.delete(NS+".deleteMember", mb_id);
	}
	//탈퇴회원 목록
	@Override
	public List<BackupMemberVO> delMemberList(SearchCriteria cri) throws Exception {
		return session.selectList(NS+".del_MemberList",cri);
	}
	//탈퇴회원 수 출력
	@Override
	public int delMemberCount(SearchCriteria cri) throws Exception {
		return session.selectOne(NS+".delMemberCount", cri);
	}
	
	
}
