package Components;

import java.awt.Color;
import java.awt.Graphics;

public class IncreasePaddleWidth {
	
	private int x;
	private int y;
	private int length;
	private int height;
	private int ySpeed;
	
	public IncreasePaddleWidth() {
		this.x=(int)(Math.random() * 651) + 25;
		this.y=-25;
		this.length=25;
		this.height=25;
		this.ySpeed=0;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	public void setYSpeed() {
		ySpeed=1;
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
	
	
	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		int nPoints = 3;
		int[] xPoints = {getX(), getX()+(getLength()/2), getX()+getLength()};
		int[] yPoints = {getY()-getHeight(), getY(), getY()-getHeight()};
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
	
	

}
