package homework5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Ch12p9 {

	public static void main(String[] args) {
		LinkedHashMap<String, String> capitals = new LinkedHashMap<String, String>();
		capitals.put("Netherlands","Amsterdam");
		capitals.put("Greece","Athens");
		capitals.put("Belgium","Brussels");
		capitals.put("Portugal","Lisbon");
		capitals.put("Spain","Madrid");
		capitals.put("Ireland","Dublin");
		capitals.put("Norway","Oslo");
		capitals.put("France","Paris");
		capitals.put("Hungary","Budapest");
		capitals.put("United Kingdom","London");
		
		System.out.println(capitals);
		
	}

}
