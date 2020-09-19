package jrJava.brickBuster_ML;

import java.awt.Color;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {
		
		//prepare DrawingBoard, Timer
		DrawingBoard board = new DrawingBoard(540, 700);
		Timer timer = new Timer();
		
		//prepare balls: ball1, ball2, ...
		int numOfBalls = 1;
		Ball[] balls = new Ball[numOfBalls];
		
		for(int i=0; i<balls.length; i++){
			Color ballColor = new Color( (int)(Math.random()*120), (int)(Math.random()*120), (int)(Math.random()*120));
			balls[i] = new Ball(300, 500, (int)(Math.random()*6+2), -(int)(Math.random()*8+3), 5, ballColor);
		}
		
		//prepare wall
		Wall wall = new Wall(); 
		
		//prepare deflector
		Deflector deflector = new Deflector(80, 610);
		deflector.setWall(wall); 
		
		board.addMouseMotionListener(deflector);
		board.addMouseListener(deflector); 
		
		int numOfColumns = 10;
		int brickWidth = (wall.getRight()-wall.getLeft())/numOfColumns;
		int brickHeight = brickWidth/5;
		
		BrickManager[] brickManagers = new BrickManager[numOfColumns];
		
		for(int i=0; i<brickManagers.length; i++){
			brickManagers[i] = new BrickManager(wall.getLeft()+i*brickWidth, wall.getTop(), brickWidth, brickHeight, (int)(Math.random()*26+5));
		}
		
		for(int i=0; i<balls.length; i++){
			balls[i].setWall(wall);
			balls[i].setDeflector(deflector);
			balls[i].setBrickManagers(brickManagers);
		}
		
		
		while(true){
			
			for(int i=0; i<balls.length; i++) balls[i].move();
			
			board.clear();
			
			for(int i=0; i<balls.length; i++) balls[i].draw(board);
			
			deflector.draw(board); 
			wall.draw(board);
			
			for(int i=0; i<brickManagers.length; i++) brickManagers[i].draw(board); 
			
			board.repaint();
			timer.pause(7);
		}

	}

}







