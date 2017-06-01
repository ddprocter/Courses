package JavaComprehensive;

import java.io.*;

public class FileReaderWriterDemo {
	
	public static void main(String[] args){
		
		FileReader reader = null;
		FileWriter writer;
		
		try{
			reader = new FileReader(new File("./src/JavaComprehensive/text/info.txt"));
			writer = new FileWriter(new File("./src/JavaComprehensive/text/copyOfInfo.txt"));
			
			
			int ch;
			while ((ch = reader.read())!= -1) {
				System.out.println((char) ch);
				writer.write(ch);
				
				
				
			}
			reader.close();
			writer.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File could not be found: " + e.getMessage());
		} catch (IOException e){
			System.out.println("IOException: " + e.getMessage());
		
		}

	}

}
