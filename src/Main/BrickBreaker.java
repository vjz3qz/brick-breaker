package Main;
import java.awt.Color;
import Components.*;

// 9/13/22: Power up  never ends, no instructions at beginning,
//power up doesn't disappear after getting, game doesn't end after breaking all bricks


public class BrickBreaker {
	private int score;
	private int level;
	private Paddle paddle;
	private Ball ball;
	private IncreasePaddleWidth PowerUp1;
	private SlowSpeed PowerUp2;
	
	public BrickBreaker() {
		score=0;
		level=1;
		paddle=new Paddle();
		ball = new Ball(350, 400, 25, Color.YELLOW);
		PowerUp1 = new IncreasePaddleWidth();
		PowerUp2 = new SlowSpeed();
	}
	
	public Paddle getPaddle() {
		return paddle;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public IncreasePaddleWidth getPowerUp1() {
		return PowerUp1;
		
	}
	
	public SlowSpeed getPowerUp2() {
		return PowerUp2;
	}

	public String getScore() {
		// TODO Auto-generated method stub
		return null;
	}
}
