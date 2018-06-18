package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bean.Course;
import com.example.bean.Teacher;

public class TeacherDao extends BaseDao{
	Connection conn = null;
	CourseDao cd = null;
	public TeacherDao() {
		super();
	}

	public List<Teacher> getAllTeacher(){
		conn = null;
		List<Teacher>list = null;
		conn = getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from teacher");
			list = new ArrayList<>();
			if(rs.last()){
				do{
					Teacher t = new Teacher();
					t.setTname(rs.getString("Tname"));
					t.setTno(rs.getString("Tno"));
					t.setTSex(rs.getString("Tsex"));
					list.add(t);
				}while(rs.previous());
			}
			Course c = null;
			for(Teacher t:list){
				st = conn.createStatement();
				rs = st.executeQuery("select * from course c,teacher t where t.Cno=c.Cno and t.Tno = "+t.getTno());
				if(rs.last()){
					do{
						c = new Course();
						c.setCno(rs.getString("Cno"));
						c.setCname(rs.getString("Cname"));
						c.setCtime(rs.getString("Ctime"));
						c.setCcredit(rs.getString("Ccredit"));
						c.setCremarks(rs.getString("Cremarks"));
					}while(rs.previous());
					t.setCourse(c);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public Teacher getTeacherByTno(String tno) {
		conn = getConnection();
		Statement st;
		Teacher t = null;
		if(cd == null){
			cd = new CourseDao();
		}
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from teacher where Tno = "+tno);
			
			if(rs.first()){
				t = new Teacher();
				t.setTno(rs.getString("Tno"));
				t.setTname(rs.getString("Tname"));
				t.setTSex(rs.getString("Tsex"));
				t.setTpassword(rs.getString("Tpassword"));
				t.setCourse(cd.getCourseByCno(rs.getString("Cno")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public boolean updateTeacher(Teacher t){
		conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update teacher set Tname=?,Tsex=?,Tpassword=?,Cno=? where Tno=?");
			ps.setString(1, t.getTname());
			ps.setString(2, t.getTSex());
			ps.setString(3, t.getTpassword());
			ps.setString(4, t.getCourse().getCno());
			ps.setString(5, t.getTno());
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return false;
	}
}
