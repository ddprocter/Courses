package JavaComprehensive;

import java.awt.*;
import java.awt.geom.*;
import programwithjava.basic.DrawingKit;


public class ColoredEllipse extends Ellipse2D.Float implements ColorMixable {

	protected Color ellipseColor;
	
	public ColoredEllipse(){
		this(0,0,0,0);
		
	}
	
	public ColoredEllipse(float x, float y, float w, float h){
		super(x,y,w,h);
		ellipseColor = new Color(255,255,255);
	}
	
	public Color getColor(){
		return ellipseColor;
		
	}
	
	public void setColor(Color c){
		ellipseColor = c;
		
	}
	
	public void mixColor(Color c){
		
		int red = (ellipseColor.getRed()+c.getRed())/2;
		int blue = (ellipseColor.getBlue()+c.getBlue())/2;
		int green = (ellipseColor.getGreen()+c.getGreen())/2;
		 ellipseColor = new Color(red, green, blue);
		
	}
	
	public static void main(String[] args) {
		DrawingKit dk = new DrawingKit("CE");
		Graphics2D g2 = dk.getGraphics();
		
		ColoredEllipse ce = new ColoredEllipse(150,125,200,250);
		ce.setColor(Color.red);
		ce.mixColor(Color.yellow);
		ce.mixColor(Color.blue);
		g2.setPaint(ce.getColor());
		g2.fill(ce);
		
		
		
	}

	
	
}
