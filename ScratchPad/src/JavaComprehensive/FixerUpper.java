package JavaComprehensive;

public class FixerUpper extends AnotherStructure {
	
	
	public FixerUpper(){
	// if a call to the super statement (constructor for parent class) is not added
	// with the signature of the default constructor of the superclass
	// we will get error:
	// Implicit super constructor AnotherStructure() is undefined for 
	// default constructor. Must define an explicit constructor
	
	super("Slab");
	System.out.println("Set up floor, walls and roof");
	
	}
	
	// or you could add parameterless constructor to parent class
	
	

}
