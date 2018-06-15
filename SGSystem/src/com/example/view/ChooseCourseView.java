package com.example.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Checkbox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.example.bean.Course;
import com.example.bean.Teacher;
import com.example.service.CourseService;
import com.example.service.TeacherService;
import com.example.util.MyTableModel;

import java.awt.Color;
import javax.swing.JButton;

public class ChooseCourseView implements ActionListener{

	JFrame frame;
	private JTable table;
	private CourseService cs;
	private TeacherService ts;

	/**
	 * Create the application.
	 */
	public ChooseCourseView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cs = new CourseService();
		ts = new TeacherService();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 582, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 27, 513, 308);
		scrollPane.setVisible(true);
		frame.getContentPane().add(scrollPane);
		
		List<Teacher>list = ts.getAllTeacher();
		if(list.size()==0||list==null){
			JOptionPane.showMessageDialog(this.frame, "查不到课程");
		}
		
//		Object[] names = {"课程","代课教师","学时","学分","操作"};
//		Object[][] items = new Object[list.size()][names.length];
//		for(int i=0;i<list.size();i++){
//			items[i][0] = list.get(i).getCourse().getCname();
//			items[i][1] = list.get(i).getTname();
//			items[i][2] = list.get(i).getCourse().getCtime();
//			items[i][3] = list.get(i).getCourse().getCcredit();
//			System.out.println(items[i][0]+","+items[i][1]);
//		}
		MyTableModel model = new MyTableModel(list);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.CYAN);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setVisible(true);
		scrollPane.setViewportView(table);
		
		JButton confirmBtn = new JButton("\u786E\u8BA4");
		confirmBtn.setBounds(373, 364, 93, 23);
		frame.getContentPane().add(confirmBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

