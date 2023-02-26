package Components;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	
	private int width;
	private int x;
	private int y;
	private Color color;
	
	public Paddle () {
		this.x=300;
		this.y=760;
	    this.width=120;
	    this.color=Color.blue;
	    
	}
	
	public Paddle (int x, int y, int width, Color color) {
		this.width=width;
		this.x=x;
		this.y=y;
		this.color=color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, 10);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width=width;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	

}
