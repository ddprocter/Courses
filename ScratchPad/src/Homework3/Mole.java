package Homework3;

public class Mole implements Excavator {
	
	private int distance;
	private String digType;
	
	public Mole(int distance, String digType){
		this.distance = distance;
		this.digType = digType;
		
	}
	
public void dig() {
		
		System.out.println("Mole starting dig at " + digType + ".  Digging a hole " + distance + " feet long." );
		
		
	}

}
