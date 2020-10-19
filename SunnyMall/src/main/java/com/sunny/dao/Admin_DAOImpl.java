package com.sunny.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunny.domain.AdminVO;
import com.sunny.dto.AdminDTO;

@Repository
public class Admin_DAOImpl implements Admin_DAO {

	
	@Autowired
	private SqlSession session;
	public final static String NS="com.sunny.mappers.Admin_Mapper";
	
	//관리자 로그인
	@Override
	public AdminVO adminLogin(AdminDTO dto) throws Exception {
		AdminVO vo=session.selectOne(NS+".adminLogin", dto);
		System.out.println("================DAO vo:"+vo);
		return vo;
	}
	//관리자 최근 접속 시간 업데이트
	@Override
	public void adminLoginTime(String admin_id) throws Exception {
		session.insert(NS+".adminLoginTime", admin_id);
		
	}

	
}
