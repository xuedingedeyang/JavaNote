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
				}while(rs.previous());
			}
			for(Teacher t:list){
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
