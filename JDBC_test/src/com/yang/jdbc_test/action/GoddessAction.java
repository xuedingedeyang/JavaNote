package com.yang.jdbc_test.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yang.jdbctest.dao.GoddessDao;
import com.yang.jdbctest.model.Goddess;


public class GoddessAction {

	public static void main(String[] args) throws SQLException {
		GoddessDao g = new GoddessDao();
		List<Goddess> gs = g.query();
		for(Goddess goddess : gs)
		{
			System.out.println(goddess.getUser_name() + "," + goddess.getAge());
		}

	}

}
