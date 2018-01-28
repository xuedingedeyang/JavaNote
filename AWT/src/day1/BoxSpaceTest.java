package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class BoxSpaceTest {
	private Frame f = new Frame("测试");
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
	public void init()
	{
		horizontal.add(new Button("水平按钮1"));
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(new Button("水平按钮2"));
		//水平方向不可拉伸的间距，宽度为10px
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(new Button("水平按钮3"));
		vertical.add(new Button("垂直按钮1"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("垂直按钮2"));
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(new Button("垂直按钮3"));
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
