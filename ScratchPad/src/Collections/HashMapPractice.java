package Collections;

import java.util.HashMap;

public class HashMapPractice {
	
	public static void main(String[] args){
	
		HashMap<String, String> treasureMap = new HashMap<String, String>();
		treasureMap.put("Gold Mine","1 degrees N, 5 degrees E");
		treasureMap.put("Treasure", "Cross the river, volcano and mine");
		treasureMap.put("Fiery Volcano", "2 degress N 15 degrees E");
		treasureMap.put("Murky River", "1 degress 10 minutes North, 15 degrees E");
		
		System.out.println(treasureMap.get("Gold Mine"));
		System.out.println(treasureMap.get("Some Key that does not exist"));
		
		System.out.println(treasureMap.keySet()); // all the keys 
		System.out.println(treasureMap.values()); // all the values 
		System.out.println(treasureMap.entrySet());
		System.out.println(treasureMap.size());
		
		
		
		
		
	}
	
	
	

}
