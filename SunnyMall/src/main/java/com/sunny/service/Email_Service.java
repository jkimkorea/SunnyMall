package com.sunny.service;

import com.sunny.dto.EmailDTO;

public interface Email_Service {

	public void sendEmail(EmailDTO dto,String authcode);
}
