package JavaComprehensive;

public class UnaryOperators2 {
	
	public static void main(String[] args) {
		int x = 5, y;
		 
		// Demonstrating prefix decrement
		// first x will be decremented then
		// updated value of x will be assigned to y
		y = --x;
		System.out.println("y : " + y); //will print y : 4
		System.out.println("x : " + x); //will print x : 4
		 
		// Demonstrating postfix decrement
		// first value of x will be assigned to y
		// then x will be decremented
		y = x--;
		System.out.println("y : " + y); //will print y : 4
		System.out.println("x : " + x); //will print x : 3
		 
		//If decrement is made in an independent
		//statement, prefix and postfix modes make no difference.
		--x;
		System.out.println("x : " + x); //will print x : 2
		 
		x--;
		System.out.println("x : " + x); //will print x : 1
	}

}
