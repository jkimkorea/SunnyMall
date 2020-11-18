package com.sunny.dao;

import java.util.List;
import java.util.Map;

import com.sunny.domain.BackupMemberVO;
import com.sunny.domain.MemberDetailVO;
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
	//회원 상세 정보 출력
	public MemberDetailVO readMemberDetailinfo(String mb_id) throws Exception;
	//회원별 리뷰 갯수 출력
	public int countMemberReview(String mb_id) throws Exception;
	//회원 상세페이지 관리자 코멘트 저장
	public void addComment(Map<String,Object> map) throws Exception;
	//회원 탈퇴 처리
	public void deleteMem(String mb_id) throws Exception;
}