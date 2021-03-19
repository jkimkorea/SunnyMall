package com.demo.controller;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

//오라클 연결 문제 테스트 
public class OracleConnectionTest {

	private static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	private static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = 
			"spring";  // 내껄로 이름 비번 바꿀것. 
	private static final String PW = 
			"spring";
			
	
	@Test//여기서 에러가 나면 위에 설정이 잘못됐다는 뜻임 .
	public void testConnection() throws Exception{
		
		Class.forName(DRIVER); //메모리상에 로딩해줌
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){ //con 객체가 생성됨. 
			
			System.out.println(con); // 객체 코드값 출력  
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
