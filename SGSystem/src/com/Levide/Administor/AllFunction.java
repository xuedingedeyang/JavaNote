package com.Levide.Administor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.example.view.LoginView;

import java.awt.Font;

public class AllFunction implements ActionListener {

	public JFrame frame;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllFunction window = new AllFunction();
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
	public AllFunction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("欢迎您，请选择功能：");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("增加信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InsertS window = new InsertS();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(53, 41, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询更改信息");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SelectS window = new SelectS();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(166, 41, 121, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_2 = new JButton("增加信息");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InsertT window = new InsertT();
				window.frame.setVisible(true);
			}
		});
		button_2.setBounds(53, 114, 93, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_5 = new JButton("查询更改信息");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SelectT window = new SelectT();
				window.frame.setVisible(true);
			}
		});
		button_5.setBounds(166, 114, 121, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("增加信息");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InsertC window = new InsertC();
				window.frame.setVisible(true);
			}
		});
		button_6.setBounds(53, 192, 93, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_9 = new JButton("查询更改信息");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SelectC window = new SelectC();
				window.frame.setVisible(true);
			}
		});
		button_9.setBounds(166, 192, 121, 23);
		frame.getContentPane().add(button_9);
		
		JLabel label = new JLabel("学生信息管理");
		label.setFont(new Font("华文楷体", Font.BOLD, 16));
		label.setBounds(26, 10, 114, 21);
		frame.getContentPane().add(label);
		
		JLabel label_3 = new JLabel("老师信息管理");
		label_3.setFont(new Font("华文楷体", Font.BOLD, 16));
		label_3.setBounds(26, 83, 114, 21);
		frame.getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel("课程信息管理");
		label_1.setFont(new Font("华文楷体", Font.BOLD, 16));
		label_1.setBounds(26, 161, 114, 21);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("删除信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DeleteS window = new DeleteS();
				window.frame.setVisible(true);
			}
		});
		button.setBounds(303, 41, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("删除信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DeleteT window = new DeleteT();
				window.frame.setVisible(true);
			}
		});
		button_1.setBounds(303, 114, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_3 = new JButton("删除信息");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DeleteC window = new DeleteC();
				window.frame.setVisible(true);
			}
		});
		button_3.setBounds(303, 192, 93, 23);
		frame.getContentPane().add(button_3);
		
		JButton backBtn = new JButton("返回");
		backBtn.addActionListener(this);
		backBtn.setBounds(303, 225, 93, 23);
		frame.getContentPane().add(backBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("返回")){
			new LoginView().frame.setVisible(true);
			this.frame.dispose();
		}
		
	}
}
