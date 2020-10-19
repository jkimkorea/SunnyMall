package com.sunny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunny.dao.Admin_DAO;
import com.sunny.domain.AdminVO;
import com.sunny.dto.AdminDTO;

@Service
public class Admin_ServiceImpl implements Admin_Service {

	@Autowired
	private Admin_DAO dao;

	//관리자 로그인
	@Override
	public AdminVO adminLogin(AdminDTO dto) throws Exception {
		AdminVO vo=dao.adminLogin(dto);
		if(vo!= null) {
			dao.adminLoginTime(dto.getAdmin_pw());
		}
		System.out.println("=================== Service Vo:"+vo);
		return vo;
	}
	//관리자 최근접속 시간 업데이트
	@Override
	public void adminLoginTime(String admin_id) throws Exception {
		dao.adminLoginTime(admin_id);
	}
	
	
}
