package com.sapient.numbers;

import java.util.ArrayList;
import java.util.Collections;

public class KeyRead_Line2 {
	ArrayList<Integer> arrayOfNumbers= new ArrayList<Integer>();

	public KeyRead_Line2(ArrayList<Integer> arrayOfNumbers) {
		super();
		this.arrayOfNumbers = arrayOfNumbers;
	}
	public void display() {
		for(int number : arrayOfNumbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
	public void sort() {
		System.out.println("After sorting: ");
		Collections.sort(arrayOfNumbers);
		display();
	}
	public void find(int number) {
		boolean ans = arrayOfNumbers.contains(number); 
		  
        if (ans) 
            System.out.println("The list contains " + number ); 
        else
            System.out.println("The list does not contains " + number); 
	}
}
