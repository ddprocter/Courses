package programwithjava.animation;

import java.util.Random;
import programwithjava.basic.DrawingKit;

public class TestRandomVehicle {
	
	public static void main (String args[]) {
		Vehicle myVehicle;
		Random rand = new Random();
		int vehicleType = rand.nextInt(2);
		
		if ( vehicleType == 0) 
			myVehicle = new Car();
		else
			myVehicle = new Airplane();
		
		myVehicle.drawShape(myGraphics);
	}
	
}
