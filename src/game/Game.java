package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.entities.Ball;
import game.entities.Paddle;
import game.input.Keyboard;

/*
 * All credit goes to Liam Maclean
 */
@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{
	private Thread thread;
	private JFrame frame;
	private Keyboard key;

	private Paddle left,right;
	private Ball ball;
	
	private int pointsP1, pointsP2;

	public Game() {
		Dimension size = new Dimension(800,600);
		setPreferredSize(size);
		frame = new JFrame();
		key = new Keyboard();
		addKeyListener(key);

		left = new Paddle(key,1);
		right = new Paddle(key,2);
		ball = new Ball();

		left.init(0, 0);
		right.init(780, 0);
		ball.init(400, 300);
	}

	public synchronized void start() {
		thread = new Thread(this, "XxX_MLG_420BlazeIt_Pong_123XxX");
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		while(true) {

			render();
			update();
		}

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D)bs.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.black);

		left.render(g);
		right.render(g);
		ball.render(g);
		
		g.setColor(Color.BLACK);
		g.drawString("Points P1: " + pointsP1 + " | Points P2: " + pointsP2, 320, 10);
		
		g.dispose();
		bs.show();
	}

	public void update() {
		left.update();
		right.update();
		ball.update();
		collision(left);
		collision(right);
		
		
		if(ball.getY()<0) ball.flipY();
		if(ball.getY() + ball.getHeight() >600) ball.flipY();
		
		if(ball.getX()<0) { 
			ball.flipX();
			pointsP2++;
		}
		
		if(ball.getX() + ball.getWidth() >800) {
			ball.flipX();
			pointsP1++;
		}
	}

	public void collision(Paddle paddle) {
		if(paddle.bounds().intersects(ball.bounds())) {
			ball.flipX();
			ball.flipY();
		}
		
		if(paddle.getY() < 0) paddle.setCanMove(false);
		else paddle.setCanMove(true);
		if(paddle.getY() > 800 - paddle.getHeight()) paddle.setCanMove(false);
		else paddle.setCanMove(true);

		
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Pong | By: Evan \"Zormion\" Dawson & Liam \"TheLetterSix\" Maclean September 5th 2015");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();

	}
}
