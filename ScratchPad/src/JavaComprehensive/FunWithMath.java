package JavaComprehensive;

public class FunWithMath {

	public static void main(String[] args) {
		double n1 = -85.6;
		double n2 = 70.4;
		int angle = 45;
		System.out.println(String.format("The larger of %.2f and %.2f is %.2f", n1, n2, +Math.max(n1,n2)));
		System.out.println(String.format("The smaller of %.2f and %.2f is %.2f", n1, n2, +Math.min(n1,n2)));

		System.out.println(String.format("the value of %.2f raised to the power of 5 is %.2f", n2, +Math.pow(n2,5)));
		
		System.out.println(String.format("abs(%.2f) = %.2f", n1, +Math.abs(n1)));
		

	}

}
