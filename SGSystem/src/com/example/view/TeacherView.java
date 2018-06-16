package com.example.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.example.service.StudentService;

public class TeacherView {

	private JFrame frame;
	private JTable jtable;
	private JTable table;
	private String tno;
	private StudentService ss;

	/**
	 * Create the application.
	 */
	public TeacherView(String tno) {
		this.tno = tno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ss = new StudentService();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 11));
		frame.setResizable(false);
		frame.setBounds(100, 100, 591, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("姓名");
		l1.setBounds(10, 34, 54, 15);
		frame.getContentPane().add(l1);
		
		JLabel label_1 = new JLabel("\u674E\u9EC4");
		label_1.setFont(new Font("黑体", Font.BOLD, 12));
		label_1.setBounds(61, 34, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel l2 = new JLabel("教师号");
		l2.setBounds(150, 34, 54, 15);
		frame.getContentPane().add(l2);
		
		JLabel label_3 = new JLabel("0001");
		label_3.setFont(new Font("黑体", Font.BOLD, 12));
		label_3.setBounds(214, 34, 54, 15);
		frame.getContentPane().add(label_3);
		
		JLabel l3 = new JLabel("性别");
		l3.setBounds(299, 34, 54, 15);
		frame.getContentPane().add(l3);
		
		JLabel label_5 = new JLabel("\u7537");
		label_5.setFont(new Font("黑体", Font.BOLD, 12));
		label_5.setBounds(351, 34, 54, 15);
		frame.getContentPane().add(label_5);
		
		JLabel l4 = new JLabel("教授课程:");
		l4.setBounds(415, 34, 54, 15);
		frame.getContentPane().add(l4);
		
		JLabel label_7 = new JLabel("\u6570\u636E\u7ED3\u6784");
		label_7.setFont(new Font("黑体", Font.BOLD, 12));
		label_7.setBounds(487, 34, 54, 15);
		frame.getContentPane().add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 129, 536, 259);
		frame.getContentPane().add(scrollPane);
		
		Object[] columns = {"学号","姓名","性别","系别","成绩"};
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("选课学生");
		lblNewLabel.setFont(new Font("楷体", Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(214, 85, 156, 34);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
