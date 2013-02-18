package Asteroids;

import java.awt.Color;
import java.awt.Polygon;

public abstract class GameObject extends Polygon {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8024283509275034268L;
	
	protected Color color = Color.WHITE;

	public GameObject(){
		super();
	}
	public Color getColor(){
		return color;
	}
	public abstract void move();
	public abstract void rotate(double radians);
	//Make this for all objects
}
