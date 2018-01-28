package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("测试窗口");
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("南"), BorderLayout.SOUTH);
		f.add(new Button("北"), BorderLayout.NORTH);
		f.add(new Button("东"), BorderLayout.EAST);
		f.add(new Button("西"), BorderLayout.WEST);
		f.add(new Button("中"));
		f.pack();
		f.setVisible(true);
		
	}

}
