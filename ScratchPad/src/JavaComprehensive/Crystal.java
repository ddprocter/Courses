package JavaComprehensive;

import java.awt.Point;
import java.util.ArrayList;

public class Crystal {
	
	private static int[][] grid; // a specific crystal grid, not player grid
	private static int width, height; //w and h of the crystal grid only
	private static int turn;
	private static int numberOfAtoms;
	private static final int SPACE = 4;
	
	
	public static boolean isSymetrical(){
		boolean horizontalSym, verticalSym, diagonal1Sym, diagonal2Sym;
		
		for(int row = 0; row <= height; row++) {
			for(int column = 0; column <=width; column++){
				horizontalSym = (grid[row][column] == grid[height - row][column]);
				verticalSym = (grid[row][column] == grid[row][width-column]);
				diagonal1Sym = (grid[row][column] == grid[column][row]);
				diagonal2Sym = (grid[row][column] == grid[width-column][height - row]);
			
				
				// check for false and exit before next iteration if false
				if (!horizontalSym || !verticalSym || !diagonal1Sym || !diagonal2Sym){
					return false;
				}
					
			}
		}
		
		// if we got here, its been confirmed symetrical on each dimension
		return true;
		
	} //isSymetrical
	
	
	public static boolean isHoley(){
		ArrayList<Point> spacesArray = new ArrayList<Point>();
		
		// work our way around the edge, inward, checking for spaces 
		for(int row = 0; row <= height; row++){
			for (int column = 0; column<= width; column++) {
				if (row==0 || row == height || column == 0 || column == width){
					if (grid[row][column] != turn) {
						grid[row][column] = SPACE;
						spacesArray.add(new Point(row, column));
						
					}
				}
					
			}
		}
		
		// find all spaces adjacent to the spaces found above, keep working in
		while (!spacesArray.isEmpty()) {
			Point neighbor;
			Point p = (Point) spacesArray.remove(0); // pulls the first off the array
			// then, 1 becomes 0 (confirm) - not sure why
			
			// get the row and col of point p
			int row = (int) p.getX();
			int column = (int) p.getY();
			
			for (Direction dir : Direction.values()) {
				if (  (neighbor = dir.index(row, column) ) != null ) {
					addSpace((int) neighbor.getX(), (int) neighbor.getX(), spacesArray);
				}
				
			}
			
		} // while (spaces array is not empty) 
		// at this point, all external Spaces have been found and tagged as 2
		
		// any cell that is not an atom or a space is a hole now
		for (int row =0; row<=height; row++){
			for (int column = 0; column <= width; column++ ) {
				if (grid[row][column] != turn && grid[row][column] != SPACE) {
					return true; // found a hole
				}
			}
		}
		return false; // no holes found
		
	} //isHoley

	private static void addSpace(int row, int column, ArrayList<Point> spacesArray) {
		if (grid[row][column] != turn && grid[row][column] != SPACE ){
			grid[row][column] = SPACE;
			spacesArray.add(new Point(row,column));
		}
		
	}//addspace
	
	public static boolean isPerfect(int[][] crystalGrid, int w, int h, int player) {
		grid = crystalGrid;
		width = w; // width of the crystal only?
		height = h; // height of the crystal only?
		turn = player;
		
		
		// check if square, otherwise, cannot be perfect
		if(width != height || getNumberOfAtoms()<4 || !isSymetrical() || isHoley() ) {
			return false;
		}
		
		return true;
		
	}//isPerfect
	
	public static int getNumberOfAtoms() {
		for(int row=0; row<= width; row++ ) { // width, since we know height==width at this point
			for (int column = 0; column<=width; column++){
				if (grid[row][column] == turn) {
					numberOfAtoms++;
				}
			}
		}
		return numberOfAtoms;
	}//getno of atoms

}
