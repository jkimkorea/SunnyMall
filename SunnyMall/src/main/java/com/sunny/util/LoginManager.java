package com.sunny.util;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginManager implements HttpSessionBindingListener {

	//해당 클래스 싱글톤 패턴으로 구선
	private static LoginManager loginManager=null;
	
	private LoginManager() {}
	
	//요청에 의한 모든 스레드들이 순차적으로 메서드를 호출되도록 하기위한 동기화 작업: synchronized
	public static synchronized LoginManager getLoginManager() {
		if(loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}
	
	//로그인시 사용자 아이디 저장
	private static Hashtable<HttpSession, String> loginUsers = new Hashtable<HttpSession, String>();
	
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

}
