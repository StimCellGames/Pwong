package game.entities;

import java.awt.Graphics;

public class Paddle extends Entity {
	
	@Override
	public void init() {
		width = 20;
		height = 30;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawRect(x, y, width, height);
	}
	
}
