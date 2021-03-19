package com.demo.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//루트컨텍스트.xml에서 빈객체 밑에 sqlsessionFactory/sqlSession가 마이바티스를 통해서 작업하는게 이상이 있나 없나 테스트 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {

	@Inject 
	private SqlSessionFactory sqlFactory; // 루트에 sqlsessionfactory를 여기에 주입해서 빈객체 내용이 이상이 있는지 없는지 테스트 
	//<property name="dataSource" ref="dataSource" /> 이거는 이미 오라클 데이타 테스트에서 된거여서 이 아래 내용이 문제없는지 체크하게됨. 
	
	@Test
	public void testFactory(){
		
		System.out.println(sqlFactory);
		
	}
	
	@Test
	public void testSession()throws Exception{
		
		try(SqlSession session = sqlFactory.openSession()){ // session 은 루트에서 sqlSession을 테스트 하기 위한 것이다. urid를 관장하는 객체. 
			
			System.out.println(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}


