package homework5;

import java.util.Random;

public class Car {
	
	public Car(){
		
		
	}
	
	public void diagnostics() throws Exception {
		
		Random rand = new Random();
		int diagCode = rand.nextInt(10);
		
		if(diagCode == 1) 
			throw new DeadBatteryException("Diagnostic: DeadBatteryException");
		if(diagCode == 2)
			throw new BadIgnitionException("Diagnostic: BadIgnitionException");
		if(diagCode == 3) 
			throw new NoStartException("Diagnostic: NoStartException");
		if(diagCode == 4) 
			throw new BrakeLightException("Diagnostic: BrakeLightException");
		if(diagCode == 5) 
			throw new TailLightException("Diagnostic: TailLightException");
		if(diagCode == 6) 
			throw new HeadLightException("Diagnostic: HeadLightException");
		if(diagCode == 7) 
			throw new LightsException("Diagnostic: LightsException");
		if(diagCode == 8) 
			throw new ParkingBrakeException("Diagnostic: ParkingBrakeException");
		if(diagCode == 9) 
			throw new FootBrakeException("Diagnostic: FootBrakeException");
		if(diagCode == 10) 
			throw new BrakeException("Diagnostic: BrakeException");
		
		System.out.println("Diagnostic Test Completed: No Problems Found");
	
			
	} // diagnostics
	
	public void display() throws Exception {
		
		try {
			this.diagnostics();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args)  {
		Car car = new Car();
		try {
			car.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
