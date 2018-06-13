package com.example.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

import com.example.service.StudentService;

import javax.swing.JPanel;

public class StudentView {

	private JFrame frame;
	private JTable table;
	private StudentService stService;
	private String Sno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView window = new StudentView();
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
	public StudentView() {
		initialize();
	}
	
	public StudentView(String sno) {
		this();
		this.Sno = sno;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JLabel label_2 = new JLabel("1607084101");
		label_2.setFont(new Font("宋体", Font.BOLD, 13));
		label_2.setBounds(255, 62, 102, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7CFB\u522B\uFF1A");
		label_3.setBounds(377, 62, 40, 15);
		frame.getContentPane().add(label_3);
		
		JLabel lblSc = new JLabel("SC");
		lblSc.setFont(new Font("宋体", Font.BOLD, 13));
		lblSc.setBounds(436, 62, 102, 15);
		frame.getContentPane().add(lblSc);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 87, 557, 325);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		table = new JTable();
		
		Object name[]={"课程","代课教师","成绩"};
		
		panel.add(table);
	}
}
