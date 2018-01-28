package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class BoxSpaceTest {
	private Frame f = new Frame("����");
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
	public void init()
	{
		horizontal.add(new Button("ˮƽ��ť1"));
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(new Button("ˮƽ��ť2"));
		//ˮƽ���򲻿�����ļ�࣬���Ϊ10px
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(new Button("ˮƽ��ť3"));
		vertical.add(new Button("��ֱ��ť1"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("��ֱ��ť2"));
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(new Button("��ֱ��ť3"));
		f.add(horizontal,BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoxSpaceTest().init();
		
	}

}
