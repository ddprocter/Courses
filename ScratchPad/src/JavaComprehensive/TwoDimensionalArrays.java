package JavaComprehensive;

public class TwoDimensionalArrays {

	public TwoDimensionalArrays() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[][] numArray = {
				{0,1,2},
				{3,4,5},
				{6,7,8},
				{9,10,11}
			};
		
		
		for(int i=0; i<numArray.length; i++) {
			for(int j=0; j<=2; j++){
				
				numArray[i][j] += 5;
				System.out.println("["+i+"]["+j+"]=" + numArray[i][j]);
				
			}
			
		}
		
	}
}

