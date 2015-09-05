package game.entities;

import java.awt.Graphics;

public class Ball extends Entity {

	@Override
	public void init(int x, int y) {
		width = 15;
		height = 15;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawOval(x, y, width, height);
	}

}
