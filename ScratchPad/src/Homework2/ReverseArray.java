package Homework2;

public class ReverseArray {
	
	
	public static double[] reverse(double[] array){
		double[] reversedArray = new double[array.length];
		
		for (int i = 0; i< array.length; i++) {
			reversedArray[array.length -1 - i] = array[i]; 
			
		}
		return reversedArray;
		
		
	}

	public static void main(String[] args) {
		double[] testArray =  {1,2,3,4,5,6,7,8,9};
		double[] reversedArray = new double[testArray.length];
		reversedArray = reverse(testArray);
		for(int i = 0; i<reversedArray.length; i++) {
			System.out.println(reversedArray[i]);
			
		}
		
		
		

	}

}
