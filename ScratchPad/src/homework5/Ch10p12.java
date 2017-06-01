package homework5;

import java.io.*;


public class Ch10p12 {
	
	

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("/wrongpath/text/info.txt");
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
			
		}
		
		

	}

}
