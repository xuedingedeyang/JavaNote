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
}
