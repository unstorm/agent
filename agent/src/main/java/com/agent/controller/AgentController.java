package com.agent.controller;

import org.springframework.web.bind.annotation.RestController;

import com.agent.hjsun.test.HdbTest;
import com.agent.hjsun.test.SensitiveImpl;
import com.agent.hjsun.test.SensitiveTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * com.agent.controller 
 *    |_ AgentController.java
 * 
 * </pre>
 * @date : 2017. 11. 6. 오전 10:42:08
 * @version : 
 * @author : Brian H Sun
 */
@RestController
public class AgentController {

	 //@Autowired
	  //private DataSource ds; //작성
	@RequestMapping("/hjsun")
	public String hjsun() throws Exception {
		//SensitiveImpl impl = new SensitiveImpl();
		//return impl.oracleAccessTest();
//		System.out.println("ds : "+ds);
//	     Connection con = ds.getConnection();
//	     System.out.println("con : "+con); //확인 후

		HdbTest test = new HdbTest();
		test.startHdb();		
		//return "I must success!!";
		return test.selecthdb();
	}
		
	@RequestMapping("/my")
	public String mytest() throws Exception {
		SensitiveTest test = new SensitiveTest();
		test.testConnection();
		return "success";
	}
	
	@RequestMapping("/kjham")
	public String kjham() {
		return "I must success!! kjham!!!!!!";
	}
	
	@RequestMapping("/mkkim")
	public String mkkim() {
		return "Welcome to git!!!!";
	}
}
