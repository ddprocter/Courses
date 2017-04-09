package JavaComprehensive;
import java.awt.geom.*;

public class RectangleExercise {

	
	public static void main(String[] args) {
		System.out.println("Trying Rectangles");
		Rectangle2D BasicRec = new Rectangle2D.Double(); // default constructor is a rec at 0,0 with dims 0,0
		System.out.println("Basic Rec Loc = " + BasicRec.toString()); 
		
		Rectangle2D SpecificRec = new Rectangle2D.Double(1.0, 1.0, 5.0, 3.0); // here we are using a diff constructor passing in loc 1,1, and w=5, h=3)
		System.out.println("Specific Rec Loc = " + SpecificRec.toString());
		
	}

}
