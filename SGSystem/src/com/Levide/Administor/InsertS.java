package com.Levide.Administor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextArea;

import com.example.bean.Student;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertS implements ActionListener {

	public JFrame frame;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JRadioButton radioButton;
	private JRadioButton radioButton1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertS window = new InsertS();
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
	public InsertS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加学生基本信息");
		frame.setBounds(100, 100, 465, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("添加学生基本信息");
		label.setFont(new Font("华文楷体", Font.BOLD, 30));
		label.setBounds(83, 10, 264, 59);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 学  号：");
		label_1.setBounds(68, 81, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(" 姓  名：");
		label_2.setBounds(68, 121, 54, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(" 性  别：");
		label_3.setBounds(68, 164, 54, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(" 系  别：");
		label_4.setBounds(68, 197, 54, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(" 年  龄：");
		label_5.setBounds(68, 240, 54, 15);
		frame.getContentPane().add(label_5);
		
		textArea = new JTextArea();
		textArea.setBounds(132, 77, 246, 23);
		frame.getContentPane().add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(132, 117, 246, 23);
		frame.getContentPane().add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(132, 193, 246, 23);
		frame.getContentPane().add(textArea2);
		
		textArea3 = new JTextArea();
		textArea3.setBounds(132, 236, 246, 23);
		frame.getContentPane().add(textArea3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		radioButton = new JRadioButton("男");
		radioButton.setBounds(165, 160, 54, 23);
		frame.getContentPane().add(radioButton);
		buttonGroup.add(radioButton);
		
		radioButton1 = new JRadioButton("女");
		radioButton1.setBounds(254, 160, 54, 23);
		frame.getContentPane().add(radioButton1);
		buttonGroup.add(radioButton1);
		
		JButton button = new JButton("提交");
		button.addActionListener(this);
		
		button.setBounds(132, 315, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(this);
		button_1.setBounds(254, 315, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_6 = new JLabel(" 密  码：");
		label_6.setBounds(68, 282, 54, 15);
		frame.getContentPane().add(label_6);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(132, 276, 246, 23);
		frame.getContentPane().add(textArea_4);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("退出")){
			new AllFunction().frame.setVisible(true);
			this.frame.dispose();
		}else if(e.getActionCommand().equals("提交")){
			String Sno = textArea.getText();
			String Sname = textArea1.getText();
			String Ssex = "";
			if(radioButton.isSelected()) {
				Ssex = radioButton.getText();
			}
			else {
				Ssex = radioButton1.getText();
			}
			String Sage = textArea2.getText();
			String Stel = textArea3.getText();
			Student student = new Student(Sno,Sname,Ssex,Sage,Stel,"123456");
			
			Connection conn = null;	
			conn = ConnectionFactory.getInstance().makeConnection();
			try {
				
				conn.setAutoCommit(false);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				PreparedStatement ps = conn.prepareStatement("insert into student(Sno,Sname,Ssex,Sage,Stel,Spassword) values(?,?,?,?,?,?)");				
				ps.setString(1, student.getSno());
				ps.setString(2, student.getSname());
				ps.setString(3, student.getSsex());
				ps.setString(4, student.getSage());
				ps.setString(5, student.getStel());
				ps.setString(6, student.getSpassword());
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
