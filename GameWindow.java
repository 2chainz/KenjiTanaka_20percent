package Asteroids;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable, KeyListener, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5241432827349470486L;
	String Version = "0.0.3";

	public static void main(String[] args){
		new GameWindow();
	}
	
	Canvas c = new Canvas();
	BufferStrategy bf;
	Graphics g;
	Player p;
	int dx, dy;
	boolean running = true;
	boolean shooting = false;
	long previoustime = 0;

	GameObject[] objDraw;
	
	boolean leftpressed = false;
	boolean rightpressed = false;
	boolean uppressed = false;
	boolean downpressed = false;
	
	public GameWindow(){
		super("Asteroids in Java");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		c.setSize(getSize());
		c.setBackground(Color.BLACK); 
		add(c);
		c.addKeyListener(this);
		c.addMouseListener(this);
		c.requestFocusInWindow();
		
		
		
		c.createBufferStrategy(2);
		bf = c.getBufferStrategy();
		g = bf.getDrawGraphics();
		
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		
		new Thread(this).start();
	}
	
	public void pause(){
		running = false;
	}
	
	public void unpause(){
		running = true;
	}

	@Override
	public void run() {
		GameObjectHolder goh = new GameObjectHolder();
		p = new Player();
		bf.show();

		goh.add(Asteroid.generateAsteroid());
		while(true){
			
			if(running){

				int fps = (int) getFPS();
				System.out.println("Objects: " + goh.getSize() + " fps:" + (0 - fps));
				
				//Drawing the background
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, c.getWidth(), c.getHeight());
				
				//Calculating player movement, doing it 
				p.pointAtMouse(this.getLocation());
				calculatePlayerMovement();
				p.move(dx,dy);
				
				goh.moveObjects();
				
				if(shooting == true)
					goh.add(p.shoot());
			
				// TODO check for collisions
				
				// Gets the array of things to draw
				objDraw = goh.getObjects();
				
				// Draw the player
				g.setColor(p.getColor());
				g.drawPolygon(p);
				
				for(GameObject gobj : objDraw){
					g.setColor(gobj.getColor());
					g.drawPolygon(gobj);
				}
				bf.show();
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("paused");
			}
		}
		
	}
	
	private float getFPS(){
		long oneoverfps = previoustime - System.currentTimeMillis();
		previoustime = System.currentTimeMillis();
		return 1000 / (float) oneoverfps;
	}
	
	private void calculatePlayerMovement(){
		if(leftpressed && !rightpressed){
			dx = -1;
		} else if(rightpressed && !leftpressed){
			dx = 1;
		} else{
			dx = 0;
		}
		
		if(uppressed && !downpressed){
			dy = -1;
		} else if(downpressed && !uppressed){
			dy = 1;
		} else{
			dy = 0;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyChar()){
		case 'a': 
			leftpressed = true;
			break;
		case 's':
			downpressed = true;
			break;
		case 'w':
			uppressed = true;
			break;
		case 'd':
			rightpressed = true;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyChar()){
		case 'a': 
			leftpressed = false;
			break;
		case 's':
			downpressed = false;
			break;
		case 'w':
			uppressed = false;
			break;
		case 'd':
			rightpressed = false;
			break;
		case KeyEvent.VK_ESCAPE:
			running = !running;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//unpause();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//pause();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(running)
			shooting = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(running)
			shooting = false;
		
	}
	
	
}
