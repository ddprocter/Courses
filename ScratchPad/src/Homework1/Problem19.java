package Homework1;
import java.awt.geom.*;
import programwithjava.basic.*;

public class Problem19 {

	public static void main(String[] args) {
		DrawingKit dk = new DrawingKit("ConcentricCircles");
		float x=125, y=125, r=100;
		int step = 10;
		int iteration = 1;
		float finalDiameter = 0;
		
		while (r - iteration*step >= 20.0) {
			Ellipse2D.Float circle = new Ellipse2D.Float( x+iteration*step, y+iteration*step, 2*(r-iteration*step), 2*(r-iteration*step));
			dk.draw(circle);
			iteration++;
	
		}
		System.out.println("Number of Circles = " + iteration);
		finalDiameter = (r-iteration*step) * 2; 
		System.out.println("Diameter of inner most circle = " + finalDiameter);

	}

	
}
