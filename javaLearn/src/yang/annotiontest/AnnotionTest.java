package yang.annotiontest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnotionTest {
	
	private JFrame mainWin = new JFrame("使用注解绑定事件监听器");
	@ActionListenerFor(listener = OkListener.class)
	private JButton ok = new JButton("确定");
	
	@ActionListenerFor(listener = CancelListener.class)
	private JButton cancel = new JButton("取消");
	
	public void init(){
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotions(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	

	public static void main(String[] args) {
		new AnnotionTest().init();

	}
	
	class OkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"单击了确认按钮");
		}
		
	}
	
	class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"单击了取消按钮");
			
		}
		
	}

}
