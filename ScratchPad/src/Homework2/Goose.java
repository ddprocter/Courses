package Homework2;

import java.util.Scanner;

public class Goose extends Bird {
	
	public void chirp(){
		
		System.out.println("Honk");
		
	}

	public static void main(String[] args) {
		Bird bird;
		
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter 1 for a Goose, 2 for a Mallard, 3 for a Crow:");
		int n = reader.nextInt(); 
		if (n == 1) {
			bird = new Goose();
			bird.chirp();
			
		} else if (n == 2 ) {
			bird = new Mallard();
			bird.chirp();			
			
		} else if (n == 3 ) {
			bird = new Crow();
			bird.chirp();			
		
		}
		reader.close();
		

	}

}
