package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class STDao extends BaseDao {
	public boolean addOne(String sno,String tno){
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into st(Sno,Tno) values(?,?)");
			ps.setString(1, sno);
			ps.setString(2, tno);
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
