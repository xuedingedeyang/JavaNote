package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;

public class CardLayoutTest {
	Frame f = new Frame("测试");
	String[] names = {"一","二","三","四","五"};
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
			case "上一张":
				c.previous(p1);
				System.out.println("上一张");
				break;
			case "下一张":
				c.next(p1);
				break;
			case "第一张":
				c.first(p1);
				break;
			case "最后一张":
				c.last(p1);
				break;
			case "第三张":
				c.show(p1,"三");
				break;
			}
		};
		Button b1 = new Button("上一张");
		b1.addActionListener(listener);
		Button b2 = new Button("下一张");
		b1.addActionListener(listener);
		Button b3 = new Button("第一张");
		b1.addActionListener(listener);
		Button b4 = new Button("最后一张");
		b1.addActionListener(listener);
		Button b5 = new Button("第三张");
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
