package Homework1;

public class IDCard {
	
	private String name;
	private int idNumber;
	private String photoFilename;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhotoFilename() {
		return photoFilename;
	}

	public void setPhotoFilename(String photoFilename) {
		this.photoFilename = photoFilename;
	}

	public IDCard(String name, int idNumber, String photoFilename) {
	
		this.name = name;
		this.idNumber = idNumber;
		this.photoFilename = photoFilename;
	}

	public IDCard(){
		
	}
	
	public static void printIDCardDetails(IDCard ID) {
		
		System.out.println("=====================");
		System.out.println("Name: " + ID.getName());
		System.out.println("ID Number: " + ID.getIdNumber());
		System.out.println("Photo Location: " + ID.getPhotoFilename());
		System.out.println("=====================\n\n");
		
	}
	

}
