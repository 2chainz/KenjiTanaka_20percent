package Asteroids;

import java.awt.MouseInfo;
import java.awt.Point;

public class Player extends GameObject{
	
	int x1 = 5;
	int y1 = 0;
	int x2 = 0;
	int y2 = 10;
	int x3 = 10;
	int y3 = 10;
	int centerx = 5;
	int centery = 6;

	public Player(){
		super();
		this.addPoint(x1,y1);
		this.addPoint(x2,y2);
		this.addPoint(x3,y3);
	}

	@Override
	public void move(int x, int y) {
		this.reset();
		x1 += x;
		x2 += x;
		x3 += x;
		y1 += y;
		y2 += y;
		y3 += y;
		
		centerx += x;
		centery += y;
		
		this.addPoint(x1,y1);
		this.addPoint(x2,y2);
		this.addPoint(x3,y3);
		
	}
	
	public void shoot(){
		System.out.println("pew");
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
		this.reset();
		x1 = (int) (Math.cos(0 - radians - (Math.PI / 2)) * 6) + centerx;
		y1 = (int) (Math.sin(0 - radians - (Math.PI / 2)) * 6) + centery;

		x2 = (int) (0 - Math.cos(0 - radians - (( 3 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centerx;
		y2 = (int) (0 - Math.sin(0 - radians - (( 3 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centery;

		x3 = (int) (Math.cos(0 - radians - (( 5 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centerx;
		y3 = (int) (Math.sin(0 - radians - (( 5 * Math.PI )/ 4)) * (5 + Math.sqrt(2))) + centery;
		
		this.addPoint(x1,y1);
		this.addPoint(x2,y2);
		this.addPoint(x3,y3);

		// TODO Auto-generated method stub
		
	}
	
}
