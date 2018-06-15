package com.example.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.example.bean.Teacher;

public class MyTableModel extends AbstractTableModel {

	private List<Teacher> teachers;
	Object[] names = {"课程","代课教师","学时","学分","操作"};
	Object[][] items=null;
	Class[] typeArr = {Object.class,Object.class,Object.class,Object.class,Boolean.class};
	public MyTableModel() {
	}

	public MyTableModel(List<Teacher> teachers) {
		super();
		this.teachers = teachers;
		items = new Object[teachers.size()][names.length];
		for(int i=0;i<teachers.size();i++){
			items[i][0] = teachers.get(i).getCourse().getCname();
			items[i][1] = teachers.get(i).getTname();
			items[i][2] = teachers.get(i).getCourse().getCtime();
			items[i][3] = teachers.get(i).getCourse().getCcredit();
			items[i][4] = new Boolean(false);
		}
		
	}

	//获得行数
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return teachers.size();
	}

	//获得列数
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	//获得单元格数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return items[rowIndex][columnIndex];
	}
	
	//除了最后一列，其他都不能编辑
	@Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
		if(columnIndex==4){
			return true;
		}
        return false;  
    }  
	
	//替换单元格数据
	@Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
        items[rowIndex][columnIndex] = aValue;  
        fireTableCellUpdated(rowIndex, columnIndex);  
    } 
	
	public Class getColumnClass(int columnIndex) {  
        return typeArr[columnIndex];// 返回每一列的数据类型  
    }  
	
	@Override  
    public String getColumnName(int column) {  
        return names[column].toString();  
    }  

}
