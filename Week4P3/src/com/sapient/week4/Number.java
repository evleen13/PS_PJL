package com.sapient.week4;

import java.util.Scanner;

public class Number {
	private static int num1;
	private static int num2;
	private int choice;
	private int operate(int a, int b, NumProcess fobj) 
    { 
        return fobj.cal(a, b); 
    } 
	private void readData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number 1: ");
		num1= scanner.nextInt();
		System.out.println("Enter number 2: ");
		num2= scanner.nextInt();
		System.out.println("Enter choice: ");
		choice = scanner.nextInt();
		scanner.close();
	}
	public static void main(String[] args) {
		NumProcess add = (int x , int y) -> x+y;
		NumProcess subtract = (int x , int y) -> x-y;
		NumProcess multiply = (int x , int y) -> x*y;
		NumProcess divide = (int x , int y) -> x/y;
		Number number = new Number();
		number.readData();
		System.out.println("Addition is:" + number.operate(num1, num2, add));
		System.out.println("subtraction is:" + number.operate(num1, num2, subtract));
		System.out.println("multiplication is:" + number.operate(num1, num2, multiply));
		System.out.println("division is:" + number.operate(num1, num2, divide));
	}
	
}
