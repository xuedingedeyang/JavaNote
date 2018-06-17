package com.example.service;

import java.util.List;

import com.example.DAO.TeacherDao;
import com.example.bean.Teacher;

public class TeacherService {
	private TeacherDao td = new TeacherDao();
	
	public Teacher getTeacherByTno(String tno){
		return td.getTeacherByTno(tno);
	}
	
	public List<Teacher> getAllTeacher(){
		return td.getAllTeacher();
	}
	
	public boolean login(String tno,String password){
		Teacher t = getTeacherByTno(tno);
		if(t==null){
			return false;
		}
		if(!t.getTpassword().equals(password)){
			return false;
		}
		return true;
	}
	
	
}
