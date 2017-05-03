package programwithjava.animation;

import java.awt.Graphics2D;

public class Car extends Vehicle {
	
	

	@Override
	public void drawShape(Graphics2D myGraphics) {
		// TODO Auto-generated method stub

	}
	
	protected void step(){
		
		y = y + 1.5f;
		x = x - 2.5f; 
	}

	
	
}
