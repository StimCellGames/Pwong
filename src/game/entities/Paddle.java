package game.entities;

import game.input.Keyboard;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle extends Entity {
	
	Keyboard keyboard;
	int paddleID;
	
	public Paddle(Keyboard keyboard, int paddleID) {
		this.keyboard = keyboard;
		this.paddleID = paddleID;
	}
	
	@Override
	public void init(int x, int y) {
		width = 20;
		height = 100;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		if(paddleID == 1) {
			if(keyboard.isKeyDown(KeyEvent.VK_W)) {
				y--;
			}
			if(keyboard.isKeyDown(KeyEvent.VK_S)) y++;
		}
		
		if(paddleID == 2) {
			if(keyboard.isKeyDown(KeyEvent.VK_UP)) y--;
			if(keyboard.isKeyDown(KeyEvent.VK_DOWN)) y++;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}