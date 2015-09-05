package game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected int x, y;
	protected int width, height;
	
	public abstract void init();
	public abstract void update();
	public abstract void render(Graphics g);
	
	public Rectangle bounds() {
		return new Rectangle(x, y, width, height);
	}
}
