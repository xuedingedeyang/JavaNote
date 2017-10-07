package yang.base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.net.NoRouteToHostException;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("测试窗口");
		
//		f.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("南"),BorderLayout.SOUTH);
		f.add(new Button("北"),BorderLayout.NORTH);
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("点击我"));
		f.add(p);
		f.add(new Button("东"),BorderLayout.EAST);
	    f.pack();//设置窗口为最佳大小
//		f.setBounds(30,30,250,120);
		f.setVisible(true);//Frame默认为不可见
	}

}
