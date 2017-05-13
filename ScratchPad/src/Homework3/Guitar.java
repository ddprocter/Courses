package Homework3;

public class Guitar implements Tuner {
	
	private String key;
	

	public Guitar(String key) {
		this.key = key;
	}

	public void tune(){
		System.out.println("Now tuning guitar to " + key + ".");
		
	}

	public static void main(String[] args) {
		Guitar guitar = new Guitar("EADGBE");
		guitar.tune();
		Radio radio = new Radio("95.7 The Game");
		radio.tune();

	}

}
