package com.agent.hjsun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.hsqldb.Server;

public class HdbTest {
	private Connection conn = null;		
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private Server server = null;
	
	public void startHdb() {
		 server = new Server();
		 server.setAddress("localhost");
		 server.setDatabaseName(0, "mydb1");
		 server.setDatabasePath(0, "file:C:/hsqldb_databases/mydb");		 
		 server.setPort(1234);
		 server.start();
	}
	
	public void stopHdb() {
		if(server != null)
			server.stop();
	}
	
	public Connection getHdbConn() 
	{	
		 Connection hdbconn = null;
		 try {
			 Class.forName("org.hsqldb.jdbc.JDBCDriver");
		 } catch (ClassNotFoundException  cnfe) {
			cnfe.printStackTrace(System.out);
		 }		 
		 try {
			 hdbconn = DriverManager.getConnection(
	                 "jdbc:hsqldb:hsql://localhost:1234/mydb1", "SA", "");	 
		 } catch (SQLException e) {
			 e.printStackTrace(System.out);
		 }		 
		 return hdbconn;
	}
	
	public void inserthdb() {
		try {
			if(conn == null) {
				conn = getHdbConn();
			}
			
			for(int i = 0; i < 10; i++) {
      		conn.createStatement()
      		.executeUpdate(
      				"insert into contacts values('내이름"+i+"','aaaa@bbb.com','010-1111-2222')");
			}
		} catch (SQLException e) {
          e.printStackTrace(System.out);
      }
	}
	
	public void createhdb() {	    
      try {
      	conn = getHdbConn();
          conn.createStatement()
                  .executeUpdate(
                          "create table contacts (name varchar(45),email varchar(45),phone varchar(45))");            
      } catch (SQLException e) {
          e.printStackTrace(System.out);
      }        
	}
	
	public String selecthdb() {
		String sRtn = "";
		try {
			if(conn == null) {
				conn = getHdbConn();
			}
			
		
      	String sQuery = "select * from contacts";
			pstm = conn.prepareStatement(sQuery);
			rs = pstm.executeQuery();			
			System.out.println("select start");
			while(rs.next()) {
				ResultSetMetaData rsMetaData = rs.getMetaData();
				for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					System.out.println(rsMetaData.getColumnName(i) +" : "+rs.getObject(i));
					sRtn += rs.getObject(i) + "\n";
				}
			}
      } catch (Exception ex) {
      	ex.printStackTrace(System.out);
      	
      } finally {
      	try {
      		rs.close();
          	pstm.close();
          	conn.close();
          	server.stop();
      	} catch(Exception e) {
      		e.printStackTrace(System.out);
      	}
      }
		stopHdb();
		return sRtn;
	}
}
