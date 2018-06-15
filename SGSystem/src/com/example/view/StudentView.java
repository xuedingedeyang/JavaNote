package com.example.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import com.example.bean.STGrade;
import com.example.bean.Student;
import com.example.service.StudentService;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class StudentView implements ActionListener{

	JFrame frame;
	private StudentService stService;
	private String Sno;
	private JTable table;

	/**
	 * Create the application.
	 */
	
	public StudentView(String sno) {
		this.Sno = sno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		stService = new StudentService();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 573, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(48, 62, 40, 15);
		frame.getContentPane().add(label);
		
		JLabel nameLb = new JLabel("\u674E\u7EA2");
		nameLb.setFont(new Font("宋体", Font.BOLD, 13));
		nameLb.setBounds(98, 62, 54, 15);
		frame.getContentPane().add(nameLb);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		label_1.setBounds(199, 62, 40, 15);
		frame.getContentPane().add(label_1);
		
		JLabel snoLb = new JLabel("1607084101");
		snoLb.setFont(new Font("宋体", Font.BOLD, 13));
		snoLb.setBounds(255, 62, 102, 15);
		frame.getContentPane().add(snoLb);
		
		JLabel label_3 = new JLabel("\u7CFB\u522B\uFF1A");
		label_3.setBounds(377, 62, 40, 15);
		frame.getContentPane().add(label_3);
		
		JLabel depLb = new JLabel("SC");
		depLb.setFont(new Font("宋体", Font.BOLD, 13));
		depLb.setBounds(436, 62, 102, 15);
		frame.getContentPane().add(depLb);
		
		
		
		
		Student st = stService.getStudentBySno(Sno);
		nameLb.setText(st.getSname());
		snoLb.setText(st.getSno());
		depLb.setText(st.getStel());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(38, 131, 500, 262);
		frame.getContentPane().add(scrollPane_1);
		frame.setLocationRelativeTo(null);
		
		
		
		Object name[]={"课程","代课教师","成绩"};
		List<STGrade>list = stService.getGrade(Sno);
		Object[][] items = new Object[list.size()][name.length];
		for(int i=0;i<list.size();i++){
			items[i][0] = list.get(i).getCourseName();
			items[i][1] = list.get(i).getTeacherName();
			items[i][2] = list.get(i).getGrade();
			System.out.println(items[i][0].toString()+","+items[i][1].toString()+","+items[i][2].toString());
		}
		table = new JTable(items,name);
		table.setEnabled(false);
		
		scrollPane_1.setViewportView(table);
		
		JButton chooseCourseBtn = new JButton("\u9009\u8BFE");
		chooseCourseBtn.setBounds(436, 413, 93, 23);
		frame.getContentPane().add(chooseCourseBtn);
		chooseCourseBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ChooseCourseView().frame.setVisible(true);;
		this.frame.dispose();
	}
}
