package programwithjava.animation;

import java.awt.*;

public abstract class Vehicle {	
  protected static float x = 30, y = 300; // vehicle's position

  // constructor updates x and y to specific values
  public Vehicle() {	
    this(x, y);
  }

  // constructor updates x and y to values passed in as arguments
  public Vehicle(float xValue, float yValue) {	
    x = xValue;
    y = yValue;
  }	

  // method to draw shape of Vehicle
    public abstract void drawShape(Graphics2D myGraphics);	

  // change the (x, y) position by a small amount
	protected abstract void step();
	
}
