package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventOs {
	private Frame f = new Frame("test event");
	private Button ok = new Button("ok");
	private TextField tf = new TextField(30);
	public void init()
	{
		//×¢²áÊ±¼ä¼àÌýÆ÷
		ok.addActionListener(new OkListsner());
		f.add(tf);
		f.add(ok,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventOs().init();
	}
	
	class OkListsner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("user cliked ok button");
			tf.setText("Hello world");
		}
	}

}
