package JavaComprehensive;

import java.io.*;

public class BufferedFileReaderWriterDemo {
	
	public static void main(String[] args){
		
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		FileWriter writer = null;
		BufferedWriter bufferedWriter = null;
		
		try{
			reader = new FileReader(new File("./src/JavaComprehensive/text/info.txt"));
			writer = new FileWriter(new File("./src/JavaComprehensive/text/copyOfInfo.txt"));
			
			bufferedReader = new BufferedReader(reader);
			bufferedWriter = new BufferedWriter(writer);
			
			
			int ch;
			while ((ch = bufferedReader.read())!= -1) {
				
				System.out.println((char) ch);
				bufferedWriter.write(ch);
				bufferedReader.skip(1);
				
				
				
			}
		} catch (FileNotFoundException e){
			System.out.println("File could not be found: " + e.getMessage());
		} catch (IOException e){
			System.out.println("IOException: " + e.getMessage());
		
		} finally {
			try { 
				bufferedReader.close();
				bufferedWriter.flush();
				bufferedWriter.close();
				reader.close();
				writer.close();
			} catch (IOException e) {
				System.out.println("IOException: " + e.getMessage());
			}
		}
	}
		
		

}


