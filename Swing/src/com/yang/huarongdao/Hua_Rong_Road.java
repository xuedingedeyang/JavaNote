package com.yang.huarongdao;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hua_Rong_Road extends JFrame implements MouseListener,KeyListener,ActionListener{
	
	public static void main(String[] args) {
		new Hua_Rong_Road();
	}
	
	Person person[] = new Person[10];
	JButton left,right,above,below;
	JButton restart = new JButton("ÖØÐÂ¿ªÊ¼");
	public Hua_Rong_Road() {
		init();
		setBounds(100,100,320,360);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println(0);
			}
		});
	}
	
	public void init(){
		setLayout(null);
		add(restart);
		restart.setBounds(100, 320, 120, 25);
		restart.addActionListener(this);
		String[] name = {"²Ü²Ù","¹ØÓð","ÕÅ·É","Áõ±¸","ÕÔÔÆ","»ÆÖÒ","±ø","±ø","±ø","±ø"};
		for(int k=0;k<name.length;k++){
		   person[k] = new Person(k, name[k]);
		   person[k].addMouseListener(this);
		   person[k].addKeyListener(this);
		   add(person[k]);
		}
		   person[0].setBounds(104,54,100,100);
		   person[1].setBounds(104,154,100,50);
		   person[2].setBounds(54,154,50,100);
		   person[3].setBounds(204,154,50,100);
		   person[4].setBounds(54,54,50,100);
		   person[5].setBounds(204,54,50,100);
		   person[6].setBounds(54,254,50,50);
		   person[7].setBounds(204,254,50,50);
		   person[8].setBounds(104,204,50,50);
		   person[9].setBounds(154,204,50,50);
		   person[9].requestFocus();
		   left = new JButton("left");
		   right = new JButton("right");
		   above = new JButton("above");
		   below = new JButton("below");
		   left.setBounds(49, 49, 5,260);
		   right.setBounds(254,49,5,260);
		   above.setBounds(49,49,210,5);
		   below.setBounds(49,304,210,5);
		   validate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Person p = (Person) e.getSource();
		int x = -1;
		int y = -1;
		x = e.getX();
		y = e.getY();
		int w = p.getBounds().width;
		int h = p.getBounds().height;
		if(y > h/2){
			go(p,below);
		}
		if(y < h/2){
			go(p,above);
		}
		if(x > h/2){
			go(p,right);
		}
		if(y < h/2){
			go(p,left);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		new Hua_Rong_Road();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Person man = (Person) e.getSource();
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			go(man,below);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			go(man,above);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			go(man,left);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			go(man,right);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void go(Person p,JButton direction){
		boolean move = true;
		Rectangle manRect = p.getBounds();
		int x = p.getBounds().x;
		int y = p.getBounds().y;
		if(direction == below){
			y = y+50;
		}else if(direction == above){
			y = y - 50;
		}else if(direction == left){
			x = x-50;
		}else if(direction == right){
			x = x + 50;
		}
		manRect.setLocation(x, y);
		Rectangle diRectionRec = direction.getBounds();
		for(int k = 0;k<10;k++){
			Rectangle personRectangle = person[k].getBounds();
			if(manRect.intersects(personRectangle)&&(p.number != k)){
				move = false;
			}
		}
		if(manRect.intersects(diRectionRec)){
			move = false;
		}
		if(move){
			p.setLocation(x,y);
		}
	}

}
