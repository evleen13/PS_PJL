package com.sapient.week2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

public class DateTimeCalculator {
	LocalDate date1, date2;

	public DateTimeCalculator(LocalDate date1, LocalDate date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}

	// Function to convert string to date
	public static LocalDate convertStringToDate(String dateString) {
		LocalDate dateTime = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			dateTime = LocalDate.parse(dateString, formatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateTime;
	}

	public LocalDate getDate1() {
		return date1;
	}

	public void setDate1(LocalDate date1) {
		this.date1 = date1;
	}

	public LocalDate getDate2() {
		return date2;
	}

	public void setDate2(LocalDate date2) {
		this.date2 = date2;
	}

	// Add two Dates
	public void addDates() {
		LocalDate date = date1;
		date = date.plusDays(date2.getDayOfMonth());
		date = date.plusMonths(date2.getMonthValue());
		date = date.plusYears(date2.getYear());
		System.out.println("Result on addition:");

		System.out.println("Date:" + date);
	}

	// Subtract two dates
	public void subtractDates() {
		LocalDate date = date1;
		date = date.minusDays(date2.getDayOfMonth());
		date = date.minusMonths(date2.getMonthValue());
		date = date.minusYears(date2.getYear());
		System.out.println("Result on subtraction:");

		System.out.println("Date:" + date);
	}

	// Add n days to given date
	public static void addDays(LocalDate date, int numberOfDays) {
		date = date.plusDays(numberOfDays);
		System.out.println("Result after adding " + numberOfDays + "days: ");
		System.out.println("Date:" + date);
	}

	// Subtract n days to given date

	public static void subtractDays(LocalDate date, int numberOfDays) {
		date = date.minusDays(numberOfDays);
		System.out.println("Result after adding " + numberOfDays + "days: ");

		System.out.println("Date:" + date);
	}

	// findDayOfTheWeek
	public static void findDayOfTheWeek(LocalDate date) {
		System.out.println("DayOfTheWeek: " + date.getDayOfWeek());
	}
	
	public static void getWeekNumber(LocalDate date) {
		WeekFields weekFields = WeekFields.ISO; 
		int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
		System.out.println("WeekNumber: "+ weekNumber);
	}
}
