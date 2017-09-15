package com.sapient.programs;

public class MatrixSpiral {

	public static void main(String[] args) {

		int[][] matrix = new int[][]{{1,2},{3,4}};
		
		System.out.println(matrix.length);
		
		for(int i =0; i<matrix.length; i++) {
			for(int j=0;j<matrix.length; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println("");
		}
		
	}

}
