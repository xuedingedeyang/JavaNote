package day1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowLayoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("���Դ���");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		//�򴰿������10����ť
		for(int i=0;i<10;i++)
		{
			f.add(new Button("��ť"+i));
		}
		//���ô���Ϊ��Ѵ�С
		f.pack();
		//��ʾ���ڣ�Ĭ��Ϊ����״̬
		f.setVisible(true);
	}

}
