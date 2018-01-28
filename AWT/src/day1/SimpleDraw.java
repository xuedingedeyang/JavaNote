package day1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

public class SimpleDraw {
	private final String  RECT_SHAP = "rect";
	private final String OVAL_SHAP = "oval";
	private Frame f = new Frame("simple draw");
	private Button rect = new Button("draw rect");
	private Button oval = new Button("draw oval");
	private MyCanvas drawArea = new MyCanvas();
	private String shape="";
	public void init()
	{
		Panel p = new Panel();
		rect.addActionListener(e->
		{
			shape = RECT_SHAP;
			drawArea.repaint();
		});
		oval.addActionListener(e->{
			shape = OVAL_SHAP;
			drawArea.repaint();
		});
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(250, 180));
		f.add(drawArea);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleDraw().init();
	}
	
	
	public class MyCanvas extends Canvas
	{
		public void pain(Graphics g)
		{
			Random rand = new Random();
			if(shape.equals(RECT_SHAP))
			{
				g.setColor(new Color(220,100,80));
				g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
			}
			if(shape.equals(OVAL_SHAP))
			{
				g.setColor(new Color(80,100,200));
				g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
			}
		}
	}

}


