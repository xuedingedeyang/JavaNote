package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.ST;

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
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<ST> getSTByTno(String tno){
		Connection conn = getConnection();
		List<ST> sts = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from st where tno = ?");
			ps.setString(1, tno);
			ResultSet rs = ps.executeQuery();
			if(rs.last()){
				sts = new ArrayList<>();
				ST st = null;
				do{
					st = new ST();
					st.setSno(rs.getString("sno"));
					st.setTno(rs.getString("tno"));
					st.setGrade(rs.getFloat("grade"));
					sts.add(st);
				}while(rs.previous());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sts;
	}
	
	public boolean update(List<ST>stList){
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			for(ST st :stList){
				ps = conn.prepareStatement("update st set grade = ? where sno = ? and tno = ?");
				ps.setFloat(1, st.getGrade());
				ps.setString(2, st.getSno());
				ps.setString(3, st.getTno());
				ps.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
	}

	public List<ST> getSTBySno(String sno) {
		Connection conn = getConnection();
		List<ST> sts = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from st where sno = ?");
			ps.setString(1, sno);
			ResultSet rs = ps.executeQuery();
			if(rs.last()){
				sts = new ArrayList<>();
				ST st = null;
				do{
					st = new ST();
					st.setSno(rs.getString("sno"));
					st.setTno(rs.getString("tno"));
					st.setGrade(rs.getFloat("grade"));
					sts.add(st);
				}while(rs.previous());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sts;
	}
	
	
}
