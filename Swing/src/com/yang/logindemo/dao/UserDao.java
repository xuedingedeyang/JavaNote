package com.yang.logindemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yang.logindemo.entity.User;

public class UserDao extends BaseDao{
	
	private Connection conn;
	private Statement st;
	
	public User getUser(String username){
		conn = getConnection();
		try {
			st = conn.createStatement();
			PreparedStatement ps =conn.prepareStatement("select * from user where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean addUser(String username,String password){
		System.out.println("username = " +username + ",password = " + password);
		conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into user(username,password) values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
