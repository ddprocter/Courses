package JavaComprehensive;

import java.awt.*;


public class InterfaceDemo {
	
	public static boolean compare(ColorMixable m1, ColorMixable m2){
		Color c1 = m1.getColor();
		Color c2 = m2.getColor();
		
		if ( c1.getRed() == c2.getRed() && c1.getGreen() == c2.getGreen()
				&& c1.getBlue() == c2.getBlue()) 
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		ColoredEllipse ce = new ColoredEllipse(20,20,30,20);
		ce.setColor(Color.red);
		ColoredRectangle cr = new ColoredRectangle(20,20,30,20);
		cr.setColor(Color.red);
		System.out.println(InterfaceDemo.compare(ce, cr));
		
	}

}
