package com.Levide.Administor;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	public static String driver;
	public static String dburl;
	public static String user;
	public static String password;
	
	public static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn;
	
	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties"); 
			prop.load(in);
		} catch (Exception e) {
			System.out.println("=====配置文件错误=====");
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance() {
		return factory;
	}
	
	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			System.out.println("连接数据库出错！");
			e.printStackTrace();	
		}
		return conn;
	}
}
