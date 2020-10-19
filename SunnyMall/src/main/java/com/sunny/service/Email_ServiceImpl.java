package com.sunny.service;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.sunny.dto.EmailDTO;

@Repository
public class Email_ServiceImpl implements Email_Service {

	@Inject
	JavaMailSender mailSender;
	
	//인증코드 전송
	@Override
	public void sendEmail(EmailDTO dto, String authcode) {
		MimeMessage msg=mailSender.createMimeMessage();
		
		try {
			
			msg.addRecipient(RecipientType.TO,new InternetAddress(dto.getReceiveMail()));
			msg.addFrom(new InternetAddress[] {new InternetAddress(dto.getSenderMail(),dto.getSenderName())});
			msg.setSubject(dto.getSubject(),"utf-8");
			msg.setText(dto.getMessage()+authcode,"utf-8");
			mailSender.send(msg);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
