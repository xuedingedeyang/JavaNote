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
		Frame f = new Frame("���Դ���");
		
//		f.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("��"),BorderLayout.SOUTH);
		f.add(new Button("��"),BorderLayout.NORTH);
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("�����"));
		f.add(p);
		f.add(new Button("��"),BorderLayout.EAST);
	    f.pack();//���ô���Ϊ��Ѵ�С
//		f.setBounds(30,30,250,120);
		f.setVisible(true);//FrameĬ��Ϊ���ɼ�
	}

}
