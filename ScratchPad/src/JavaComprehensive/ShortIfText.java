package JavaComprehensive;

public class ShortIfText {
	
	
	
	

	public static void main(String[] args) {
		
		boolean name = true;
		String nameString =  (name== true ? "John Smith\n" : "");
		System.out.println(nameString);
		boolean address = false; 
		String textString= "StartString"; 
		
		textString = textString.concat(nameString);
		
		System.out.println(textString);
				
		
	}

}
