package com.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.DAO.STDao;
import com.example.bean.Course;
import com.example.bean.ST;
import com.example.bean.Teacher;

public class STService {
	private TeacherService ts = new TeacherService();
	private STDao std = new STDao();
	public boolean addOne(String tno,String sno){
		return false;
	}
	
	public boolean update(List<ST>stList){
		return std.update(stList);
	}
	
	public int addBatch(String sno,List<String>tnos){
//		List<Course>courses = new ArrayList<>();
//		for(Teacher t:teachers){
//			
//			Course c = ts.getTeacherByTno(t.getTno()).getCourse();
//			if(c==null){
//				return 0;
//			}
//			courses.add(c);
//		}
//		for(int i=0;i<courses.size()-1;i++){
//			String cname = courses.get(i).getCname();
//			for(int j=i+1;j<courses.size();j++){
//				if(cname.equals(courses.get(j).getCname())){
//					return -1;
//				}
//				
//			}
//		}
		//?????????¦Ã???????
		if(tnos==null||tnos.size()<=0){
			return 0;
		}
		
		//?????§Ø????????????????????¦Ã?
		List<ST>stList = getSTBySno(sno);
		System.out.println("sno="+sno+"\n"+stList+"\n"+tnos);
		if(stList!=null){
			for(ST st:stList){
				if(tnos.contains(st.getTno())){
					return -1;
				}
			}
		}
		
		//?§Ø??????????????¦Ã???????????
		List<String>courses = new ArrayList<>();
		String cName = null;
		for(String s:tnos){
			cName = ts.getTeacherByTno(s).getCourse().getCname();
			if(courses.contains(cName)){
				return -1;
			}
			courses.add(cName);
		}
		for(String s:tnos){
			std.addOne(sno, s);
		}
		return 1;
	}
	
	//?????????????????????
	public List<ST> getSTByTno(String tno){
		return std.getSTByTno(tno);
	}
	//????????????????????
	public List<ST> getSTBySno(String sno){
		return std.getSTBySno(sno);
	}
	
}
