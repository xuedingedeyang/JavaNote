package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.STGrade;
import com.example.bean.Student;

public class StudentDao extends BaseDao{
	Connection conn;
	public Student getStudentBySno(String sno){
		try {
			conn = getConnection();
			System.out.println("dao"+sno);
			PreparedStatement ps =  conn.prepareStatement("select * from student where Sno = ?");
			ps.setString(1, sno);
			ResultSet rs = ps.executeQuery();
			Student st = null;
			if(rs!=null){
				st = new Student();
				rs.first();
				st.setSname(rs.getString("Sname"));
				st.setSage(rs.getString("Sage"));
				st.setSsex(rs.getString("Ssex"));
				st.setSpassword(rs.getString("Spassword"));
				st.setStel(rs.getString("Stel"));
				st.setSno(sno);
			}
			return st;
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
		return null;
	}
	
	public List<STGrade> getGradeBySno(String sno){
		conn = getConnection();
		List<STGrade> list = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select course.Cname,teacher.Tname,ST.Grade from student,ST,teacher,course where student.Sno=ST.Sno and St.Tno = teacher.Tno and teacher.Cno=course.Cno and student.Sno='1607084101'");
			ResultSet rs = ps.executeQuery();
			if(rs!=null){
				rs.last();
				list = new ArrayList<>();
				do{
					STGrade sg = new STGrade();
					sg.setCourseName(rs.getString("Cname"));
					sg.setTeacherName(rs.getString("Tname"));
					sg.setGrade(rs.getFloat("Grade"));
					list.add(sg);
				}while(rs.previous());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
