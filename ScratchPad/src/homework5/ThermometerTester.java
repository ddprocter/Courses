package homework5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ThermometerTester {

	public static void main(String[] args) throws Exception {
		Thermometer t = new Thermometer();
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter type of Thermometer - Mercury or Digital:\n");
		t.setType(scanner.next());
		System.out.print("Enter Temperature:\n");
		t.setTemperature(scanner.nextInt());
		scanner.close();

		
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/JavaComprehensive/text/thermometer.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(t);
			objectOut.close();
			
			t.setTemperature(-273);
			t.setType(null);
			
			System.out.println("Thermometer written to file");
			System.out.println("Thermometer object cleared:");
			System.out.println("Temp = " + t.getTemperature());
			System.out.println("Type = " + t.getType());
			
			
		} catch (Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		try {
			FileInputStream fileIn = new FileInputStream("./src/JavaComprehensive/text/thermometer.dat");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			t = (Thermometer) objectIn.readObject();
			objectIn.close();
			
			System.out.println("Thermometer read from file");
			System.out.println("Temp = " + t.getTemperature());
			System.out.println("Type = " + t.getType());
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

}
