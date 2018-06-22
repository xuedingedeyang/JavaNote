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
		frame = new JFrame("��ӭ������ѡ���ܣ�");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("������Ϣ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InsertS window = new InsertS();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(53, 41, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("��ѯ������Ϣ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SelectS window = new SelectS();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(166, 41, 121, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_2 = new JButton("������Ϣ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InsertT window = new InsertT();
				window.frame.setVisible(true);
			}
		});
		button_2.setBounds(53, 114, 93, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_5 = new JButton("��ѯ������Ϣ");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SelectT window = new SelectT();
				window.frame.setVisible(true);
			}
		});
		button_5.setBounds(166, 114, 121, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("������Ϣ");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InsertC window = new InsertC();
				window.frame.setVisible(true);
			}
		});
		button_6.setBounds(53, 192, 93, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_9 = new JButton("��ѯ������Ϣ");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SelectC window = new SelectC();
				window.frame.setVisible(true);
			}
		});
		button_9.setBounds(166, 192, 121, 23);
		frame.getContentPane().add(button_9);
		
		JLabel label = new JLabel("ѧ����Ϣ����");
		label.setFont(new Font("���Ŀ���", Font.BOLD, 16));
		label.setBounds(26, 10, 114, 21);
		frame.getContentPane().add(label);
		
		JLabel label_3 = new JLabel("��ʦ��Ϣ����");
		label_3.setFont(new Font("���Ŀ���", Font.BOLD, 16));
		label_3.setBounds(26, 83, 114, 21);
		frame.getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel("�γ���Ϣ����");
		label_1.setFont(new Font("���Ŀ���", Font.BOLD, 16));
		label_1.setBounds(26, 161, 114, 21);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("ɾ����Ϣ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DeleteS window = new DeleteS();
				window.frame.setVisible(true);
			}
		});
		button.setBounds(303, 41, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("ɾ����Ϣ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DeleteT window = new DeleteT();
				window.frame.setVisible(true);
			}
		});
		button_1.setBounds(303, 114, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_3 = new JButton("ɾ����Ϣ");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DeleteC window = new DeleteC();
				window.frame.setVisible(true);
			}
		});
		button_3.setBounds(303, 192, 93, 23);
		frame.getContentPane().add(button_3);
		
		JButton backBtn = new JButton("����");
		backBtn.addActionListener(this);
		backBtn.setBounds(303, 225, 93, 23);
		frame.getContentPane().add(backBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")){
			new LoginView().frame.setVisible(true);
			this.frame.dispose();
		}
		
	}
}
