package com.sunny.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.AdMember_DAO;
import com.sunny.domain.BackupMemberVO;
import com.sunny.domain.MemberDetailVO;
import com.sunny.domain.MemberVO;
import com.sunny.util.SearchCriteria;

@Service
public class AdMember_ServiceImpl implements AdMember_Service {
	
	@Inject
	private AdMember_DAO dao;

	//회원 목록
	@Override
	public List<MemberVO> memberList(SearchCriteria cri) throws Exception {
		return dao.memberList(cri);
	}
	//회원 총 인원수
	@Override
	public int memberCount(SearchCriteria cri) throws Exception {
		return dao.memberCount(cri);
	}
	//회원 탈퇴 처리
	@Override
	public void deleteMember(String mb_id) throws Exception {
		dao.deleteMember(mb_id);
	}
	//탈퇴회원 목록
	@Override
	public List<BackupMemberVO> delMemberList(SearchCriteria cri) throws Exception {
		return  dao.delMemberList(cri);
	}
	//탈퇴회원 수 출력
	@Override
	public int delMemberCount(SearchCriteria cri) throws Exception {
		return dao.delMemberCount(cri);
	}
	//회원 상세정보 출력
	@Override
	public MemberDetailVO readMemberDetailinfo(String mb_id) throws Exception {
		return dao.readMemberDetailinfo(mb_id);
	}
	//회원별 작성리뷰글 갯수 출력
	@Override
	public int countMemberReview(String mb_id) throws Exception {
		return dao.countMemberReview(mb_id);
	}
	//회원 상세페이지 관리자 코멘트 저장
	@Override
	public void addComment(Map<String,Object> map) throws Exception {
		dao.addComment(map);
	}
	//회원 탈퇴처리
	@Override
	public void deleteMem(String mb_id) throws Exception {
		dao.deleteMem(mb_id);
	}	
	

}
