package Asteroids;

import java.awt.Polygon;

public abstract class GameObject extends Polygon {

	public GameObject(){
		super();
	}
	
	public abstract void move(int x, int y);
	public abstract void rotate(double radians);
}
