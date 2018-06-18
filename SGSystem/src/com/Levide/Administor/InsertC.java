package com.Levide.Administor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;

import com.example.bean.Course;

import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertC implements ActionListener {

	public JFrame frame;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertC window = new InsertC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加课程基本信息");
		frame.setBounds(100, 100, 465, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("添加课程基本信息");
		label.setFont(new Font("华文楷体", Font.BOLD, 30));
		label.setBounds(83, 10, 264, 59);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 课  号：");
		label_1.setBounds(68, 81, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(" 课  名：");
		label_2.setBounds(68, 121, 54, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(" 学  时：");
		label_3.setBounds(68, 164, 54, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(" 学  分：");
		label_4.setBounds(68, 204, 54, 15);
		frame.getContentPane().add(label_4);
		
		textArea = new JTextArea();
		textArea.setBounds(132, 77, 246, 31);
		frame.getContentPane().add(textArea);
		
	    textArea1 = new JTextArea();
		textArea1.setBounds(132, 117, 246, 31);
		frame.getContentPane().add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(132, 160, 246, 31);
		frame.getContentPane().add(textArea2);
		
		textArea3 = new JTextArea();
		textArea3.setBounds(132, 200, 246, 31);
		frame.getContentPane().add(textArea3);
		
		
		JButton button = new JButton("提交");
		button.addActionListener(this);
		
		button.setBounds(132, 267, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(this);
		button_1.setBounds(254, 267, 93, 23);
		frame.getContentPane().add(button_1);
		

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("退出")){
			new AllFunction().frame.setVisible(true);
			this.frame.dispose();
		}else if(e.getActionCommand().equals("提交")){
			String Cno = textArea.getText();
			String Cname = textArea1.getText();
			String Ctime = textArea2.getText();
			
			String Credit = textArea3.getText();
			Course course = new Course(Cno,Cname,Ctime,Credit);
			
			Connection conn = null;	
			conn = ConnectionFactory.getInstance().makeConnection();
			try {
				
				conn.setAutoCommit(false);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");				
				ps.setString(1, course.getCno());
				ps.setString(2, course.getCname());
				ps.setString(3, course.getCtime());
				ps.setString(4, course.getCcredit());
				ps.executeUpdate();
				conn.commit();
			} catch (SQLException e1) {
				try {
					conn.rollback();
					JOptionPane.showMessageDialog(null, "请检查所输入的数据", "插入错误", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				e1.printStackTrace();
			}
		}
		
	}
}
