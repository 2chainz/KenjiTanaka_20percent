package Asteroids;

public class Laser extends GameObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int length = 3;
	private final int speed = 2;
	float centerx = 0;
	float centery = 0;
	double rotation = 0;

	public Laser(int x, int y, double rot){
		centerx = x;
		centery = y;
		rotation = rot;
		this.addPoint(x, y);
		

		float x2 = (int) (Math.cos(0 - rotation - (Math.PI / 2)) * length) + centerx;
		float y2 = (int) (Math.sin(0 - rotation - (Math.PI / 2)) * length) + centery;
		this.addPoint((int) x2,(int)y2);
	}

	public void move() {
		this.reset();
		
		centerx += (speed * Math.cos(0 - rotation - (Math.PI / 2)));
		centery += (speed * Math.sin(0 - rotation - (Math.PI / 2)));
		
		this.addPoint((int) centerx, (int) centery);
		this.addPoint(getx(centerx), gety(centery));
	}
	
	private int getx(float x){
		return (int) ((Math.cos(0 - rotation - (Math.PI / 2)) * length) + x);
	}
	
	private int gety(float y){
		return (int) ( (Math.sin(0 - rotation - (Math.PI / 2)) * length) + y);
	}
	
	@Override
	public void rotate(double radians) {
		
	}
}
