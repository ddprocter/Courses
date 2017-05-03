package JavaComprehensive;

public class BigBlueberryPieRecipe extends BlueberryPieRecipe {

	public static void main(String[] args) {
		BigBlueberryPieRecipe bbpr = new BigBlueberryPieRecipe();
		bbpr.getDirections();
		

	}
	//override the parent class method
	public void getDirections(){
		super.getDirections();
		System.out.println("To prepare big blueberry fillingblah blah");
	}

}
