package JavaComprehensive;

public class Arrays {

	public Arrays() {
		// TODO Auto-generated constructor stub
	}
	
	// blah  blah commit test
	
	

	public static void main(String[] args) {
		
		int[] arr2 = new int[10];
		
		for (int i : arr2) {
			
			arr2[i] = i * 10 + 3;
		}
		
		for (int i = 0; i<10; i++) {
			System.out.println("arr2["+i+"]:" + arr2[i]);
			
		}

		System.out.println("arr2 length:" + arr2.length);
	}

}
