package com.example.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.example.bean.ST;

public class TeacherTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4739798102211381912L;

	private List<ST> stList;
	Object[] names = {"学号","姓名","性别","系别","成绩"};
	Object[][] items=null;
	Class[] typeArr = {Object.class,Object.class,Object.class,Object.class,Float.class};
	
	
	
//	
//	public TeacherTableModel(List<ST> stList) {
//		this.stList = stList;
//		items = new Object[stList.size()][names.length];
//		for(int i=0;i<stList.size();i++){
//			items[i][0] = 
//		}
//	}
	
	

	public TeacherTableModel() {
		
	}



	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
