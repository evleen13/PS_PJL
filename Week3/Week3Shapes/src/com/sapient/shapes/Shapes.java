package com.sapient.shapes;

import java.util.Scanner;

public class Shapes {
	private int numberOfSides;
	private int sideLength;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shapes newShape = new Shapes(numberOfSides, sideLength);
		
		Shapes newShape = new Shapes();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number of Sides: ");
		newShape.setNumberOfSides(scanner.nextInt());
		System.out.print("Enter length of side: ");
		newShape.setSideLength(scanner.nextInt());
		newShape.calculateShapeArea();
		scanner.close();
		
	}
	private void calculateShapeArea() {
		// TODO Auto-generated method stub
		if(numberOfSides == 1) {
			//circle
			
			Circle.calculateArea(sideLength);
		}
		else if(numberOfSides == 3) {
			//triangle
			Triangle.calculateArea(sideLength);
		}
		else if(numberOfSides == 4) {
			//square
			Square.calculateArea(sideLength);
		}
		else {
			System.out.println("No Shapes Present");
		}
	}
	public int getNumberOfSides() {
		return numberOfSides;
	}
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	public int getSideLength() {
		return sideLength;
	}
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
	

}
