package Asteroids;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable, KeyListener {

	public static void main(String[] args){
		new GameWindow();
	}
	
	Canvas c = new Canvas();
	BufferStrategy bf;
	Graphics g;
	Player p;
	int dx, dy;
	
	public GameWindow(){
		super("Asteroids in Java");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		c.setSize(getSize());
		c.setBackground(Color.BLACK); 
		add(c);
		c.addKeyListener(this);
		
		c.createBufferStrategy(2);
		bf = c.getBufferStrategy();
		g = bf.getDrawGraphics();
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		p = new Player();
		bf.show();
		while(true){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, c.getWidth(), c.getHeight());
			p.pointAtMouse(this.getLocation());
			g.setColor(Color.WHITE);
			p.move(dx,dy);
			g.drawPolygon(p);
			bf.show();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyChar());
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
	
	
}
