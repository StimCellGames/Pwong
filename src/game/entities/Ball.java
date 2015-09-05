package game.entities;

import java.awt.Graphics;

public class Ball extends Entity {

	@Override
	public void init() {
		width = 15;
		height = 15;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawOval(x, y, width, height);
	}

}
