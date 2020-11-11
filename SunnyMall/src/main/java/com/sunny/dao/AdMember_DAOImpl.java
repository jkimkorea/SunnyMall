package com.sunny.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

@Repository
public class AdMember_DAOImpl implements AdMember_DAO{

	@Inject
	private SqlSession session;
	private final static String NS ="som.sunny.mappers.AdMember_Mapper";
	
	//회원 목록
	@Override
	public List<MemberVO> memberList() throws Exception {
		return session.selectList(NS+".memberList");
	}
	//회원 총 인원수
	@Override
	public int memberCount(SearchCriteria cri) throws Exception {
		return session.selectOne(NS+".memberCount",cri);
	}
	
	
}
