package com.example.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.example.service.LoginService;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LoginView implements ActionListener{

	public JFrame frame;
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton adminRadio;
	private JRadioButton studentRadio;
	private JRadioButton teacherRadio;
	private JTextPane usernameText;
	private JPasswordField passwordField;
	private LoginService loginServce;


	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 522, 338);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ѧ���ɼ�����ϵͳ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("���Ŀ���", Font.BOLD, 13));
		label.setBounds(176, 32, 161, 51);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setBounds(90, 103, 54, 15);
		frame.getContentPane().add(label_1);
		
		usernameText = new JTextPane();
		usernameText.setBounds(144, 97, 242, 21);
		frame.getContentPane().add(usernameText);
		
		JLabel label_2 = new JLabel("����");
		label_2.setBounds(90, 145, 54, 15);
		frame.getContentPane().add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 142, 242, 21);
		frame.getContentPane().add(passwordField);
		
		adminRadio = new JRadioButton("����Ա");
		adminRadio.setBounds(68, 206, 82, 23);
		frame.getContentPane().add(adminRadio);
		
		teacherRadio = new JRadioButton("��ʦ");
		teacherRadio.setBounds(205, 206, 82, 23);
		frame.getContentPane().add(teacherRadio);
		
		studentRadio = new JRadioButton("ѧ��");
		studentRadio.setBounds(351, 206, 82, 23);
		frame.getContentPane().add(studentRadio);
		
		
		bg.add(studentRadio);
		bg.add(teacherRadio);
		bg.add(adminRadio);
		
		JButton quitBtn = new JButton("�˳�");
		quitBtn.addActionListener(this);
		quitBtn.setBounds(90, 261, 93, 23);
		frame.getContentPane().add(quitBtn);
		
		JButton loginBtn = new JButton("��¼");
		loginBtn.setBounds(308, 261, 93, 23);
		loginBtn.addActionListener(this);
		frame.getContentPane().add(loginBtn);
		loginServce = new LoginService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�˳�")){
			this.dispose();
		}else{
			String username = usernameText.getText();
			String password = passwordField.getText();
			System.out.println("View "+password);
			if(adminRadio.isSelected()){
				//����Ա��¼
				System.out.println("����Ա");
				
			}else if(studentRadio.isSelected()){
				if(loginServce.studentLogin(username, password)){
					System.out.println("��¼�ɹ�");
					
					this.close();
				}else{
					System.out.println("��¼ʧ��");
				}
			}else{
				
				System.out.println("��ʦ");
			}
		}
	}

	private void close() {
		this.frame.dispose();
		
	}
}
