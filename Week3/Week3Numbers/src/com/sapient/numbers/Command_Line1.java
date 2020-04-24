package com.sapient.numbers;

import java.util.ArrayList;
import java.util.Collections;

public class Command_Line1 {
	ArrayList<Integer> arrayOfNumbers= new ArrayList<Integer>();

	/*public Command_Line1(ArrayList<Integer> arrayOfNumbers) {
		super();
		this.arrayOfNumbers = arrayOfNumbers;
	}*/
	public void setData(ArrayList<Integer> arrayOfNumbers){
		this.arrayOfNumbers = arrayOfNumbers;
	}
	public void calData() {
		int sum=0;
		for(int number : arrayOfNumbers) {
			sum += number;
		}
		System.out.println("Sum= " + sum);
		System.out.println("Average= " + sum/arrayOfNumbers.size());
		Collections.sort(arrayOfNumbers);
		System.out.println("Min= " + arrayOfNumbers.get(0));
		System.out.println("Max= " + arrayOfNumbers.get(arrayOfNumbers.size() - 1));
	}
	public void displayData() {
		for(int number : arrayOfNumbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}
