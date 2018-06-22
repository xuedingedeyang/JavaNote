package com.Levide.Administor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;

import com.example.bean.Teacher;

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

public class InsertT implements ActionListener {

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
					InsertT window = new InsertT();
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
	public InsertT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加老师基本信息");
		frame.setBounds(100, 100, 465, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("添加老师基本信息");
		label.setFont(new Font("华文楷体", Font.BOLD, 30));
		label.setBounds(83, 10, 264, 59);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 教师号：");
		label_1.setBounds(68, 81, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(" 姓  名：");
		label_2.setBounds(68, 121, 54, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(" 性  别：");
		label_3.setBounds(68, 164, 54, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(" 密  码：");
		label_4.setBounds(68, 204, 54, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(" 课程号：");
		label_5.setBounds(68, 247, 54, 15);
		frame.getContentPane().add(label_5);
		
		textArea = new JTextArea();
		textArea.setBounds(132, 77, 246, 31);
		frame.getContentPane().add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(132, 117, 246, 31);
		frame.getContentPane().add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(132, 200, 246, 31);
		frame.getContentPane().add(textArea2);
		
		textArea3 = new JTextArea();
		textArea3.setBounds(132, 243, 246, 31);
		frame.getContentPane().add(textArea3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		final JRadioButton radioButton = new JRadioButton("男");
		radioButton.setBounds(165, 160, 54, 23);
		frame.getContentPane().add(radioButton);
		buttonGroup.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.setBounds(254, 160, 54, 23);
		frame.getContentPane().add(radioButton_1);
		buttonGroup.add(radioButton_1);
		
		JButton button = new JButton("提交");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Tno = textArea.getText();
				String Tname = textArea1.getText();
				String Tsex = "";
				if(radioButton.isSelected()) {
					Tsex = radioButton.getText();
				}
				else {
					Tsex = radioButton_1.getText();
				}
				String Tpassword = textArea2.getText();
				String Tcno = textArea3.getText();
				Teacher teacher = new Teacher(Tno,Tname,Tsex,Tpassword,Tcno);
				
				Connection conn = null;	
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					PreparedStatement ps = conn.prepareStatement("insert into teacher values(?,?,?,?,?)");				
					ps.setString(1, teacher.getTno());
					ps.setString(2, teacher.getTname());
					ps.setString(3, teacher.getTSex());
					ps.setString(4, teacher.getTpassword());
					ps.setString(5, teacher.getCourse().getCno());
					ps.executeUpdate();
					conn.commit();
					JOptionPane.showMessageDialog(frame,"保存成功");
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
		});
		
		button.setBounds(132, 315, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(this);
		button_1.setBounds(254, 315, 93, 23);
		frame.getContentPane().add(button_1);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("退出")){
			new AllFunction().frame.setVisible(true);
			this.frame.dispose();
		}
		
	}
}
