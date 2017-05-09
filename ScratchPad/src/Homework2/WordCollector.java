package Homework2;

import java.util.ArrayList;
import java.util.Scanner;


public class WordCollector {
	
	ArrayList<String> words = new ArrayList<String>();
	
	public void print(){
		System.out.println("\nWords entered:");
		for (int i = 0; i< words.size(); i++) {
			System.out.println(words.get(i));
			
		}
		System.out.println("Total words:" + words.size());
		
	}
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WordCollector wc = new WordCollector();
		boolean done = false;
		String entry; 
		
		while (! done ){ 
			
			entry = scan.next();
			wc.words.add(entry);
			
			if (entry.equals( "END" ) ) {
				done = true;
			}
			entry = null;
			
		}	
		
		scan.close();	 
		
		wc.print();
		
		
		
		
		
	}

}
