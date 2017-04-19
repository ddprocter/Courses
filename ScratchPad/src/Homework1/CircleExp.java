package Homework1;
import java.awt.geom.*;
import programwithjava.basic.*;


public class CircleExp {
	

		public static void main(String[] args) {
			DrawingKit dk = new DrawingKit("ConcentricCircles");
			
			Ellipse2D.Float circle = new Ellipse2D.Float(125, 125, 100, 100);
			Ellipse2D.Float circle2 = new Ellipse2D.Float(125, 125, 2 , );
			dk.draw(circle);
			dk.draw(circle2);
				


		}

		
}
