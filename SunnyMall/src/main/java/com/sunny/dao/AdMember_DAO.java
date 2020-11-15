package com.sunny.dao;

import java.util.List;

import com.sunny.domain.BackupMemberVO;
import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

public interface AdMember_DAO {
	
	//회원 목록
	public List<MemberVO> memberList(SearchCriteria cri) throws Exception;
	//회원 총 인원수
	public int memberCount(SearchCriteria cri) throws Exception;
	//회원 탈퇴처리
	public void deleteMember(String mb_id) throws Exception;
	//탈퇴회원 목록
	public List<BackupMemberVO> delMemberList(SearchCriteria cri) throws Exception;
	//탈퇴 회원 수 출력
	public int delMemberCount(SearchCriteria cri) throws Exception;
}