package Homework3;

public class Archaeologist implements Excavator {
	
	private int depth;
	private String site;
	
	public Archaeologist(int depth, String site) {
		this.depth = depth;
		this.site = site;
	}

	public void dig() {
		
		System.out.println("Archaeologist digging at " + site + ".  Digging to " + depth + " thousand years BCE." );
		
		
	}

}
