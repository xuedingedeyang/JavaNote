package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;

public class CardLayoutTest {
	Frame f = new Frame("����");
	String[] names = {"һ","��","��","��","��"};
	Panel p1 = new Panel();
	
	public void init()
	{
		final CardLayout c = new CardLayout();
		p1.setLayout(c);
		for(int i=0;i<names.length;i++)
		{
			p1.add(names[i], new Button(names[i]));
		}
		Panel p = new Panel();
		ActionListener listener = e->
		{
			switch(e.getActionCommand())
			{
			case "��һ��":
				c.previous(p1);
				System.out.println("��һ��");
				break;
			case "��һ��":
				c.next(p1);
				break;
			case "��һ��":
				c.first(p1);
				break;
			case "���һ��":
				c.last(p1);
				break;
			case "������":
				c.show(p1,"��");
				break;
			}
		};
		Button b1 = new Button("��һ��");
		b1.addActionListener(listener);
		Button b2 = new Button("��һ��");
		b1.addActionListener(listener);
		Button b3 = new Button("��һ��");
		b1.addActionListener(listener);
		Button b4 = new Button("���һ��");
		b1.addActionListener(listener);
		Button b5 = new Button("������");
		b1.addActionListener(listener);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		f.add(p1);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CardLayoutTest().init();
	}

}
