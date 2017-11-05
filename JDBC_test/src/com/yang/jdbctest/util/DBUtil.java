package com.yang.jdbctest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_test?useSSL=false";
	private static final String USER="root";
	private static final String PASSWORD="1909227160";
	
	private static Connection conn;
	
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		return conn;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name,age from goddess");
		while(rs.next())
		{
			System.out.println(rs.getString("user_name") + "," +rs.getInt("age"));
		}
		
		
	}

}
