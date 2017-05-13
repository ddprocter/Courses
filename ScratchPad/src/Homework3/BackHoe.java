package Homework3;

public class BackHoe implements Excavator {
	
	private int depth; 
	private String jobName;
	
	public BackHoe(int depth, String jobName){
		this.depth = depth;
		this.jobName = jobName;
		
	}
	
	public void dig() {
		
		System.out.println("BackHoe start job " + jobName + ".  Digging to " + depth + " feet." );
		
		
	}
	
	
	

	public static void main(String[] args) {
		BackHoe backHoe = new BackHoe(12, "3rd and Main");
		backHoe.dig();
		Mole mole = new Mole(32, "The Den");
		mole.dig();
		Archaeologist arch = new Archaeologist(10, "King Tut's Tomb");
		arch.dig();
		
		
		

	}

}
