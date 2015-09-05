package game.entities;

import game.input.Keyboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle extends Entity {
	
	Keyboard keyboard;
	int paddleID;
	boolean canMove;
	
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
		if(paddleID == 1 && canMove) {
			if(keyboard.isKeyDown(KeyEvent.VK_W)) {
				y--;
			}
			if(keyboard.isKeyDown(KeyEvent.VK_S)) y++;
		}
		
		if(paddleID == 2 && canMove) {
			if(keyboard.isKeyDown(KeyEvent.VK_UP)) y--;
			if(keyboard.isKeyDown(KeyEvent.VK_DOWN)) y++;
		}
	}

	@Override
	public void render(Graphics g) {
		if(paddleID == 1) g.setColor(Color.RED);
		else g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void setCanMove(boolean canMove) {
		this.canMove = canMove; 
	}
}