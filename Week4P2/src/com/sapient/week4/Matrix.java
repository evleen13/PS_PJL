package com.sapient.week4;

import java.util.Scanner;

public class Matrix {
	private int row, col;
	private int matrix[][];

	public Matrix() {
		this.row = 3;
		this.col = 3;
		matrix = new int[3][3];
	}

	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		matrix = new int[row][col];
	}

	public Matrix(Matrix object) {
		this.row = object.row;
		this.col = object.col;
		matrix = new int[row][col];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				this.matrix[i][j] = object.matrix[i][j];
			}
		}
	}
	/*
	 * public Matrix(int[][] matrix) { this.row= matrix.length; this.col=
	 * matrix[0].length; this.matrix=new int[row][col];
	 * 
	 * }
	 */

	public void readMatrix() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				System.out.printf("Enter element [%d] [%d]: " , i ,j);
				this.matrix[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
	}

	public void displayMatrix() {
		// TODO Auto-generated method stub
		System.out.println("Matrix: ");
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] addMatrix(int[][] arr) {
		// TODO Auto-generated method stub

		int[][] result = new int[row][col];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				result[i][j] = this.matrix[i][j] + arr[i][j];
			}
		}
		return result;
	}

	public void checkScalar() {
		// TODO Auto-generated method stub
		if (row != col) {
			System.out.println("Not a scalar matrix");
			return;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((i != j) && (matrix[i][j] != 0)) {
					System.out.println("Not a scalar matrix");
					return;
				}
			}
		}
		
		for (int i = 0; i < row - 1; i++) {
			if (matrix[i][i] != matrix[i + 1][i + 1]) {
				System.out.println("Not a scalar matrix");
			}
		}		
		System.out.println("Scalar matrix");

	}

	public int[][] multiplyMatrix(int[][] arr) {
		// TODO Auto-generated method stub
		int row2=arr.length;
		int col2= arr[0].length;
		int sum=0;
		int[][] result = new int[row][col2];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col2;j++) {
				for(int k=0; k < row2;k++) {
					sum = sum + this.matrix[i][k]*arr[k][j];
				}
				result[i][j] = sum;
		        sum = 0;
			}
		}
		return result;
	}

}
