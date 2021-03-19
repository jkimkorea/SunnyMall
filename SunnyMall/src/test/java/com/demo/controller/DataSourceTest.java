package com.demo.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//루트 컨텍스트.xml에서 bean 객체에 이상이 있나 없나를 테스트 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})// 톰캣이 시작되면서 빈객체를 생성하는데 이를 테스트한다. 
public class DataSourceTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void testConection()throws Exception{
		
		try(Connection con = ds.getConnection()){
			
			System.out.println(con);// 위 주소를 참조해서 rootcotext.xml에 bean객체를 생성해서 con 에서 객체를 생성하고, 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


