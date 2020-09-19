package jrJava.brickBuster_ML;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Brick {

	private int x, y; // left, top
	private int width, height;
	private Color color;
	private boolean isBottomOne;
	
	
	
	public Brick(int x, int y, int width, int height, Color color, boolean isBottomOne){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.isBottomOne = isBottomOne;
	}
	
	
	public void setAsBottomOne(){
		isBottomOne = true;
	}
	
	
	public void shiftUp(){
		y -= height;
	}
	
	
	public boolean isHit(Ball ball){
		
		// left side collision
		if(ball.getX()>=x-ball.getRadius() && ball.getX()<=x+width/2 &&  
		   ball.getY()>=y && ball.getY()<y+height ){
			
			ball.setX( x - ball.getRadius() );
			ball.setVX( -ball.getVX() );
			return true;
		}
		
		// right side collision
		if(ball.getX()>=x+width/2 && ball.getX()<=x+width+ball.getRadius() &&  
		   ball.getY()>=y && ball.getY()<y+height ){
					
			ball.setX( x + width + ball.getRadius() );
			ball.setVX( -ball.getVX() );
			return true;
		}
		
		// bottom side collision
		if(isBottomOne){
			if(ball.getX()>=x-ball.getRadius() && ball.getX()<=x+width+ball.getRadius() &&
			   ball.getY()>=y+height && ball.getY()<=y+height+ball.getRadius() ){
				
				ball.setY( y + height + ball.getRadius() );
				ball.setVY( Math.abs(ball.getVY()) );
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public void draw(DrawingBoard board){
		
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, width, height); 
		canvas.setColor(Color.black);
		canvas.drawRect(x, y, width, height); 
	}
	
	
}








