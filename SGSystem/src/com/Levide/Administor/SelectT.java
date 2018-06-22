package com.Levide.Administor;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextArea;

import com.example.bean.Teacher;

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

public class SelectT implements ActionListener{

	public JFrame frame;
	public JTable table;
	private List<Teacher> Teas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectT window = new SelectT();
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
	public SelectT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("查询老师基本信息");
		frame.setBounds(100, 100, 452, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("查询老师基本信息");
		label.setFont(new Font("华文楷体", Font.BOLD, 30));
		label.setBounds(91, 10, 256, 65);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 教师号：");
		label_1.setBounds(30, 89, 64, 15);
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
				String Tno = textArea.getText();
				if(Tno != null) {
					
				}
				else {
					Tno = "%";
				}
				Connection conn = null;	
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					PreparedStatement ps = conn.prepareStatement("select * from Teacher where Tno Like ?");				
					ps.setString(1, Tno+"%");
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
					Teas = new ArrayList<>();
					Teacher tea = null;
					while(rs.next()){
					info[count][0] = rs.getString("Tno");
					info[count][1] = rs.getString("Tname");
					info[count][2] = rs.getString("Tsex");
					info[count][3] = rs.getString("Tpassword");
					info[count][4] = rs.getString("Cno");
					tea = new Teacher(Tno, rs.getString("Tname"), rs.getString("Tsex"), rs.getString("Tpassword"), rs.getString("Cno"));
					Teas.add(tea);
					count++;
					}
					String[] title = {"教师号","教师名","性别","密码","课程号"};
				
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
				Teacher tea;
				for(int i=0;i<table.getRowCount();i++) {
					String tno = table.getValueAt(i, 0).toString();
					String tname = table.getValueAt(i, 1).toString();
					String tsex = table.getValueAt(i, 2).toString();
					String tpassword = table.getValueAt(i, 3).toString();
					String tcno = table.getValueAt(i,4).toString();
					tea = new Teacher(tno,tname,tsex,tpassword,tcno);
					Teas.add(tea);
				}
				Connection conn = null;
				conn = ConnectionFactory.getInstance().makeConnection();
				try {
					
					conn.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				for(Teacher teacher:Teas) {
					try {
						PreparedStatement ps = conn.prepareStatement("update teacher\r\n" + 
								"set Tname = ?,Tsex = ?,Tpassword = ?,Cno = ?\r\n" + 
								"where Tno = ?");				
						ps.setString(5, teacher.getTno());
						ps.setString(1, teacher.getTname());
						ps.setString(2, teacher.getTSex());
						ps.setString(3, teacher.getTpassword());
						ps.setString(4, teacher.getCourse().getCno());
						ps.execute();
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
