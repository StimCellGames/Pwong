package game.entities;

import java.awt.Graphics;

public class Ball extends Entity {
	
	int xVel = 1, yVel = 1;

	@Override
	public void init(int x, int y) {
		width = 15;
		height = 15;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		x += xVel;
		y += yVel;
	}

	@Override
	public void render(Graphics g) {
		g.drawOval(x, y, width, height);
	}
	
	public void flipY() {
		yVel *= -1;
	}
	
	public void flipX() {
		xVel *= -1;
	}

}
