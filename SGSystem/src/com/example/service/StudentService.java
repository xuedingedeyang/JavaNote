package com.example.service;

import java.util.List;

import com.example.DAO.StudentDao;
import com.example.bean.STGrade;

public class StudentService {
	private StudentDao sd = new StudentDao();
	public List<STGrade> getGrade(String sno){
		
		return sd.getGradeBySno(sno);
	}
}
