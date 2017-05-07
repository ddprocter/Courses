package JavaComprehensive;

public class TestArray {
	
	public static void print(int[] array) {
		for (int value : array){
			System.out.println(value);
		}
	}

	public static void increment(int[] array){
		for (int i=0; i<array.length; i++) {
			array[i]++;
		}
	}
	
	public static void main(String[] args) {
		int[] newArray = {10, -9, 8, -7, 6};
		TestArray.increment(newArray);
		TestArray.print(newArray);
		
	}
}
