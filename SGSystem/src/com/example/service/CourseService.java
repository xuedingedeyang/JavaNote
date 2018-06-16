package com.example.service;

import java.util.List;

import com.example.DAO.CourseDao;
import com.example.bean.Course;
import com.example.bean.Teacher;

public class CourseService {
	private CourseDao cd = new CourseDao();
	public List<Course>getAllCourse(){
		return cd.getAllCourse();
	}
	
	public Course getCourseByCno(String cno){
		return null; 
	}

}
