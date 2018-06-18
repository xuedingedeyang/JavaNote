package com.example.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import com.example.service.STService;
import com.example.service.TeacherService;
import com.example.util.MyTableModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ChooseCourseView implements ActionListener{

	JFrame frame;
	private JTable table;
	private CourseService cs;
	private TeacherService ts;
	private STService stService;
	private String sno;
	MyTableModel model;
	List<Teacher>teachers = null;

	/**
	 * Create the application.
	 */
	public ChooseCourseView(String sno) {
		this.sno = sno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cs = new CourseService();
		ts = new TeacherService();
		stService = new STService();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 582, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.frame.setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 27, 513, 308);
		scrollPane.setVisible(true);
		frame.getContentPane().add(scrollPane);
		
		teachers = ts.getAllTeacher();
		if(teachers.size()==0||teachers==null){
			JOptionPane.showMessageDialog(this.frame, "查不到课程");
		}
		

		model = new MyTableModel(teachers);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.CYAN);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setVisible(true);
		scrollPane.setViewportView(table);
		
		JButton confirmBtn = new JButton("确认");
		confirmBtn.setBounds(373, 364, 93, 23);
		confirmBtn.addActionListener(this);
		frame.getContentPane().add(confirmBtn);
		
		JButton backBtn = new JButton("返回");
		backBtn.setBounds(40, 364, 93, 23);
		frame.getContentPane().add(backBtn);
		backBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确认")){
			List<String> tnos = new ArrayList<>();
			for(int i=0;i<model.getRowCount();i++){
				System.out.println( model.getValueAt(i, model.getColumnCount()-1));
				if((boolean) model.getValueAt(i, model.getColumnCount()-1)){
					tnos.add(teachers.get(i).getTno());
				}
			}
			int a = stService.addBatch(sno, tnos);
			if(a==1){
				JOptionPane.showMessageDialog(this.frame, "选课成功！");
				new StudentView(sno).frame.setVisible(true);
				this.frame.dispose();
			}else if(a==-1){
				JOptionPane.showMessageDialog(this.frame, "选课失败，检查是否重复选择了课程!");
			}else if(a==0){
				JOptionPane.showMessageDialog(this.frame, "请选择课程!");
			}
		}else if(e.getActionCommand().equals("返回")){
			new StudentView(sno).frame.setVisible(true);
			this.frame.dispose();
		}
		
		
	}
}

