package Components;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int x;
	private int y;	
	private int diameter;
	private int radius;	
	private Color color;	
	private int xSpeed;		
	private int ySpeed;		

	public Ball() {
			color=Color.RED;
			x=0;
			y=0;
			diameter=20;
			radius=diameter/2;
			xSpeed=-2;
			ySpeed=-3;
	}
	
	public Ball(int x, int y, int diameter, Color color) {
		this.x=x;
		this.y=y;
		this.diameter=diameter;
		this.radius=diameter/2;
		this.color=color;
		xSpeed=-2;
		ySpeed=-3;
    }

	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public int getY()
	{
		return y;
	}			
	public void setY(int y)
	{
		this.y=y;
	}
	public int getDiameter()
	{
		return diameter;
	}		
	public int getRadius()
	{
		return radius;
	}		
	public int getColor()
	{
		return x;
	}			
	public void setColor(Color color)
	{
		this.color=color;
	}
	public int getXSpeed()
	{
		return xSpeed;
	}		
	public void setXSpeed(int xSpeed)
	{
		this.xSpeed=xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}		
	public void setYSpeed(int ySpeed)
	{
		this.ySpeed=ySpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, diameter, diameter);
	}
}
