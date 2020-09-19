package jrJava.brickBuster_ML;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Wall {

	private int left = 20;
	private int right = 520;
	private int top = 20;
	private int bottom = 630;
	private Color color = Color.gray;
	
	
	public Wall(){ }
	
	
	public int getLeft(){ return left; }
	public int getRight(){ return right; }
	public int getTop(){ return top; }
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.drawLine(left, top, right, top);
		canvas.drawLine(left, top, left, bottom);
		canvas.drawLine(right, top, right, bottom);
	}
	
}
