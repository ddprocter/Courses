package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetPractice {

	public static void main(String[] args) {
		//TreeSet<String> movieTitles = new TreeSet(); // will remove dups, store alpha
		//HashSet<String> movieTitles = new HashSet();	 // will remove dups only
		LinkedHashSet<String> movieTitles = new LinkedHashSet(); // order in which they were entered
		movieTitles.add("Ex-terminator");
		movieTitles.add("The dark knight");
		movieTitles.add("Mission peak");
		movieTitles.add("The dark knight");
		movieTitles.add("Ex-terminator");
		movieTitles.add("The zzz Movie");
		
		
		
		Iterator<String> iter = movieTitles.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
			System.out.println(movieTitles.size() + " movies left");
		}
		
		System.out.println("Movietitles is empty now:");
		System.out.println(movieTitles.size());
		

	}

}
