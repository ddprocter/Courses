import java.awt.*;
import java.awt.geom.*;
import programwithjava.basic.DrawingKit;



public class TestColor {

	public static void main(String[] args) {
		DrawingKit dk = new DrawingKit("New Color");
		Rectangle2D.Double r = new Rectangle2D.Double(100.0, 100.0, 250.0, 120.0);
		Color newColor = new Color(127,25,50);
		dk.setPaint(newColor);
		dk.fill(r);

	}

	
	
}
