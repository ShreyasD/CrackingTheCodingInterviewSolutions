import java.awt.List;

public class MatrixProblems {
	public static boolean rotateMatrix(int[][] matrix) {
		 if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
		 int n = matrix.length;
		 
		 for(int layer=0; layer < n/2; layer ++) {
			 int first = layer;
			 int last = n - 1 - layer;
			 for(int i=first; i < last; i++) {
				 int offset = i - first;
				 int top = matrix[first][i]; //save top
				 matrix[first][i] = matrix[last-offset][first]; //left to top
				 matrix[last-offset][first] = matrix[last][last-offset]; //bottom to left
				 matrix[last][last-offset] = matrix[i][last];//right to bottom
				 matrix[i][last] = top;//top to right
			 }
		 }
		 return true; 
	}
	
	public static void zeroMatrix(int[][] matrix) {
		Coordinate[] zeroCoords = new Coordinate[matrix.length * matrix[0].length];
		
		//Get all zero coordinates
		int coordCount = 0;
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					zeroCoords[coordCount] = new MatrixProblems.Coordinate(i, j);
					coordCount++;
				}
			}
		}
		
		//Zero rows and columns
		for(int i=0; i < coordCount; i++) {
			zeroRow(zeroCoords[i].x, matrix);
			zeroColumn(zeroCoords[i].y, matrix);
		}
	}
	
	private static void zeroRow(int x, int[][] matrix) {
		for(int i=0; i < matrix[0].length; i++) {
			matrix[x][i] = 0;
		}
	}
	
	private static void zeroColumn(int y, int[][] matrix) {
		for(int i=0; i < matrix.length; i++) {
			matrix[i][y] = 0;
		}
	}
	
	private static class Coordinate {
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
