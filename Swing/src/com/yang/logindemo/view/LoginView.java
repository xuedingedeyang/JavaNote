package com.yang.logindemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.yang.logindemo.service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField userField;
	private JLabel lblPassword;
	private JTextField passwordField;
	private JButton registerBtn;
	private JButton loginBtn;
	private UserService userService;
	private JDialog jDialog;

	/**
	 * Create the frame.
	 */
	
	public LoginView(String username){
		this();
		userField.setText(username);
	}
	public LoginView() {
		setBackground(Color.CYAN);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 309);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setFont(new Font("SimSun", Font.BOLD, 35));
		lblLogin.setBounds(177, 40, 139, 42);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblUsername.setBounds(68, 115, 64, 23);
		contentPane.add(lblUsername);
		
		userField = new JTextField();
		userField.setBounds(177, 117, 191, 21);
		contentPane.add(userField);
		userField.setColumns(10);
		
		lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblPassword.setBounds(68, 167, 64, 23);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(177, 169, 191, 21);
		contentPane.add(passwordField);
		
		registerBtn = new JButton("register");
		registerBtn.addActionListener(this);
		registerBtn.setBounds(68, 217, 93, 23);
		contentPane.add(registerBtn);
		
		loginBtn = new JButton("login");
		loginBtn.setBounds(275, 217, 93, 23);
		loginBtn.addActionListener(this);
		contentPane.add(loginBtn);
		
		userService = new UserService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("register")){
			clickRegister();
		}else{
			clickLogin();
		}
	}

	private void clickRegister() {
		this.dispose();
		new registerView().setVisible(true);
	}

	private void clickLogin() {
		String username = userField.getText();
		String password = passwordField.getText();
		if(username==""||username==null||password==""||password==null){
			JOptionPane.showMessageDialog(contentPane, "pelase input username and password");
		}
		
		if(userService.login(username, password)){
			JOptionPane.showMessageDialog(contentPane, "login success!");
			//
		}else{
			JOptionPane.showMessageDialog(contentPane, "login failed£¬please check username and password");
		}
	}

}
