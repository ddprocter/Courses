package Homework2;

public class GardenSpider extends Spider {
	
	public GardenSpider(){
		
		System.out.println("Executing GardenSpider Constructor");
	}
	
	public void printNumberOfLegs(){ 
		System.out.println("Num of Legs = " + this.numberOfLegs);
		
	}


	public static void main(String[] args) {
		GardenSpider spider = new GardenSpider();
		spider.printNumberOfLegs();
		
	}

}
