package com.example.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.example.bean.Course;
import com.example.service.CourseService;
import com.example.service.TeacherService;

public class ChooseCourseView {

	private JFrame frame;
	private JTable table;
	private CourseService cs;
	private TeacherService ts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseCourseView window = new ChooseCourseView();
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
	public ChooseCourseView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cs = new CourseService();
		ts = new TeacherService();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 582, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 373, 513, -344);
		frame.getContentPane().add(scrollPane);
		
		List<Course>list = cs.getAllCourse();
		Object[] names = {"课程","代课教师","学时","学分"};
		Object[][] items = new Object[list.size()][names.length];
		while()
		table = new JTable();
		table.setBounds(275, 176, 1, 1);
		scrollPane.add(table);
	}
}
