package Homework3;

public class Data {
	
	private int a; 
	private String b;
	private Display printer;

	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public Data(int a, String b) {
		this.a = a;
		this.b = b;
		this.printer = new Display();
	}

	private class Display{
		
		private Display(){
			
		}
		
		private void print(){
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			
		}
		
		
	}
	
	public static void main(String[] args){
		
		Data data = new Data(1, "Test");
		data.printer.print();
		
		
	}

}
