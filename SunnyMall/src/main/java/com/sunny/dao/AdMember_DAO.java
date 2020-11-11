package com.sunny.dao;

import java.util.List;

import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

public interface AdMember_DAO {
	
	//회원 목록
	public List<MemberVO> memberList() throws Exception;
	//회원 총 인원수
	public int memberCount(SearchCriteria cri) throws Exception;
}
