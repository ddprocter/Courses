package JavaComprehensive;

/**
 * The lamp class blah blah
 * 
 * 
 * 
 * 
 * @author Dave P
 * 
 * 
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import programwithjava.basic.*;

import programwithjava.basic.*;

public class Lamp {
	
		private double diameter;
		private int wattage;
		private boolean lighted;
		private Ellipse2D.Double circle;
		private boolean visible = false;
		
	
		public static void main(String[] args) {
		
			Lamp myLamp = new Lamp();
			DrawingKit dk = new DrawingKit("New Window");
			Graphics2D graphics = dk.getGraphics();
			myLamp.drawOutline(10, 10, graphics);
			myLamp.turnOff(graphics);
			
			
		

		}
	
		/** 
		 * Default constructor, sets diameter 3.0, wattage 30, not lighted
		 */
		
		Lamp() {
			diameter = 3.0;
			wattage = 30;
			lighted = false;
			
			
		}
		
		/**
		 * Constructo to create a lamp with a specified diameter, brightness and state
		 * @param dia
		 * @param watt
		 * @param light
		 */
		
		public Lamp(double dia, int watt, boolean light){
			diameter = dia;
			wattage = watt;
			lighted = light;
		}
		
		
		
		/**
		 * Method to draw the lamp
		 * @param x - x location of the lamp
		 * @param y - y location of the lamp
		 * @param myGraphics - graphics/window object
		 */
		public void drawOutline(int x, int y, Graphics2D myGraphics) {
			int w=20;
			int z = 50;
			visible = true;
			myGraphics.setPaint(Color.black);
			circle = new Ellipse2D.Double(x, y, diameter * w, diameter*w);
			myGraphics.draw(circle);
			Line2D line = new Line2D.Double(x+diameter * w/2, y, x+diameter * w/2, y-z);
			myGraphics.draw(line);
			
		}
		
		
		public void turnOn(Graphics2D myGraphics) {
			this.lighted=true;
			if(visible){
				myGraphics.setPaint(Color.yellow);
				myGraphics.fill(circle);
			}
			
		}
		
		public void turnOff(Graphics2D myGraphics) {
			this.lighted=false;
			if(visible){
				myGraphics.setPaint(Color.gray);
				myGraphics.fill(circle);
			}
			
		}

		/**
		 * Method to get lamp diameter
		 * @return the diameter of the lamp
		 */
		public double getDiameter() {
			return this.diameter;
		}
		
		
		public boolean isLighted() {
			return this.lighted;
		}
		
		public int getWattage() {
			return wattage;
		}
		
		public void setDiameter(double diameter){
			this.diameter = diameter; 
		}
		
		
		
		
		

}
