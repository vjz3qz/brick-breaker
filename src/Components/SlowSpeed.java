package Components;

import java.awt.Color;
import java.awt.Graphics;

public class SlowSpeed {
	
	private int x;
	private int y;
	private int length;
	private int ySpeed;
	
	public SlowSpeed() {
		this.x=(int)(Math.random() * 651) + 25;
		this.y=-30;
		this.length=30;
		this.ySpeed=0;
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, length, length);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	
	public void setYSpeed() {
		ySpeed=1;
	}
	
	public int getLength() {
		return length;
	}
}
