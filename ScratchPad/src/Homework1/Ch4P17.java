package Homework1;
import java.awt.geom.*;
import programwithjava.basic.*;

public class Ch4P17 {

	public static void main(String[] args) {
		DrawingKit dk = new DrawingKit("ConcentricCircles");
		float x=125, y=125, r=100;
		int step = 10;
		int i = 0; // start at 0 for r=100 circle
		float mostRecentDiameter = 0; // captures the diameter of the latest drawn circle at any time
		
		while ( 2*(r - i*step) >= 20.0) { // while diameter >= 20
			Ellipse2D.Float circle = new Ellipse2D.Float( x+i*step, y+i*step, 2*(r-i*step), 2*(r-i*step));
			mostRecentDiameter = (r-i*step) * 2; // must capture diameter before i is incremented final time
			dk.draw(circle);
			i++; // counts each circle AFTER it is drawn.  Final i = total number of circles drawn. 
	
		}
		System.out.println("Number of Circles = " + i); 
		System.out.println("Diameter of inner most circle = " + mostRecentDiameter);

	}

	
}
