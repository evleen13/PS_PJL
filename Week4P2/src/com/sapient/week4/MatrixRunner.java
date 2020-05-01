package com.sapient.week4;

public class MatrixRunner {
	public static void main(String[] args) {
		System.out.println("Main");
		Matrix object= new Matrix(2,2);
		object.readMatrix();
		object.displayMatrix();
		int[][] arr = { { 1, 2 }, { 3, 4 } }; 
		int [][] additionResult=object.addMatrix(arr);
		System.out.println("After Addition: ");
		displayMatrix(additionResult);
		object.checkScalar();
		int [][] multiplicationResult= object.multiplyMatrix(arr);
		System.out.println("After Multiplication: ");
		displayMatrix(multiplicationResult);
	}

	private static void displayMatrix(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}System.out.println();
		}
	}
}
