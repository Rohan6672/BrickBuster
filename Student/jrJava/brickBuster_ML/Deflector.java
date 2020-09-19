package jrJava.brickBuster_ML;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import resources.DrawingBoard;


public class Deflector implements MouseMotionListener, MouseListener {

	private int x, y; //left, top
	private int width = 50, height = 15;
	private Color color = Color.black;
	private Wall wall;
	private int lastX;
	
	
	public Deflector(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public void setWall(Wall wall){
		this.wall = wall;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, width, height); 
	}


	public void mouseDragged(MouseEvent e) {
		int currentX = e.getX();
		int dx = currentX - lastX;
		
		x += dx;
		lastX = currentX;
		
		if(x<wall.getLeft()) x = wall.getLeft();
		else if(x>wall.getRight()-width) x = wall.getRight()-width;
	}


	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
	}
	
	
	
	public void mouseMoved(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


	
}













