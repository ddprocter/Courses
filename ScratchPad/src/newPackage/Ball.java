
public class Ball {

	private float x; // x location of ball at any time
	private float y; // y location of ball at any time
	private float width; // width of the ball
	private float speedX; // pixels / second
	private float speedY; // pixels / second
	private int direction; // 1 is up, 0 is down
	
	public static void main(String[] args) {
		Ball ball = new Ball();
		System.out.println(ball.toString());
		

	}
	
	Ball() { 
		setWidth(40);
		setX(0);
		setY(0);
		setSpeedX(100);
		setSpeedY(100);
		setDirection(1);
		
	}
	
	public void updateLocation(float timeIntervalSeconds) { 
		this.x += speedX * timeIntervalSeconds;
		this.y += speedY * timeIntervalSeconds;
	}
	
	private void setWidth(float width) {
		this.width = width;
	}
	
	
	private void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	
	
	private void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	

	
	private void setDirection(int direction) {
		this.direction = direction;
	}

	private void setX(float x) {
		this.x = x;
	}

	private void setY(float y) {
		this.y = y;
	}
}
