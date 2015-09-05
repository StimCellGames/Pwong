package game.entities;

import java.awt.Graphics;

public class Paddle extends Entity {
	
	@Override
	public void init(int x, int y) {
		width = 20;
		height = 30;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}