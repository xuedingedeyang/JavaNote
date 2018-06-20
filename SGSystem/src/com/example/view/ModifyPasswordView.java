package com.example.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import com.example.bean.Student;
import com.example.bean.Teacher;
import com.example.service.StudentService;
import com.example.service.TeacherService;

import javax.swing.JButton;

public class ModifyPasswordView implements ActionListener {

	JFrame frame;
	private JPasswordField oldPassFiled;
	private JPasswordField newPassFiled;
	private JPasswordField confirmPassFiled;
	private JLabel lblNewLabel;
	private Student stu;
	private Teacher teacher;
	private JButton commitBtn;
	private StudentService studentService;
	private TeacherService teacherService;
	private JButton backBtn;

	/**
	 * Create the application.
	 */
	public ModifyPasswordView(Student stu,Teacher teacher) {
		this.stu = stu;
		this.teacher = teacher;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		studentService = new StudentService();
		teacherService = new TeacherService();
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lbll = new JLabel("旧密码:");
		lbll.setBounds(126, 102, 54, 15);
		frame.getContentPane().add(lbll);
		
		oldPassFiled = new JPasswordField();
		oldPassFiled.setBounds(190, 99, 204, 21);
		frame.getContentPane().add(oldPassFiled);
		
		JLabel label = new JLabel("新密码:");
		label.setBounds(126, 174, 54, 15);
		frame.getContentPane().add(label);
		
		newPassFiled = new JPasswordField();
		newPassFiled.setBounds(190, 171, 204, 21);
		frame.getContentPane().add(newPassFiled);
		
		JLabel lb = new JLabel("确认密码:");
		lb.setBounds(126, 252, 54, 15);
		frame.getContentPane().add(lb);
		
		confirmPassFiled = new JPasswordField();
		confirmPassFiled.setBounds(190, 249, 204, 21);
		frame.getContentPane().add(confirmPassFiled);
		
		lblNewLabel = new JLabel("修改密码");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 27, 204, 28);
		frame.getContentPane().add(lblNewLabel);
		
		commitBtn = new JButton("提交");
		commitBtn.setBounds(358, 302, 93, 23);
		frame.getContentPane().add(commitBtn);
		
		backBtn = new JButton("退出");
		backBtn.setBounds(88, 302, 93, 23);
		frame.getContentPane().add(backBtn);
		commitBtn.addActionListener(this);
		backBtn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("提交")){
			String username = "";
			String newPassword = newPassFiled.getText();
			String confirmPassword = confirmPassFiled.getText();
			if(stu!=null){
				username = stu.getSno();
				Student student = studentService.getStudentBySno(username);
				if(student.getSpassword().equals(oldPassFiled.getText())){
					if(newPassword.equals(confirmPassword)){
						//更新学生信息
						student.setSpassword(newPassword);
						if(studentService.updateStudent(student)){
							JOptionPane.showMessageDialog(this.frame, "修改成功！");
							new StudentView(stu.getSno()).frame.setVisible(true);
							this.frame.dispose();
						}else{
							JOptionPane.showMessageDialog(this.frame, "修改失败");
						}
					}else{
						JOptionPane.showMessageDialog(this.frame, "两次输入的密码不一致");
					}
				}else{
					JOptionPane.showMessageDialog(this.frame, "旧密码错误");
				}
			}else if(teacher!=null){
				username = teacher.getTno();
				Teacher teacher = teacherService.getTeacherByTno(username);
				if(teacher.getTpassword().equals(oldPassFiled.getText())){
					if(newPassword.equals(confirmPassword)){
						//更新老师信息
						teacher.setTpassword(newPassword);
						if(teacherService.updateTeacher(teacher)){
							JOptionPane.showMessageDialog(this.frame, "修改成功");
							new TeacherView(teacher.getTno()).frame.setVisible(true);
							this.frame.dispose();
						}else{
							JOptionPane.showMessageDialog(this.frame, "修改失败");
						}
					}else{
						JOptionPane.showMessageDialog(this.frame, "两次输入的密码不一致");
					}
				}else{
					JOptionPane.showMessageDialog(this.frame, "旧密码错误");
				}
			}
		}else if(e.getActionCommand().equals("退出")){
			if(stu!=null){
				new StudentView(stu.getSno()).frame.setVisible(true);
			}else{
				new TeacherView(teacher.getTno()).frame.setVisible(true);
			}
			this.frame.dispose();
		}
		
		
	}
}
