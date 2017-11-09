package com.yang.jdbc_test.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yang.jdbctest.dao.GoddessDao;
import com.yang.jdbctest.model.Goddess;


public class GoddessAction {

	public static void main(String[] args) throws Exception {
		GoddessDao g = new GoddessDao();
		
		List<Map<String, Object>>params = new ArrayList<>();
		Map<String,Object>param = new HashMap<>();
		param.put("name", "user_name");
		param.put("rela", "like");
		param.put("value", "'%ÕÔ%'");
		params.add(param);
		param = new HashMap<>();
		param.put("name", "mobile");
		param.put("rela", "=");
		param.put("value", "18406587309");
		params.add(param);
		
		
//		Goddess g1 = new Goddess();
//		Goddess g2 = null;
//		g1.setId(2);
//		g1.setUser_name("¹«ËïÂÌÝà");
//		g1.setAge(19);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("gongsun@gmail.com");
//		g1.setMobile("123456789");
//		g1.setUpdate_user("yang1");
//		g1.setIsdel(1);
		
//		g.delGoddess(2);
//		g.updateGoddess(g1);
//		g.addGoddess(g1);
//		g2 = g.get(3);
		for(Goddess temp:g.query(params))
		{
			System.out.println(temp.toString());
		}
		
	}

}
