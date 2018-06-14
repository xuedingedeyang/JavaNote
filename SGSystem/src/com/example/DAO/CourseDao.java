package com.example.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.Course;
import com.example.bean.Teacher;

public class CourseDao extends BaseDao{
	private TeacherDao td = new TeacherDao();
	public Course getCourseByCno(String cno){
		
		return null;
	}
	
	public List<Course>getAllCourse(){
		Connection conn = getConnection();
		List<Course> list= new ArrayList<>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from course");
			if(rs!=null){
				rs.last();
				do{
					Course c = new Course();
					c.setCno(rs.getString("Cno"));
					c.setCname(rs.getString("Cname"));
					c.setCcredit(rs.getString("Ccredit"));
					c.setCtime(rs.getString("Ctime"));
					c.setCremarks(rs.getString("Cremarks"));
					list.add(c);
				}while(rs.previous());
			}
			for(Course c:list){
				st = conn.createStatement();
				rs = st.executeQuery("select t,Tno,Tname, from teacher t,course c where t.Cno = "+c.getCno());
				if(rs!=null){
					rs.last();
					do{
						Teacher t = new Teacher();
						t.setTname(rs.getString("Tname"));
						t.setTno(rs.getString("Tno"));
						c.getTeachers().add(t);
					}while(rs.previous());
				}
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
		return list;
	}
}
