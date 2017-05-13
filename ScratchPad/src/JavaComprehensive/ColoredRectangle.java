package JavaComprehensive;

import java.awt.*;
import java.awt.geom.*;


public class ColoredRectangle extends Ellipse2D.Float implements ColorMixable {

	protected Color rectangleColor;
	
	public ColoredRectangle(){
		this(0,0,0,0);
		
	}
	
	public ColoredRectangle(float x, float y, float w, float h){
		super(x,y,w,h);
		rectangleColor = new Color(255,255,255);
	}
	
	public Color getColor(){
		return rectangleColor;
		
	}
	
	public void setColor(Color c){
		rectangleColor = c;
		
	}
	
	public void mixColor(Color c){
		
		int red = (rectangleColor.getRed()+c.getRed())/2;
		int blue = (rectangleColor.getBlue()+c.getBlue())/2;
		int green = (rectangleColor.getGreen()+c.getGreen())/2;
		rectangleColor = new Color(red, green, blue);
		
	}
	
	

}
