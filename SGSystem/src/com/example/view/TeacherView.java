package com.example.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.example.bean.ST;
import com.example.bean.Student;
import com.example.service.STService;
import com.example.service.StudentService;
import com.example.service.TeacherService;

import javax.swing.JButton;

public class TeacherView implements ActionListener{

	JFrame frame;
	private JTable table;
	private String tno;
	private StudentService ss;
	private STService sts;
	private List<ST> stList;
	private TeacherService teacherService;

	/**
	 * Create the application.
	 */
	public TeacherView(String tno) {
		this.tno = tno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ss = new StudentService();
		sts = new STService();
		teacherService = new TeacherService();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("����", Font.PLAIN, 11));
		frame.setResizable(false);
		frame.setBounds(100, 100, 591, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("����");
		l1.setBounds(10, 34, 54, 15);
		frame.getContentPane().add(l1);
		
		JLabel nameLb = new JLabel();
		nameLb.setFont(new Font("����", Font.BOLD, 12));
		nameLb.setBounds(61, 34, 54, 15);
		nameLb.setText(teacherService.getTeacherByTno(tno).getTname());
		frame.getContentPane().add(nameLb);
		
		JLabel l2 = new JLabel("��ʦ��");
		l2.setBounds(150, 34, 54, 15);
		frame.getContentPane().add(l2);
		
		JLabel tnoLb = new JLabel();
		tnoLb.setFont(new Font("����", Font.BOLD, 12));
		tnoLb.setBounds(214, 34, 54, 15);
		tnoLb.setText(tno);
		frame.getContentPane().add(tnoLb);
		
		JLabel l3 = new JLabel("�Ա�");
		l3.setBounds(299, 34, 54, 15);
		frame.getContentPane().add(l3);
		
		JLabel sexLb = new JLabel();
		sexLb.setFont(new Font("����", Font.BOLD, 12));
		sexLb.setBounds(351, 34, 54, 15);
		sexLb.setText(teacherService.getTeacherByTno(tno).getTSex());
		frame.getContentPane().add(sexLb);
		
		JLabel l4 = new JLabel("���ڿγ�:");
		l4.setBounds(415, 34, 54, 15);
		frame.getContentPane().add(l4);
		
		JLabel courseLb = new JLabel();
		courseLb.setFont(new Font("����", Font.BOLD, 12));
		courseLb.setBounds(487, 34, 54, 15);
		courseLb.setText(teacherService.getTeacherByTno(tno).getCourse().getCname());
		frame.getContentPane().add(courseLb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 129, 536, 229);
		frame.getContentPane().add(scrollPane);
		
		Object[] columns = {"ѧ��","����","�Ա�","ϵ��","�ɼ�"};//����
		stList = sts.getSTByTno(tno);//��ȡ��ʦѧ����
		//����û��ѧ��ѡ�����ʦ�Ŀγ̣�Ϊ�ղ�����
		if(stList!=null){
			Object[][] items = new Object[stList.size()][columns.length];
			Student stu;
			System.out.println(stList);
			//����װ��
			for(int i=0;i<stList.size();i++){
				System.out.println(stList.get(i).getSno());
				stu = ss.getStudentBySno(stList.get(i).getSno());
				items[i][0] = stu.getSno();
				items[i][1] = stu.getSname();
				items[i][2] = stu.getSsex();
				items[i][3] = stu.getSsex();
				items[i][4] = stList.get(i).getGrade();
			}
			
			DefaultTableModel defaultModel = new DefaultTableModel(items, columns){
				
				Class[] typeArr = {Object.class,Object.class,Object.class,Object.class,Float.class};
				
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return column==4 ? true : false;
				}
				
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					// TODO Auto-generated method stub
					return typeArr[columnIndex];
				}
			};
			
			table = new JTable(defaultModel);
			
			scrollPane.setViewportView(table);
		}
		
		JLabel lblNewLabel = new JLabel("ѡ��ѧ��");
		lblNewLabel.setFont(new Font("����", Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(214, 85, 156, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton updateBtn = new JButton("ȷ��");
		updateBtn.setBounds(448, 385, 93, 23);
		frame.getContentPane().add(updateBtn);
		updateBtn.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//��û��ѧ��ѡ����ʦ�Ŀγ̣�stListΪ��
		if(stList!=null){
			for(int i=0;i<stList.size();i++){
				stList.get(i).setGrade((float)table.getValueAt(i, 4));
			}
			System.out.println(stList);
			if(sts.update(stList)){
				JOptionPane.showMessageDialog(this.frame, "�޸ĳɹ�");
			}else{
				JOptionPane.showMessageDialog(this.frame, "�޸�ʧ��");
			}
		}
	}

}
