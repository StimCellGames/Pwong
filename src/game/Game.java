package game;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/*
 * All credit goes to Liam Maclean
 */
public class Game extends Canvas implements Runnable{
	Thread thread;
	JFrame frame;
	
	public Game() {
		Dimension size = new Dimension(800,600);
		setPreferredSize(size);
		frame = new JFrame();
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
		g.fillRect(10, 10, 10, 10);
		
		
		g.dispose();
		bs.show();
	}
	
	
	
	public void update() {
		
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
