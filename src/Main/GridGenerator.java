package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class GridGenerator {
	
	public int grid[][];
	public int brickWidth;
	public int brickHeight;
	public GridGenerator(int r, int c) {
		grid = new int[r][c];
		for (int k=0; k<grid.length; k++) {
			for (int j=0; j<grid[0].length; j++) {
				grid[k][j] = 2;
			}
		}
		brickWidth = 540/c;
		brickHeight = 150/r;
	}
	
	public void draw (Graphics2D g) {
		for (int k=0; k<grid.length; k++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[k][j] > 1) {
					g.setColor(Color.white);
					g.fillRect(j*brickWidth + 80, k * brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickWidth + 80, k * brickHeight + 50, brickWidth, brickHeight);
				}
				else if (grid[k][j] == 1) {
					g.setColor(Color.gray);
					g.fillRect(j*brickWidth + 80, k * brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickWidth + 80, k * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
		
	}
	
	public void setBrickVal (int r, int c) {
		grid[r][c]--;
	}

}
