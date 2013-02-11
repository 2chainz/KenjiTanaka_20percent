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

import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable, KeyListener, MouseListener {
	
	String Version = "0.0.2";

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
		p = new Player();
		bf.show();
		while(true){
			if(running){
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, c.getWidth(), c.getHeight());
				p.pointAtMouse(this.getLocation());
				g.setColor(Color.WHITE);
				p.move(dx,dy);
				if(shooting == true){
					p.shoot();
				}
				g.drawPolygon(p);
				bf.show();
			} else {
				System.out.println("paused");
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyChar()){
		case 'a': 
			dx = -1;
			break;
		case 's':
			dy = 1;
			break;
		case 'w':
			dy = -1;
			break;
		case 'd':
			dx = 1;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyChar()){
		case 'a': 
		case 'd':
			dx = 0;
			break;
		case 's':
		case 'w':
			dy = 0;
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
		unpause();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		pause();
		
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
