package com.yang.logindemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.yang.logindemo.service.UserService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class registerView extends JFrame implements ActionListener{
	private JTextField userField;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private UserService userService;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public registerView() {
		setBackground(Color.CYAN);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 309);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblUsername.setBounds(62, 83, 91, 19);
		contentPane.add(lblUsername);
		
		userField = new JTextField();
		userField.setBounds(163, 83, 178, 21);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblPassword.setBounds(62, 125, 91, 19);
		contentPane.add(lblPassword);
		
		JLabel lblConfirm = new JLabel("input again");
		lblConfirm.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblConfirm.setBounds(62, 165, 91, 19);
		contentPane.add(lblConfirm);
		
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.setBounds(45, 219, 93, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(this);
		
		JButton confrimBtn = new JButton("confirm");
		confrimBtn.setBounds(296, 219, 93, 23);
		contentPane.add(confrimBtn);
		confrimBtn.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 125, 178, 21);
		contentPane.add(passwordField);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(163, 165, 178, 21);
		contentPane.add(passwordField2);
		
		userService = new UserService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cancel")){
			this.dispose();
			new LoginView().setVisible(true);
		}else{
			String username = userField.getText();
			String password = passwordField.getText();
			String password2 = passwordField2.getText();
			if(username.equals("")||username==null){
				JOptionPane.showMessageDialog(this, "please input username");
			}
			
			if(password.equals(password2)){
				if(userService.isUserExist(username)){
					JOptionPane.showMessageDialog(this, "username have already exist,please choose another");
					userField.setText("");
				}else{
					if(userService.register(username,password)){
						if(JOptionPane.showConfirmDialog(this, "register success,Let's go to login!")==JOptionPane.YES_OPTION){
							this.dispose();
							new LoginView(username).setVisible(true);
						}
					}
				}
			}else{
				JOptionPane.showMessageDialog(this, "the two passwords differ!");
			}
		}
		
	}
}
