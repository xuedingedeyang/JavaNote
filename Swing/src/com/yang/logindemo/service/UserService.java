package com.yang.logindemo.service;

import com.yang.logindemo.dao.UserDao;
import com.yang.logindemo.entity.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public boolean login(String username,String password){
		User user = userDao.getUser(username);
		System.out.println(user == null);
		if(user == null){
			return false;
		}else{
			return password.equals(user.getPassword());
		}
	}
	
	public boolean isUserExist(String username){
		
		if(userDao.getUser(username)!=null){
			return true;
		}
		return false;
	}
	
	public boolean register(String username,String password){
		if(userDao.addUser(username,password)){
			return true;
		}
		return false;
	}
}
