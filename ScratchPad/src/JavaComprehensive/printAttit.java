package JavaComprehensive;

public class printAttit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static void printAttitude(int i) {
		
		String resp = "";
		switch (i) {
			
			case 1: resp = "disagree";
				break;
			case 2: resp = "no opinion";
				break;
			case 3: resp = "agree";
				break;
			default:
				break;
			
		}
	}	
		 
	
	
	public double powerTo (double d, int i) {
			 	
				return (i <=0) ? 0 : java.lang.Math.pow(d, (double) i);
			 	
		 }
		
		
	
	public int findMin(int i, int j) {
	    return java.lang.Math.min(i,j);
	    
	}
	
}



