package JavaComprehensive;

public interface NewInterface {
	public static final float ALPHA = 5.5f;
	private float BETA = 1.2f; // private not allowed
	
	private void method1 (int i); // private not allowed
	void method2(int); // which int?  (int i) is needed
	
	public static int method3(float j);// must be abstract, or have body

	
	int method4(float k);
	public abstract method5(); // no return type specified
	
	public static int method5(float l){
		// do stuff 
		
	}
	
	
	
	
	

}
