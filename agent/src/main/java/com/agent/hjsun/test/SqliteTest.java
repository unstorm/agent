package com.agent.hjsun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLite;

public class SqliteTest {
	// load the sqlite-JDBC driver using the current class loader
	
	Connection connection;
	public void test() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		    Statement statement = connection.createStatement();
		    statement.setQueryTimeout(30);  // set timeout to 30 sec.
		    
		    statement.executeUpdate("drop table if exists person");
		    statement.executeUpdate("create table person (id integer, name string)");
		    statement.executeUpdate("insert into person values(1, 'leo')");
		    statement.executeUpdate("insert into person values(2, 'yui')");
		    //ResultSet rs = statement.executeQuery("select * from person");
		    ResultSet rs = statement.executeQuery("select name from sqlite_master where name ='person'");
		    while(rs.next()) {
		      // read the result set
		      System.out.println("name = " + rs.getString("name"));
		      //System.out.println("id = " + rs.getInt("id"));
		    }
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		} finally {
		      try
		      {
		        if(connection != null)
		          connection.close();
		      }
		      catch(SQLException e)
		      {
		        // connection close failed.
		        System.err.println(e);
		      }
		}
	}
}
