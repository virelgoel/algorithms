/*
 * Print a 2d array spirally
 */
public class PrintSpiralArray {

	public static void main(String[] args) {
		int rows = 5;
		int cols = 5;

		int[][] x = new int[][]{{1, 2, 3, 4, 5}, 
								{6, 7, 8, 9, 10},
								{11,12,13,14,15}, 
								{16,17,18,19,20}, 
								{21,22,23,24,25}};

		printSpiralArray(x, rows, cols);
	}

	private static void printSpiralArray(int[][] x, int rows, int cols) {
		int topRow = 0, bottomRow = rows-1, leftCol = 0, rightCol = cols-1;
		int dir = 0;
		
		while (topRow <= bottomRow && leftCol <= rightCol) {
			if (dir == 0) {
				for (int i = leftCol; i <= rightCol; i++) {
					System.out.print(x[topRow][i] + " ");
				}
				topRow++;
			}
			else if (dir == 1) {
				for (int i = topRow; i <= bottomRow; i++) {
					System.out.print(x[i][rightCol] + " ");
				}
				rightCol--;
			}
			else if (dir == 2) {
				for (int i = rightCol; i >= leftCol; i--) {
					System.out.print (x[bottomRow][i] + " ");
				}
				bottomRow--;
			}
			else {
				for (int i = bottomRow; i >= topRow; i--) {
					System.out.print (x[i][leftCol] + " ");
				}
				leftCol++;
			}
			
			System.out.println();
			dir = (dir + 1) % 4;
		}
	}
}
