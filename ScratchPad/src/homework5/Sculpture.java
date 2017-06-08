package homework5;

import java.util.HashSet;
import java.util.Iterator;

public class Sculpture {
	private String name;
	private String sculptor;
	private String year;
	
	public Sculpture(String name, String sculptor, String year) {
		this.name = name;
		this.sculptor = sculptor;
		this.year = year;
		
		
	}
	
	public boolean equals(Object s){
		if (s instanceof Sculpture){
			if (
					name.equals(((Sculpture) s).getName()) & 
					sculptor.equals(((Sculpture) s).getSculptor()) & 
					year.equals(((Sculpture) s).getYear()) 
				) {
				return true;
			}
				
		}
		return false;
		
	}
	
	public int hashCode(){
		return name.hashCode();
	}
	

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSculptor() {
		return sculptor;
	}




	public void setSculptor(String sculptor) {
		this.sculptor = sculptor;
	}




	public String getYear() {
		return year;
	}




	public void setYear(String year) {
		this.year = year;
	}




	public static void main(String[] args) {
		HashSet<Sculpture> s = new HashSet<Sculpture>();
		Sculpture david = new Sculpture("David", "Michaelangelo", "1578");
		Sculpture david2 = new Sculpture("David", "Michaelangelo", "1578");
		Sculpture pieta = new Sculpture("Pieta", "Michaelangelo", "1579");
		Sculpture thinker = new Sculpture("The Thinker", "Rodin", "1872");
		Sculpture thinker2 = new Sculpture("The Thinker", "Rodin", "1872");
		Sculpture liberty = new Sculpture("Statue of Liberty", "Bartholdi", "1872");
		
		s.add(david);
		s.add(david2);
		s.add(pieta);
		s.add(thinker);
		s.add(thinker2);
		s.add(liberty);
		
	
		
		System.out.println("Raw Contents of HashSet:");
		System.out.println(s);
		Iterator<Sculpture> iter = s.iterator();
		System.out.println("Object Details:");
		Sculpture temp; 
		while (iter.hasNext()) {
			temp = (Sculpture) iter.next();
			System.out.println("Object:");
			System.out.println("     Name: " + temp.getName());
			System.out.println("     Sculptor: " + temp.getSculptor());
			System.out.println("     Year: " + temp.getYear());
			
		}
		

	}

}
