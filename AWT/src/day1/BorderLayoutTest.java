package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("���Դ���");
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("��"), BorderLayout.SOUTH);
		f.add(new Button("��"), BorderLayout.NORTH);
		f.add(new Button("��"), BorderLayout.EAST);
		f.add(new Button("��"), BorderLayout.WEST);
		f.add(new Button("��"));
		f.pack();
		f.setVisible(true);
		
	}

}
