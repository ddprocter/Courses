package Homework1;

public class TestIDCard {

	public static void main(String[] args) {
		
		IDCard ID1 = new IDCard();
		ID1.setName("Jane Doe");
		ID1.setIdNumber(4281398);
		ID1.setPhotoFilename("C:/Pictures/" + ID1.getName() + ".jpg");
		System.out.println("IDCard1: Constructed with default constructor");
		IDCard.printIDCardDetails(ID1);
		
		
		IDCard ID2 = new IDCard("Joe Smith", 2067831, "C:/Pictures/JoeSmith.jpg");
		System.out.println("IDCard2: Constructed with full constructor");
		IDCard.printIDCardDetails(ID2);
		
	}
	
	
	
	

}
