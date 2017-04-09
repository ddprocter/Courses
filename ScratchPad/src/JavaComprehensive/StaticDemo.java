package JavaComprehensive;

public class StaticDemo {
	
	static int staticField; 
	int instanceField;

	public static void main(String[] args) {
		StaticDemo sd1 = new StaticDemo();
		StaticDemo sd2 = new StaticDemo();
		sd1.staticField = 102;
		sd1.instanceField = 103;
		System.out.println("sd2.staticField = " + sd2.staticField);
		System.out.println("sd2.instanceField = " + sd2.instanceField);
		
		// output - staticField =102 - since it was 
		// updated on sd1, update propragates to all 
		// members of the class, i.e. sd2
		// this is not true for sd2.instance field
		// because it is not declared as static
		
		
		
	}

}
