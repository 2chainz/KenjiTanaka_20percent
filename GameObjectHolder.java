package Asteroids;

import java.util.LinkedList;

public class GameObjectHolder {
	
	private Laser[] lasers = new Laser[2000];
	private LinkedList<Asteroid> asteroids = new LinkedList<Asteroid>();

	public void add(GameObject a){
		if(a instanceof Asteroid)
			asteroids.add((Asteroid) a);
		if(a instanceof Laser){
			addLaser((Laser) a);
		}
			
	}
	
	public int getNumLasers(){
		int i = 0;
		for(i = 0; i < lasers.length; i++){
			if(lasers[i] == null)
				break;
		}
		return i;
	}
	
	public int getNumAsteroids(){
		return asteroids.size();
	}
	
	public GameObject[] getObjects(){
		
		int numLasers = getNumLasers();
		
		GameObject[] returningObjects = new GameObject[asteroids.size() + numLasers];
		System.arraycopy(asteroids.toArray(), 0, returningObjects, 0, asteroids.toArray().length);
		System.arraycopy(lasers, 0, returningObjects, asteroids.toArray().length, numLasers);
		return returningObjects;
	}
	
	public void moveObjects(){
		for(Asteroid a : asteroids){
			a.move();
		}
		for(Laser l : lasers){
			if(l != null){
				l.move();
			}
		}
	}
	
	public void addLaser(Laser l){
		boolean done = false;
		for(int i = 0; i < lasers.length; i++){
			if(lasers[i] == null && !done){
				lasers[i] = l;
				done = true;
			}
		}
		if(!done){
			// TODO remove the old lasers
		}
	}
	
	public int getSize(){
		return asteroids.size() + getNumLasers();
	}
	
	public void refresh(){
		
		for(Asteroid a : asteroids){
			if(a.centerx < -100 || a.centerx > 1000 || a.centery < -100 || a.centery > 700){
				asteroids.remove(a);
			}
			if(a.getBounds2D().getHeight() * a.getBounds2D().getWidth() < 10){
				asteroids.remove(a);
			}
		}
		for(int i = 0; i < lasers.length; i++){
			if(lasers[i].centerx < -100 || lasers[i].centerx > 1000 || lasers[i].centery < -100 || lasers[i].centery > 700){
				lasers[i] = null;
			}
		}
		
		
		// TODO Remove all lasers and asteroids outside of, say the window + 100px in either direction
		// TODO Remove all asteroids smaller than a certain size. 
		
	}
}
