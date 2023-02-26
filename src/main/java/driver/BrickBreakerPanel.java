package driver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class BrickBreakerPanel extends JPanel implements KeyListener, ActionListener{
	
	private boolean started = false;
	private GridGenerator grid;
	public Timer timer;
    private BrickBreaker brickBreaker;
    private int PowerUpInt;
    private int score=0;
    
    public BrickBreakerPanel() {
    	brickBreaker = new BrickBreaker();
    	grid = new GridGenerator(3, 7);
    	addKeyListener(this);
    	setFocusable(true);
    	setFocusTraversalKeysEnabled(false);
    	timer = new Timer(8, this);
    	timer.start();
    }
	public void paintComponent(Graphics g) {
	    	
	    	//background
		drawBackground(g);
	    	
	    	//slider
	    brickBreaker.getPaddle().draw(g);
	    	
	    	//ball
	    brickBreaker.getBall().draw(g);
	
	    	//bricks
	    grid.draw((Graphics2D) g);
	    	
	    	//PowerUps
	    brickBreaker.getPowerUp1().draw(g);	
	    brickBreaker.getPowerUp2().draw(g);
	    
	    	
	    }
	public static void drawBackground(Graphics g) {

		g.setColor(Color.black);
    	g.fillRect(1, 1, 700, 1000);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		int s=0;
		int display=s;
		if (started) {
			int count=0;
			
			
			//checks for intersection between ball and slider
			if (new Rectangle(brickBreaker.getPaddle().getX(), brickBreaker.getPaddle().getY(), brickBreaker.getPaddle().getWidth(), 10).intersects(new Rectangle(brickBreaker.getBall().getX(), brickBreaker.getBall().getY(), 25, 25))) {
				brickBreaker.getBall().setYSpeed(-brickBreaker.getBall().getYSpeed());
				count++;
			}
			
			//checks when either PowerUp comes in contact with ball or paddle
			if (new Rectangle(brickBreaker.getPowerUp1().getX(), brickBreaker.getPowerUp1().getY(), brickBreaker.getPowerUp1().getLength(), brickBreaker.getPowerUp1().getHeight()).intersects(new Rectangle(brickBreaker.getPaddle().getX(), brickBreaker.getPaddle().getY(), brickBreaker.getPaddle().getWidth(), 10))) {
				PowerUpInt=1;
			}
			if (new Rectangle(brickBreaker.getPowerUp2().getX(), brickBreaker.getPowerUp2().getY(), brickBreaker.getPowerUp2().getLength(), brickBreaker.getPowerUp2().getLength()).intersects(new Rectangle(brickBreaker.getPaddle().getX(), brickBreaker.getPaddle().getY(), brickBreaker.getPaddle().getWidth(), 10))) {
				PowerUpInt=2;
			}
			//applies the PowerUps
			if (PowerUpInt==1) {
				brickBreaker.getPaddle().setWidth(180);
			}  
			if (PowerUpInt==2) {
				if (brickBreaker.getBall().getXSpeed()==-2 && brickBreaker.getBall().getYSpeed()==-3) {
					brickBreaker.getBall().setXSpeed(-1);
					brickBreaker.getBall().setYSpeed(-2);
				}
				if (brickBreaker.getBall().getXSpeed()==2 && brickBreaker.getBall().getYSpeed()==-3) {
					brickBreaker.getBall().setXSpeed(1);
					brickBreaker.getBall().setYSpeed(-2);
				}
				if (brickBreaker.getBall().getXSpeed()==-2 && brickBreaker.getBall().getYSpeed()==3) {
					brickBreaker.getBall().setXSpeed(-1);
					brickBreaker.getBall().setYSpeed(2);
				}
				if (brickBreaker.getBall().getXSpeed()==2 && brickBreaker.getBall().getYSpeed()==3) {
					brickBreaker.getBall().setXSpeed(1);
					brickBreaker.getBall().setYSpeed(2);
				}
			}
			//checks when ball & brick hits and removes the brick
			X:for (int k=0; k<grid.grid.length; k++) {
				for (int j=0; j< grid.grid[0].length; j++) {
					if (grid.grid[k][j] > 0) {
						int brickX = j * grid.brickWidth + 80;
						int brickY = k * grid.brickHeight + 50;
						int brickWidth = grid.brickWidth;
						int brickHeight = grid.brickHeight;
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(brickBreaker.getBall().getX(), brickBreaker.getBall().getY(), 20, 20); 
						Rectangle brickRect = rect;
						if (ballRect.intersects(brickRect)) {
							grid.setBrickVal(k, j);
							s++;
							if (brickBreaker.getBall().getX() + 19 <= brickRect.x || brickBreaker.getBall().getX() + 1 >= brickRect.x + brickRect.width) {
								brickBreaker.getBall().setXSpeed(-brickBreaker.getBall().getXSpeed());
							} else {
								brickBreaker.getBall().setYSpeed(-brickBreaker.getBall().getYSpeed());
							}
							break X;
						}
					}
				}
			}
			//change power up get height
			brickBreaker.getPowerUp1().setY(brickBreaker.getPowerUp1().getY()+brickBreaker.getPowerUp1().getYSpeed());
			brickBreaker.getPowerUp2().setY(brickBreaker.getPowerUp2().getY()+brickBreaker.getPowerUp2().getYSpeed());
			
			brickBreaker.getBall().setX(brickBreaker.getBall().getX()+brickBreaker.getBall().getXSpeed());
			brickBreaker.getBall().setY(brickBreaker.getBall().getY()+brickBreaker.getBall().getYSpeed());
			
			//checks when ball hits top wall, right wall, and bottom wall
			if (brickBreaker.getBall().getX() < 0) 
				brickBreaker.getBall().setXSpeed(-brickBreaker.getBall().getXSpeed());
			if (brickBreaker.getBall().getY() < 0) 
				brickBreaker.getBall().setYSpeed(-brickBreaker.getBall().getYSpeed());			
			if (brickBreaker.getBall().getX() > 660) 
				brickBreaker.getBall().setXSpeed(-brickBreaker.getBall().getXSpeed());
			//drops power ups after certain amount of hits
			if(count>1)
				brickBreaker.getPowerUp1().setYSpeed();
			if(count>0)
				brickBreaker.getPowerUp2().setYSpeed();			
		}
		
		if(s!=display)
		{
			
			System.out.println("score: "+score);
			display=s;
			score++;
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//change 600 and 10 to an accessor method because of power ups
			if (brickBreaker.getPaddle().getX()+brickBreaker.getPaddle().getWidth() >= 700) {
				brickBreaker.getPaddle().setX(700-brickBreaker.getPaddle().getWidth());
			}else{
				moveRight();
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (brickBreaker.getPaddle().getX() <= 0) {
				brickBreaker.getPaddle().setX(0);
			}else{
				moveLeft();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveRight() {
		started = true;
		brickBreaker.getPaddle().setX(brickBreaker.getPaddle().getX()+20);
	}
	
	public void moveLeft() {
		started = true;
		brickBreaker.getPaddle().setX(brickBreaker.getPaddle().getX()-20);
	}
	
}
