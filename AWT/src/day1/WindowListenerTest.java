package day1;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.print.attribute.TextSyntax;

public class WindowListenerTest {
	private Frame f = new Frame("test");
	private TextArea ta = new TextArea(6,40);
	public void init()
	{
		f.addWindowListener(new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	
	class MyListener implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			ta.append("window is activate");
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			ta.append("window has closed");
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			ta.append("window is closing");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			ta.append("window has deactivated");
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			ta.append("window has deiconfied");
		}	

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			ta.append("window has opened");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowListenerTest().init();
	}

}
