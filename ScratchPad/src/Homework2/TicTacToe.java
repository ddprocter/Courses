package Homework2;

public class TicTacToe {
	
	int[][] array = new int[3][3];
	String winner = null;
	
	public TicTacToe(int[][] array){
		this.array = array;
		
	}
	
	public static void main(String[] args) {
		
		int[][] array = {
			{1,2,1},
			{1,1,0},
			{1,0,2}
		};
	
		TicTacToe ttt = new TicTacToe(array);
		ttt.checkWinner();
		
		
		
	}
	
	
	public void checkWinner(){
	
		winner = checkRows();
		
		if ( winner == null ) {
			winner = checkColumns();
		}
		
		if ( winner == null) {
			winner = checkDiagonals();	
		}

		if (winner != null) {
			System.out.println("The winner is: " + winner );
			
		} else {
		
			System.out.println("Nobody won!");
		}
		

		
	}
	
	public String checkRows(){
	
		for (int r=0; r<3; r++){
		
				if (array[r][0] == 1 && array[r][1] == 1 && array[r][2]== 1 ) {
					winner = "noghts";
				}
				else if (array[r][0] == 2 && array[r][1] == 2 && array[r][2]== 2 ) {
					winner = "crosses";
				} 
			
		}
		return winner;
		
	}
	
	
	public String checkColumns(){
		
		for (int c=0; c<3; c++){
		
				if (array[0][c] == 1 && array[1][c] == 1 && array[2][c]== 1 ) {
					winner = "noghts";
				} else if (array[0][c] == 2 && array[1][c] == 2 && array[2][c]== 2 ) 
				{
					winner = "crosses";
				} 
			
		}
		return winner;
		
	}
	
	public String checkDiagonals(){
		
		if (array[0][0] == 1 && array[1][1] == 1 && array[2][2]== 1 ) {
			winner = "noghts";
		}
		else if (array[0][0] == 2 && array[1][1] == 2 && array[2][2]== 2 ) {
			winner = "crosses";
		}
	
		else if (array[0][2] == 1 && array[1][1] == 1 && array[2][0]== 1 ) {
			winner = "noghts";
		}
		else if (array[0][2] == 2 && array[1][1] == 2 && array[2][0]== 2 ) {
			winner = "crosses";
		}

		return winner;
		
		
		
	}
	
	

}
