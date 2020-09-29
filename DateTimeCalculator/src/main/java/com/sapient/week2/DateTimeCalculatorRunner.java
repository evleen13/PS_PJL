package com.sapient.week2;

/*import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DateTimeCalculatorRunner {
	public static void main(String[] args) {
		SpringApplication.run(DateTimeCalculatorRunner.class, args);

		/*Scanner scanner = new Scanner(System.in);
		String dateString1;
		String dateString2;
		int choice = 0;
		LocalDate date1, date2,result;
		int numberOfDays;
		String dateString;
		LocalDate date = null;
		// Accepting dates and converting them to LocalDateTime format
		System.out.println("Welcome");*/	
		/*
		 * System.out.println("Enter Date 1 in the format yyyy-MM-dd: "); dateString1 =
		 * scanner.next();
		 * System.out.println("Enter Date 2 in the format yyyy-MM-dd: "); dateString2 =
		 * scanner.next();
		 */
		/*dateString1 = "2020-12-12";
		dateString2 = "2012-12-31";
		date1 = DateTimeCalculator.convertStringToDate(dateString1);
		System.out.println("Date 1: " + date1);
		date2 = DateTimeCalculator.convertStringToDate(dateString2);
		System.out.println("Date 2: " + date2);
		DateTimeCalculator obj = new DateTimeCalculator(date1, date2);
		do {
			System.out.println("Welcome");

			System.out.println("1. Add dates");
			System.out.println("2. Subtract dates");
			System.out.println("3. Add days to a date");
			System.out.println("4. Subtract days from a date");
			System.out.println("5.findDayOfTheWeek");
			System.out.println("6. Find Week Number");
			System.out.println("Enter Choice:");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				result=obj.addDates();
				break;
			case 2:
				result=obj.subtractDates();
				break;
			case 3:
				System.out.println("Enter Date in the format yyyy-MM-dd: ");
				dateString = scanner.next();
				date = DateTimeCalculator.convertStringToDate(dateString);
				System.out.println("Enter the number of days you want to add:");
				numberOfDays = scanner.nextInt();
				result=DateTimeCalculator.addDays(date, numberOfDays);
				break;
			case 4:
				System.out.println("Enter Date in the format yyyy-MM-dd: ");
				dateString = scanner.next();
				date = DateTimeCalculator.convertStringToDate(dateString);
				System.out.println("Enter the number of days you want to subtract:");
				numberOfDays = scanner.nextInt();
				result=DateTimeCalculator.subtractDays(date, numberOfDays);
				break;
			case 5:
				System.out.println("Enter Date in the format yyyy-MM-dd: ");
				dateString = scanner.next();
				date = DateTimeCalculator.convertStringToDate(dateString);
				DayOfWeek dayOfWeek=DateTimeCalculator.findDayOfTheWeek(date);
				break;
			case 6:
				System.out.println("Enter Date in the format yyyy-MM-dd: ");
				dateString = scanner.next();
				date = DateTimeCalculator.convertStringToDate(dateString);
				int weekNumber=DateTimeCalculator.getWeekNumber(date);
				break;

			default:
				System.out.println("Please enter a valid choice");
			}
		} while (choice != 6);
		scanner.close();*/
	}
}
