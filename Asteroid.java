package Asteroids;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Asteroid extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6959789975033360266L;
	double Velocity = 0;
	double Rotation = 0;
	double[] xVal;
	double[] yVal;
	double centerx = 0;
	double centery = 0; 

	public Asteroid(int[] xPoints, int[] yPoints, double velocity, double rotation) {
		
		Velocity = velocity;
		Rotation = rotation;

		if (xPoints.length == yPoints.length) {
			for (int i = 0; i < xPoints.length; i++) {
				this.addPoint(xPoints[i], yPoints[i]);
			}
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	public Asteroid[] shatter() {

		return null;
	}

	@Override
	public void rotate(double radians) {
		// TODO Auto-generated method stub

	}

	public static Asteroid generateAsteroid() {
		Random r = new Random();
		int numPoints = new Random().nextInt(2) + 7;

		double[] angles = new double[numPoints];
		for(int i = 0; i < numPoints; i++){
			angles[i] = (r.nextDouble()) * 2* Math.PI;
		}
		Arrays.sort(angles);

		int[] xPoints = new int[numPoints];
		int[] yPoints = new int[numPoints];
		for(int counter = 0; counter < numPoints; counter++){
			xPoints[counter] = (int) (Math.cos(angles[counter]) * (40)) + 40;
			yPoints[counter] = (int) (Math.sin(angles[counter]) * (40)) + 40;
			System.out.println("Angle: " + angles[counter] + " xPoint: " + xPoints[counter] + " yPoint: " + yPoints[counter]);
		}
		
		for(int i = 0; i < xPoints.length; i++){
			//System.out.print(xPoints[i] + " " + yPoints[i] + ",");
		}
		//System.out.println();
		
		return new Asteroid(xPoints, yPoints, new Random().nextDouble(), new Random().nextDouble());
	}

}
