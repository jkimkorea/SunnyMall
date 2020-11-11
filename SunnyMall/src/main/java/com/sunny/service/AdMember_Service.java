package com.sunny.service;

import java.util.List;

import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

public interface AdMember_Service {

	//회원 목록
	public List<MemberVO> memberList() throws Exception;
	//회원 총인원수
	public int memberCount(SearchCriteria cri) throws Exception;
	
}
