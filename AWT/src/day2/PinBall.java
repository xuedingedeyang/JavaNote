package day2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.Timer;

public class PinBall {
	// ����Ŀ��
	private final int TABLE_WIDTH = 300;
	// ����ĸ߶�
	private final int TABLE_HEIGHT = 400;
	// ���ĵĴ�ֱλ��
	private final int RACKET_Y = 340;
	// ���ĵĸ߶ȺͿ��
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;

	private final int BALL_SIZE = 16;
	private Frame f = new Frame("bounce ball");
	Random r = new Random();
	// �����������ٶ�
	private int ySpeed = 10;
	// ����һ��-0.5~0.5�ı��ʣ����ڿ���С������з���
	private double xRate = r.nextDouble() - 0.5;
	// С����������ٶ�
	private int xSpeed = (int) (ySpeed * xRate * 2);
	// ballX��ballY����С�������
	private int ballX = r.nextInt(200) + 20;
	private int ballY = r.nextInt(10) + 20;
	// racketX�������ĵ�ˮƽλ��
	private int racketX = r.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	Timer timer;
	private boolean isClose = false;

	public void init() {
		// ���������������Ѵ�С
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		f.add(tableArea);
		// ���̼�����
		KeyAdapter keyProcessor = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
					if (racketX > 0) {
						racketX -= 10;
					}
				}
				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (racketX < TABLE_WIDTH - RACKET_WIDTH) {
						racketX += 10;
					}
				}
			}
		};
		// Ϊ���ں�tableArea�ֱ���Ӽ��̼�����
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		// ����ÿ0.1��ִ��һ�ε��¼�������
		ActionListener taskPerformer = e -> {

			// TODO Auto-generated method stub
			// ��������߱߿�
			if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
				xSpeed = -xSpeed;
			}
			// ���С��߶ȳ���������λ�ã��Һ��������ķ�Χ�ڣ���Ϸ����
			if (ballY >= RACKET_Y - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
				timer.stop();
				isClose = true;
				tableArea.repaint();
			} else if (ballY <= 0
					|| (ballY >= RACKET_Y - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
				ySpeed = -ySpeed;
			}
			ballX += xSpeed;
			ballY += ySpeed;
			tableArea.repaint();
		};
		timer = new Timer(100, taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinBall().init();
	}

	public class MyCanvas extends Canvas {
		@Override
		public void paint(Graphics g) {
			if (isClose) {
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Times", Font.BOLD, 30));
				g.drawString("game over!", 50, 200);
			} else {
				g.setColor(new Color(240, 240, 80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
}
