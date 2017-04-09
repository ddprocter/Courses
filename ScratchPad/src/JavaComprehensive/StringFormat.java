package JavaComprehensive;

public class StringFormat {

	static double val1 = 10.5678;
	static int val2 = 15;
	static String val3 = "someString";
	
	public static void main(String[] args) {
		String s1 = String.format("val1 = %f, val2 = %d",  val1, val2);
		System.out.println(s1);
		//String s2 = String.format("val1 = %d, val2 = %f", val1, val2); //failed conversion - float to %d, and d to float after you fix that
		//System.out.println(s2);
		//String s3 = String.format("val1 = %f, val2 = %d, %c", val1, val2); //MissingFormatArgumentException - extra %c with no value
		//System.out.println(s3);
		String s4 = String.format("val1 = %f, val2 = %d, %s", val1, val2, "test"); // ok 
		System.out.println(s4);
		String s5 = String.format("val1 = %f, val2 = %d, %s", val1, val2, val3); // ok
		System.out.println(s5);
		String s6 = String.format("val1 = %10.2f", val1);
		System.out.println(s6);
		

	}

}
