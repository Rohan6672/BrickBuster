package jrJava.brickBuster_ML;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class Ball {

	private int x, y; // center
	private int vx, vy;
	private int radius;
	private Color color;
	private Wall wall;
	private Deflector deflector;
	private BrickManager[] brickManagers;
	private SoundPlayer sound;
	
	
	public Ball(int x, int y, int vx, int vy, int radius, Color color){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.radius = radius;
		this.color = color;
		
		sound = new SoundPlayer("jrJava/brickBuster_ML/boing.wav");
	}
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getRadius(){ return radius; }
	public int getVX(){ return vx; }
	public int getVY(){ return vy; }
	
	public void setX(int x){ this.x = x; }
	public void setY(int y){ this.y = y; }
	public void setVX(int vx){ this.vx = vx; }
	public void setVY(int vy){ this.vy = vy; }
	
	
	public void setBrickManagers(BrickManager[] brickManagers){
		this.brickManagers = brickManagers;
	}
	
	
	public void setWall(Wall wall){
		this.wall = wall;
	}
	
	
	public void setDeflector(Deflector deflector){
		this.deflector = deflector;
	}
	
	
	public void move(){
		x += vx; //x = x + vx;
		y += vy; //y = y + vy;
		
		//check collision with wall
		if(x<=wall.getLeft()+radius){
			x = wall.getLeft()+radius;
			vx = -vx;
		}
		else if(x>=wall.getRight()-radius){
			x = wall.getRight()-radius;
			vx = -vx;
		}
		
		if(y<=wall.getTop()+radius){
			y = wall.getTop()+radius;
			vy = -vy;
		}
		
		//check collision with deflector
		if(x>=deflector.getX()-radius &&
		   x<=deflector.getX()+deflector.getWidth()+radius &&
		   y>=deflector.getY()-radius &&
		   y<=deflector.getY()+deflector.getHeight() ){
			
			y = deflector.getY()-radius;
			vy = -vy;
		}
		
		// check collision with bricks.
		for(int i=0; i<brickManagers.length; i++){
			boolean result = brickManagers[i].isHit(this);
			if(result){
				sound.play();
				break;
			}
		}
		
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
	
}









