package com.test.programs;

public class SpiralMatrix {
	
	
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
				     { 7, 8, 9, 10, 11, 12 }, 
				     { 13, 14, 15, 16, 17, 18 } };

		spiralPrint(3, 6, a);
	}

	private static void spiralPrint(int rows, int cols, int[][] a) {

		int startRow = 0;
		int startCol = 0;
		int endRow = rows;
		int endCol = cols;
		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index i - iterator
		 */
		while (startRow < endRow && startCol < endCol) {
			// printing first row
			for (int i = 0; i < endCol; i++) {
				System.out.print(" " + a[startCol][i]);
			}
			startRow++;

			// printing last column
			for (int i = startRow; i < endRow; i++) {
				System.out.print(" " + a[i][endCol - 1]);
			}
			endCol--;

			/* Print the last row from the remaining rows */
			if (startRow < endRow) {
				for (int i = endCol - 1; i >= startCol; --i) {
					System.out.print(" " + a[endRow - 1][i]);
				}
				endRow--;
			}

			/* Print the first column from the remaining columns */
			if (startCol < endCol) {
				for (int i = endRow - 1; i >= startRow; --i) {
					System.out.print(" " + a[i][startCol]);
				}
				startCol++;
			}

		}

	}

}
