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

	public static void main(String[] args) {
		double[] seedArray =  {1,2,3,4,5,6,7,8,9};
		ArrayContainer container = new ArrayContainer(seedArray);
		container.reverse(container.array);
		
		for(int i = 0; i<container.array.length; i++) {
			System.out.println(container.array[i]);
			
		}
		
		
		

	}



}
