package com.example.service;

import java.util.List;

import com.example.DAO.StudentDao;
import com.example.bean.STGrade;
import com.example.bean.Student;

public class StudentService {
	private StudentDao sd = new StudentDao();
	
	public List<STGrade> getGrade(String sno){
		return sd.getGradeBySno(sno);
	}
	
	public Student getStudentBySno(String sno){
		return sd.getStudentBySno(sno);
	}
	
	public boolean updateStudent(Student stu){
		if(stu==null){
			return false;
		}
		if(sd.updateStudent(stu)){
			return true;
		}
		return false;
	}
	
	public boolean login(String sno,String password){
		Student stu = getStudentBySno(sno);
		if(stu==null){
			return false;
		}
		if(!stu.getSpassword().equals(password)){
			return false;
		}
		return true;
	}
	
	
}
