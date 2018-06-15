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
	public List<Teacher> getAllTeacher(){
		Connection conn = null;
		List<Teacher>list = null;
		conn = getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from teacher");
			list = new ArrayList<>();
			if(rs!=null){
				rs.last();
				do{
					Teacher t = new Teacher();
					t.setTname(rs.getString("Tname"));
					t.setTno(rs.getString("Tno"));
					t.setTSex(rs.getString("Tsex"));
					list.add(t);
				}while(rs.previous());
			}
			for(Teacher t:list){
				st = conn.createStatement();
				rs = st.executeQuery("select * from course c,teacher t where t.Cno=c.Cno and t.Tno = "+t.getTno());
				if(rs!=null){
					rs.last();
					Course c = null;
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
}
