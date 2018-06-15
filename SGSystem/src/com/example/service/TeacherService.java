package com.example.service;

import java.util.List;

import com.example.DAO.TeacherDao;
import com.example.bean.Teacher;

public class TeacherService {
	private TeacherDao td = new TeacherDao();
	
	public Teacher getTeacherByTno(String tno){
		return null;
	}
	
	public List<Teacher> getAllTeacher(){
		return td.getAllTeacher();
	}
}
