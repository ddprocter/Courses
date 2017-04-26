package ch5p6b;

import ch5p6a.*;
// or import import ch5p6a.CheckAccess; 

public class Test {

	public static void main(String[] args) {
		CheckAccess c = new CheckAccess();
		// or if you omitted the import you could prefix CheckAccess with its package name
		// ch5p6a.CheckAccess c = new ch5p6a.CheckAccess();
		System.out.println(c.getCode());
	}

}