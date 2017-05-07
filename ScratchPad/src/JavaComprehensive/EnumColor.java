package JavaComprehensive;

public enum EnumColor {
	RED,
	CYAN,
	MAGENTA;


public static void main(String[] args){
	EnumColor color = CYAN;
	color = RED;
	System.out.println(color.name() + " has ordinal " + color.ordinal());;
	
	System.out.println("Get values:" + EnumColor.values()[0]);
	
	for (int i = 0; i< EnumColor.values().length; i++){
		
		System.out.println(EnumColor.values()[i]);
		
	}
	
	
	
	
}

}