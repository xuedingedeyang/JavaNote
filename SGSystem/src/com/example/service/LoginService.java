package com.example.service;

import com.example.DAO.StudentDao;
import com.example.bean.Student;

public class LoginService {
	
	private StudentDao sd = new StudentDao();
	
	public boolean studentLogin(String username,String password){
		Student st = sd.getStudentBySno(username);
		System.out.println("Service "+st); 
		if(st == null){
			return false;
		}else if(!password.equals(st.getSpassword())){
			System.out.println("ÃÜÂë´íÎó");
			return false;
		}
		return true;
	}
	
}	
