package Homework2;




public enum Neighbors {
	
	ME {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
				return new PointWeight(x,y, kernel[1][1]);
		}
		
	},
	
	
	NORTH {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (y<height-1) {
				return new PointWeight(x,y+1, kernel[0][1]);
			}
			else {
				return null;
			}
		}
		
	},
	SOUTH {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (y>0) {
				return new PointWeight(x,y-1, kernel[2][1]);
			} else {
				return null;
			}
		}
		
	}, 
	EAST {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (x<width-1) {	
				return new PointWeight(x+1, y, kernel[1][2]);
			}
			else {
				return null;
			}
		}
		
	},
	
	WEST {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (x>0)
				return new PointWeight(x-1, y, kernel[1][0]);
			else
				return null;
			
		}
		
	},
	NORTHWEST {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (x>0 && y<height-1) {
				return new PointWeight(x-1,y+1, kernel[0][0]);
			}
			else {
				return null;
			}
		}
		
	},
	NORTHEAST {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (x<width-1 && y<height-1) {
				return new PointWeight(x+1,y+1, kernel[0][2]);
			}
			else {
				return null;
			}
		}
		
	},
	
	SOUTHEAST {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (x<width-1 && y>0) {
				return new PointWeight(x+1,y-1, kernel[2][2]);
			}
			else {
				return null;
			}
		}
		
	},
	SOUTHWEST {
		PointWeight index(int x, int y, int width, int height, float[][] kernel){
			if (x>0 && y>0) {
				return new PointWeight(x-1,y-1, kernel[2][0] );
			}
			else {
				return null;
			}
		}
		
	};

	abstract PointWeight index(int x, int y, int width, int height, float[][] kernel);

}

