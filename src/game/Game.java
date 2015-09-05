package game;
import java.awt.Canvas;
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
		right.init(700, 0);
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

		left.render(g);
		right.render(g);
		ball.render(g);

		g.dispose();
		bs.show();
	}

	public void update() {
		left.update();
		right.update();
		ball.update();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("yourmom");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();

	}
}
