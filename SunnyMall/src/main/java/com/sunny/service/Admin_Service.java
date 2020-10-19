package com.sunny.service;

import com.sunny.domain.AdminVO;
import com.sunny.dto.AdminDTO;

public interface Admin_Service {


	//관리자 로그인
	public AdminVO adminLogin(AdminDTO dto) throws Exception;
	//관리자 최근 접속 시간 업데이트
	public void adminLoginTime(String admin_id) throws Exception;
}
