package com.Levide.Administor;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextArea;

import com.example.bean.Student;

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

public class SelectS implements ActionListener{

	public JFrame frame;
	public JTable table;
	private List<Student> stus;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectS window = new SelectS();
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
	public SelectS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("查询学生基本信息");
		frame.setBounds(100, 100, 452, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("查询学生基本信息");
		label.setFont(new Font("华文楷体", Font.BOLD, 30));
		label.setBounds(91, 10, 256, 65);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 学  号：");
		label_1.setBounds(40, 89, 54, 15);
		frame.getContentPane().add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(101, 85, 145, 23);
		frame.getContentPane().add(textArea);
		
		ScrollPane scpDemo = new ScrollPane();
		scpDemo.setBounds(22, 136, 393, 192);
		frame.getContentPane().add(scpDemo);
		
		JButton button = new JButton("查询");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Sno = textArea.getText();
				if(Sno != null) {
					
				}
				else {
					Sno = "%";
				}
				Connection conn = null;	
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					PreparedStatement ps = conn.prepareStatement("select * from student where Sno Like ?");				
					ps.setString(1, Sno+"%");
					System.out.println("hello world");
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
					stus = new ArrayList<>();
					Student stu = null;
					while(rs.next()){
					info[count][0] = rs.getString("Sno");
					info[count][1] = rs.getString("Sname");
					info[count][2] = rs.getString("Ssex");
					info[count][3] = rs.getString("Sage");
					info[count][4] = rs.getString("Stel");
					stu = new Student(Sno, rs.getString("Sname"), rs.getString("Ssex"), rs.getString("Sage"), rs.getString("Stel"));
					stus.add(stu);
					count++;
					}
					String[] title = {"学号","姓名","性别","年龄","系别"};
				
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
				Student student;
				for(int i=0;i<table.getRowCount();i++) {
					String sno = table.getValueAt(i, 0).toString();
					String sname = table.getValueAt(i, 1).toString();
					String ssex = table.getValueAt(i, 2).toString();
					String sage = table.getValueAt(i, 3).toString();
					String sdept = table.getValueAt(i,4).toString();
					student = new Student(sno,sname,ssex,sage,sdept);
					stus.add(student);
				}
				Connection conn = null;	
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				for(Student stu:stus) {
					try {
						PreparedStatement ps = conn.prepareStatement("update student " + 
								"set Sname = ?,Sage = ?,Ssex = ?,Stel = ?" + 
								"where Sno = ?");				
						ps.setString(5, stu.getSno());
						ps.setString(1, stu.getSname());
						ps.setString(2, stu.getSage());
						ps.setString(3, stu.getSsex());
						ps.setString(4, stu.getStel());
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
