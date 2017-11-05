package com.yang.jdbctest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yang.jdbctest.model.Goddess;
import com.yang.jdbctest.util.DBUtil;

public class GoddessDao {
	public void addGoddess()
	{
		
	}
	
	public void updateGoddess()
	{
		
	}
	
	public void delGoddess()
	{
		
	}
	
	public List<Goddess>query() throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name,age from goddess");
		List<Goddess> gs = new ArrayList<>();
		Goddess g = null;
		while(rs.next())
		{
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			
			gs.add(g);
			System.out.println(rs.getString("user_name") + "," +rs.getInt("age"));
		}
		return gs;
	}
	
	public Goddess get()
	{
		return null;
	}
}
