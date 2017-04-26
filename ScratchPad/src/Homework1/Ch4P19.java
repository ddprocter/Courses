package Homework1;
import java.awt.*;
import java.awt.geom.*;
import programwithjava.basic.*;


public class Ch4P19 {

	public static void main(String[] args) {
		DrawingKit dk = new DrawingKit("Squares");
		int x=10;
		int y=30;
		int side = 20;
		int distBetweenSides = 10;
		int numRows = 9;
		int numSquares = 9;
		
		
		for (int r = 1; r<=numRows; r++) {
			
			for(int s=1; s<=numSquares; s++) {
				Rectangle2D.Float rect_same = new Rectangle2D.Float (x,y,side, side);
				dk.setPaint(Color.blue);
				dk.fill(rect_same);
				x = x+side+distBetweenSides;
				
			}
			x=10;
			y = y + side + distBetweenSides;
			
			
		}			
			
	


	}

}
