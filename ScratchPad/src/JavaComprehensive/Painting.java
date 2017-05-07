package JavaComprehensive;

public class Painting {
	
	private String name;
	private String artist;
	private int year;
	
	public static void main(String[] args){
		
		Painting[] catalog = new Painting[3];
		
		catalog[0] = new Painting("A", "Van Gough", 1812);
		catalog[1] = new Painting("Guernica", "Picasso", 1933);
		catalog[2] = new Painting("The Last Supper", "Davinci", 1452);
		
		for (Painting cat : catalog ) {
			System.out.println("Name:"+ cat.getName());
			System.out.println("Artist" + cat.getArtist());
			System.out.println("Year:" + cat.getYear());
			
			
		}
		
	}

	public Painting(String name, String artist, int year) {
		this.name = name;
		this.artist=artist;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	
		
}
