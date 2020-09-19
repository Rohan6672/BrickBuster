package jrJava.brickBuster_ML;

import java.awt.Color;

import resources.DrawingBoard;

public class BrickManager {

	private Brick[] bricks;
	private int brickWidth;
	private int brickHeight;
	
	private int x, y;
	private int numOfLiveBricks;
	
	
	// 1. Create all managees (bricks), Also create array (data structutr and access control)
	public BrickManager(int x, int y, int brickWidth, int brickHeight, int numOfBricks){
		this.x = x;
		this.y = y;
		this.brickWidth = brickWidth;
		this.brickHeight = brickHeight;
		numOfLiveBricks = numOfBricks;
		
		bricks = new Brick[numOfBricks];
		
		Color color;
		boolean isBottomOne = false;;
		for(int i=0; i<bricks.length; i++){
			color = new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
			if(i==bricks.length-1) isBottomOne = true;
			bricks[i] = new Brick(x, y+brickHeight*i, brickWidth, brickHeight, color, isBottomOne);
		}
		
	}
	
	// 2. Use managees (delegatiion)
	public void draw(DrawingBoard board){
		for(int i=0; i<numOfLiveBricks; i++){
			bricks[i].draw(board); 
		}
	}
	
	
	public boolean isHit(Ball ball){
		
		for(int i=0; i<numOfLiveBricks; i++){
			if(bricks[i].isHit(ball)){
				
				// if it is the bottom one:
				if(i==numOfLiveBricks-1){
					bricks[i] = null;
					if(i>0) bricks[i-1].setAsBottomOne();
				}
				// if it is a middle one:
				else {
					
					for(int j=i+1; j<numOfLiveBricks; j++){
						bricks[j].shiftUp();
						bricks[j-1] = bricks[j];
					}
					bricks[numOfLiveBricks-1] = null;
				}
				
				numOfLiveBricks--;
				return true;
			}
		}
		
		return false;
	}
	
	
	// 3. If busted, garbage-collect them.
	
	
}











