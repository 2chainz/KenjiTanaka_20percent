package Asteroids;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

public class Player extends GameObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double x1 = 5;
	double y1 = 0;
	double x2 = 0;
	double y2 = 10;
	double x3 = 10;
	double y3 = 10;
	double centerx = 5;
	double centery = 6;
	double playerspeed = 1.5;
	double rot = 0;

	public Player(){
		super();
		this.color = Color.white;
		this.addPoint((int) x1,(int) y1);
		this.addPoint((int) x2,(int) y2);
		this.addPoint((int)x3,(int)y3);
	}

	public void move(int x, int y) {
		
		// TODO vectored movement
		
		x *= playerspeed;
		y *= playerspeed;
		x1 += x;
		x2 += x;
		x3 += x;
		y1 += y;
		y2 += y;
		y3 += y;
		
		centerx += x;
		centery += y;
		
		this.translate(x, y);
		
	}
	
	public GameObject shoot(){
		return new Laser((int)x1,(int)y1,rot);
	}
	
	public void pointAtMouse(Point windowLocation){
		Point p = MouseInfo.getPointerInfo().getLocation();
		p.setLocation(p.getX() - windowLocation.getX(), p.getY() - windowLocation.getY() - 22);
		//System.out.println("(" + centerx + " , " + centery + ")");
		//System.out.println(p);
		
		//System.out.println(Math.atan2(centerx - p.getX(),centery - p.getY()));
		rotate(Math.atan2(centerx - p.getX(),centery - p.getY()));
	}

	@Override
	public void rotate(double radians) {
		rot = radians;
		this.reset();
		x1 = (int) (Math.cos(0 - radians - (Math.PI / 2)) * 6) + centerx;
		y1 = (int) (Math.sin(0 - radians - (Math.PI / 2)) * 6) + centery;

		x2 = (int) (0 - Math.cos(0 - radians - (( 3 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centerx;
		y2 = (int) (0 - Math.sin(0 - radians - (( 3 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centery;

		x3 = (int) (Math.cos(0 - radians - (( 5 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centerx;
		y3 = (int) (Math.sin(0 - radians - (( 5 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centery;
		
		this.addPoint((int) x1,(int) y1);
		this.addPoint((int) x2,(int) y2);
		this.addPoint((int)x3,(int)y3);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
