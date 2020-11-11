package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.AdMember_DAO;
import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

@Service
public class AdMember_ServiceImpl implements AdMember_Service {
	
	@Inject
	private AdMember_DAO dao;

	//회원 목록
	@Override
	public List<MemberVO> memberList() throws Exception {
		return dao.memberList();
	}
	//회원 총 인원수
	@Override
	public int memberCount(SearchCriteria cri) throws Exception {
		return dao.memberCount(cri);
	}

}
