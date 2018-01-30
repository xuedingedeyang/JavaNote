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
	// 桌面的宽度
	private final int TABLE_WIDTH = 300;
	// 桌面的高度
	private final int TABLE_HEIGHT = 400;
	// 球拍的垂直位置
	private final int RACKET_Y = 340;
	// 球拍的高度和宽度
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;

	private final int BALL_SIZE = 16;
	private Frame f = new Frame("bounce ball");
	Random r = new Random();
	// 球纵向运行速度
	private int ySpeed = 10;
	// 返回一个-0.5~0.5的比率，用于控制小球的运行方向
	private double xRate = r.nextDouble() - 0.5;
	// 小球横向运行速度
	private int xSpeed = (int) (ySpeed * xRate * 2);
	// ballX和ballY代替小球的坐标
	private int ballX = r.nextInt(200) + 20;
	private int ballY = r.nextInt(10) + 20;
	// racketX代表球拍的水平位置
	private int racketX = r.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	Timer timer;
	private boolean isClose = false;

	public void init() {
		// 设置桌面区域的最佳大小
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		f.add(tableArea);
		// 键盘监听器
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
		// 为窗口和tableArea分别添加键盘监听器
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		// 定义每0.1秒执行一次的事件监听器
		ActionListener taskPerformer = e -> {

			// TODO Auto-generated method stub
			// 碰到了左边边框
			if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
				xSpeed = -xSpeed;
			}
			// 如果小球高度超出了球拍位置，且横向不在球拍范围内，游戏结束
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
