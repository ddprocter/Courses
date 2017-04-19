package JavaComprehensive;

public class dashLine {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void dashedLine (int i) { 
		int j;
		String s = "";
		if (i<=0) { 
			return;
		}
		else {
			for (j = 0; j<i; j++) { 
				s = s+ "-";
			}
			System.out.print(s + "\n");
		}
		return;
							   
	}

}
