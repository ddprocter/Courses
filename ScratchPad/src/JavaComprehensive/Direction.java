package JavaComprehensive;

import java.awt.Point;

public enum Direction {
	NORTH {
		Point index(int r, int c){
			if (r>0) {
				return new Point(r-1,c);
			}
			else {
				return null;
			}
		}
		
	},
	SOUTH {
		Point index(int r, int c){
			if (r< Crystals.HEIGHT -1) {
				return new Point(r+1, c);
			} else {
				return null;
			}
		}
		
	}, 
	EAST {
		Point index(int r, int c){
			if (c< Crystals.WIDTH - 1) {	
				return new Point(r, c+1);
			}
			else {
				return null;
			}
		}
		
	},
	
	WEST {
		Point index(int r, int c){
			if (c>0)
				return new Point(r, c-1);
			else
				return null;
			
		}
		
	};

	abstract Point index(int r, int c);

}
