package JavaComprehensive;

public class BlueberryPieRecipe extends PieRecipe {

	public static void main(String[] args) {
		BlueberryPieRecipe bbpr = new BlueberryPieRecipe();
		bbpr.getDirections();
		

	}
	//override the parent class method
	public void getDirections(){
		super.getDirections();
		System.out.println("To prepare blueberry fillingblah blah");
	}

}
