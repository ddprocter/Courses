package programwithjava.animation;

import java.awt.Graphics2D;
import java.awt.geom.*;

public class Airplane extends Vehicle {

	@Override
	public void drawShape(Graphics2D myGraphics) {
		//body
		Line2D line1 = new Line2D.Float(x,y,x-4,y-10);
		myGraphics.draw(line1);
		Line2D line2 = new Line2D.Float(x-4,y-10,x+120,y-95);
		myGraphics.draw(line2);
		QuadCurve2D curve1 = new QuadCurve2D.Float();
		curve1.setCurve(x+120,y-95,x+190,y-115,x+130,y-65);
		myGraphics.draw(curve1);
		Line2D line3 = new Line2D.Float(x+130,y-65,x+115,y-55);
		myGraphics.draw(line3);
		Line2D line4 = new Line2D.Float(x+81, y-36,x+115, y-55);
		myGraphics.draw(line4);
		Line2D line5 = new Line2D.Float(x,y,x+4,y);
		myGraphics.draw(line5);
		
		// left wing
		Line2D wing1 = new Line2D.Float(x+89,y-75,x,y-80);
		myGraphics.draw(wing1);
		Line2D wing2 = new Line2D.Float(x,y-80,x-10,y-70);
		myGraphics.draw(wing2);
		Line2D wing3 = new Line2D.Float(x-10,y-70,x+58,y-52);
		myGraphics.draw(wing3);
		
		// right wing
		Line2D wing4 = new Line2D.Float(x+110,y-60,x+165,y);
		myGraphics.draw(wing4);
		Line2D wing5 = new Line2D.Float(x+165,y,x+150,y+5);
		myGraphics.draw(wing5);
		Line2D wing6 = new Line2D.Float(x+150,y+5,x+76,y-40);
		myGraphics.draw(wing6);
		Line2D wing7 = new Line2D.Float(x+110,y-60,x+76,y-40);
		myGraphics.draw(wing6);
		
		// tail
		Line2D tail1 = new Line2D.Float(x+16,y-10,x+10,y+15);
		myGraphics.draw(tail1);
		Line2D tail2 = new Line2D.Float(x+10,y+15,x+5,y+18);
		myGraphics.draw(tail2);
		Line2D tail3 = new Line2D.Float(x+5,y+18,x+5,y-1);
		myGraphics.draw(tail3);
		Line2D tail4 = new Line2D.Float(x+5,y-1,x+16,y-10);
		myGraphics.draw(tail4);
		Line2D tail5 = new Line2D.Float(x+15,y-25,x-10,y-40);
		myGraphics.draw(tail5);
		Line2D tail6 = new Line2D.Float(x-10,y-40,x-20,y-35);
		myGraphics.draw(tail6);
		Line2D tail7 = new Line2D.Float(x-20,y-35,x,y-14);
		myGraphics.draw(tail7);
		Line2D tail8 = new Line2D.Float(x,y-14,x-15,y-14);
		myGraphics.draw(tail8);
		Line2D tail9 = new Line2D.Float(x-15,y-14,x-18,y-10);
		myGraphics.draw(tail9);
		Line2D tail10 = new Line2D.Float(x-18,y-10,x-2,y-6);
		myGraphics.draw(tail10);
		
		
		

		

	}
	
	protected void step(){
		
		y = y - 1.5f;
		x = x + 2.5f;
	}
	
	
	
	
}
