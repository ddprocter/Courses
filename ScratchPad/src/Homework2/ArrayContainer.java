package Homework2;

public class ArrayContainer {
	double[] array;
	
	public ArrayContainer(double[] array){
		this.array = array;
		
		
	}
	
	
	public void reverse(double[] array){
		double[] reversedArray = new double[array.length];
		
		for (int i = 0; i< array.length; i++) {
			reversedArray[array.length -1 - i] = array[i]; 
			
		}
		this.array = reversedArray;
		
		
	}
	// Radhika's method
	// uses temp to swap first and last, next and next to last
	// method to reverse the contents of an array
	public void reverse2(double[] array) { 
		for (int i = 0; i < array.length/2; i++) {   
			// store the ith element into temp 
			double temp = array[i];
			// store the (n-i)th element into the ith location,
			// where n is the index of the last array element
			array[i] = array[(array.length - 1) - i];
			// store the element in temp into the (n-i)th index
			array[(array.length - 1) - i] = temp;
			}
	}
	

	public static void main(String[] args) {
		double[] seedArray =  {1,2,3,4,5,6,7,8,9};
		ArrayContainer container = new ArrayContainer(seedArray);
		container.reverse(container.array);
		
		for(int i = 0; i<container.array.length; i++) {
			System.out.println(container.array[i]);
			
		}
		
		
		

	}



}
