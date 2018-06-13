package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	
	private Connection conn = null;
	
	protected Connection getConnection(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test02";
		String user = "root";
		String password = "1909227160";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}	
