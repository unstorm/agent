package com.agent.hjsun.test;

import java.sql.*;

public class SensitiveImpl extends SensitiveChechsumImpl {
	
	private Connection conn = null;
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public String oracleAccessTest() {
		
		try {
			 String user =  "sys as sysdba";
             String pw = "chakra";
             String url = "jdbc:oracle:thin:@172.16.40.101:1522:o11gr2";
             
             Class.forName("oracle.jdbc.driver.OracleDriver");
             setConn(DriverManager.getConnection(url, user, pw));
             
             return "Database접속 성공\n";
		} catch (ClassNotFoundException cnfe) {           
			return("DB 클래스 없음 :"+cnfe.toString());
        } catch (SQLException sqle) {
        	return("DB 쿼리 오류 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
            return("Unkonwn error");
        }
	}
	
	public void fetchTest() {
		
	}
}
