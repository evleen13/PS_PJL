package com.sapient.week4;

import java.util.Arrays;
import java.util.Scanner;

public class IntArrProcess {
	private int size;
	private int[] numArray;

	public IntArrProcess() {
		this.size = 10;
		numArray = new int[size];
	}

	public IntArrProcess(int size) {
		this.size = size;
		numArray = new int[size];
	}

	public IntArrProcess(int[] arr) {
		this.size = arr.length;
		numArray = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			this.numArray[i] = arr[i];
		}
	}

	public IntArrProcess(IntArrProcess object) {
		this.size = object.size;
		numArray = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			this.numArray[i] = object.numArray[i];
		}
	}

	private void secondBiggest() {
		// TODO Auto-generated method stub
		System.out.println("Second biggest: " + numArray[size - 2]);
	}
	
	private void printSum() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int element : numArray) {
			sum += element;
		}
		System.out.println("Sum: " + sum);
	}

	private void printLargestSmallestNumber() {
		// TODO Auto-generated method stub
		System.out.println("Smallest element: " + numArray[0]);
		System.out.println("Largest element: " + numArray[size - 1]);
	}

	private void sortArray() {
		// TODO Auto-generated method stub
		Arrays.sort(numArray);
		System.out.printf("Sorted array: %s", Arrays.toString(numArray));
		System.out.println();
	}

	private void displayArray() {
		// TODO Auto-generated method stub
		System.out.print("Elements are: ");
		for (int element : numArray) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	private void readArray() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			numArray[i] = scanner.nextInt();
		}
		System.out.println();
		scanner.close();
	}

	public static void main(String[] args) {

		IntArrProcess object = new IntArrProcess(4);
		object.readArray();
		object.displayArray();
		object.sortArray();
		object.printLargestSmallestNumber();
		object.printSum();
		object.secondBiggest();
	}

}
