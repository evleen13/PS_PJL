package com.sapient.numbers;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberRunner {
	//private int countOfNumbers;
	//ArrayList<Integer> arrayOfNumbers= new ArrayList<Integer>();
	
	/*public void setCountOfNumbers(int countOfNumbers) {
		this.countOfNumbers = countOfNumbers;
	}*/
	
	
	public static void main(String[] args) {
		if (args.length > 0) { 
            
  
            // iterating the args array and printing 
            // the command line arguments 
            ArrayList<Integer> arrayOfNumbers= new ArrayList<Integer>();
            for (String val:args) {
                //System.out.println(val); 
            	arrayOfNumbers.add(Integer.parseInt(val));
            }
            Command_Line1 object = new Command_Line1();
            object.setData(arrayOfNumbers);
            object.displayData();
            object.calData();
        } 
        else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter count of numbers: ");
			int countOfNumbers;
			ArrayList<Integer> arrayOfNumbers= new ArrayList<Integer>();
			//runner.setCountOfNumbers(scanner.nextInt());
			countOfNumbers = scanner.nextInt();
			System.out.println("Enter the numbers: ");
			for(int i = 0; i< countOfNumbers; i++) {
				arrayOfNumbers.add(scanner.nextInt());
			}
			KeyRead_Line2 object = new KeyRead_Line2(arrayOfNumbers);
			object.display();
			object.sort();
			System.out.println("Enter number that you want to find");
			int number = scanner.nextInt();
			object.find(number);
			scanner.close();
        }
	}
	
}
