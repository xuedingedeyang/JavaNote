package com.example.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.example.bean.Teacher;

public class MyTableModel extends AbstractTableModel {

	private List<Teacher> teachers;
	Object[] names = {"�γ�","���ν�ʦ","ѧʱ","ѧ��","����"};
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

	//�������
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return teachers.size();
	}

	//�������
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	//��õ�Ԫ������
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return items[rowIndex][columnIndex];
	}
	
	//�������һ�У����������ܱ༭
	@Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
		if(columnIndex==4){
			return true;
		}
        return false;  
    }  
	
	//�滻��Ԫ������
	@Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
        items[rowIndex][columnIndex] = aValue;  
        fireTableCellUpdated(rowIndex, columnIndex);  
    } 
	
	public Class getColumnClass(int columnIndex) {  
        return typeArr[columnIndex];// ����ÿһ�е���������  
    }  
	
	@Override  
    public String getColumnName(int column) {  
        return names[column].toString();  
    }  

}
