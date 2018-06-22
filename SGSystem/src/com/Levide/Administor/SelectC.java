package com.Levide.Administor;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextArea;

import com.example.bean.Course;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectC implements ActionListener{

	public JFrame frame;
	public JTable table;
	private List<Course> cours;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectC window = new SelectC();
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
	public SelectC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("查询课程基本信息");
		frame.setBounds(100, 100, 452, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("查询课程基本信息");
		label.setFont(new Font("华文楷体", Font.BOLD, 30));
		label.setBounds(91, 10, 256, 65);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 课程号：");
		label_1.setBounds(40, 85, 61, 19);
		frame.getContentPane().add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(111, 85, 135, 23);
		frame.getContentPane().add(textArea);
		
		ScrollPane scpDemo = new ScrollPane();
		scpDemo.setBounds(22, 136, 393, 192);
		frame.getContentPane().add(scpDemo);
		
		JButton button = new JButton("查询");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Cno = textArea.getText();
				if(Cno != null) {
					
				}
				else {
					Cno = "%";
				}
				Connection conn = null;	
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					PreparedStatement ps = conn.prepareStatement("select * from course where Cno Like ?");				
					ps.setString(1, Cno+"%");
					ps.execute();
					conn.commit();					
					
					ResultSet rs = ps.executeQuery();
					int count = 0;
					while(rs.next()){
					count++;
					}
					rs = ps.executeQuery();
					Object[][] info = new Object[count][5];
					count = 0;
					cours = new ArrayList<>();
					Course cour = null;
					while(rs.next()){
					info[count][0] = rs.getString("Cno");
					info[count][1] = rs.getString("Cname");
					info[count][2] = rs.getString("Ctime");
					info[count][3] = rs.getString("Ccredit");
					cour = new Course(Cno, rs.getString("Cname"), rs.getString("Ctime"), rs.getString("Ccredit"));
					cours.add(cour);
					count++;
					}
					String[] title = {"课程号","课程名","课时","学分"};
				
					table = new JTable(info,title);
     				table.getTableHeader(); 				
     				scpDemo.add(table);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					JOptionPane.showMessageDialog(null, "请输入正确的数据", "查询错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
		button.setBounds(295, 85, 64, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(this);
		button_1.setBounds(283, 347, 64, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_3 = new JButton("保存");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Course course;
				for(int i=0;i<table.getRowCount();i++) {
					String cno = table.getValueAt(i, 0).toString();
					String cname = table.getValueAt(i, 1).toString();
					String ctime = table.getValueAt(i, 2).toString();
					String ccredit = table.getValueAt(i, 3).toString();
					course = new Course(cno,cname,ctime,ccredit);
					cours.add(course);
				}
				Connection conn = null;	
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				for(Course cour:cours) {
					try {
						PreparedStatement ps = conn.prepareStatement("update course\r\n" + 
								"set Cname = ?,Ctime = ?,Ccredit = ?\r\n" +
								"where Cno = ?");				
						ps.setString(4, cour.getCno());
						ps.setString(1, cour.getCname());
						ps.setString(2, cour.getCtime());
						ps.setString(3, cour.getCcredit());
						ps.execute();
						conn.commit();
					} catch (SQLException e1) {
						try {
							conn.rollback();
							JOptionPane.showMessageDialog(null, "请检查所输入的数据", "更新错误", JOptionPane.ERROR_MESSAGE);
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(frame,"保存成功");
			}
		});
		button_3.setBounds(106, 347, 93, 23);
		frame.getContentPane().add(button_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("退出")){
			new AllFunction().frame.setVisible(true);
			this.frame.dispose();
		}
		
	}

	
}
