package com.sapient.week2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;

import org.springframework.stereotype.Service;

@Service
public class DateTimeCalculator {
	String date1, date2;
	String operation, data;

	public DateTimeCalculator() {

	}

	public DateTimeCalculator(String date1, String date2, String data, String operation) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.operation = operation;
		this.data = data;
	}

	public DateTimeCalculator(String date1, String date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	// Function to convert string to LocalDate
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

	// Add two Dates
	public LocalDate addDates() {
		LocalDate ld1, ld2, result;
		ld1 = convertStringToDate(date1);
		ld2 = convertStringToDate(date2);
		result = ld1;
		result = result.plusDays(ld2.getDayOfMonth());
		result = result.plusMonths(ld2.getMonthValue());
		result = result.plusYears(ld2.getYear());
		System.out.println("Result on addition:");

		System.out.println("Date:" + result);
		return result;
	}

	// Subtract two dates (find no of days between two dates)
	public String subtractDates() {
		LocalDate ld1, ld2;
		ld1 = convertStringToDate(date1);
		ld2 = convertStringToDate(date2);

		long noOfDaysBetween = Math.abs(ChronoUnit.DAYS.between(ld1, ld2));
		System.out.println("Result on subtraction:");
		String result = noOfDaysBetween + " day(s)";
		System.out.println(result);
		return result;
	}

	// Add n days to given date
	public static LocalDate addDays(String dateString, int numberOfDays) {
		LocalDate date = convertStringToDate(dateString);
		date = date.plusDays(numberOfDays);
		System.out.println("Result after adding " + numberOfDays + " days: ");
		System.out.println("Date:" + date);
		return date;
	}

	// Subtract n days to given date
	public static LocalDate subtractDays(String dateString, int numberOfDays) {
		LocalDate date = convertStringToDate(dateString);
		date = date.minusDays(numberOfDays);
		System.out.println("Result after subtracting " + numberOfDays + " days: ");
		System.out.println("Date:" + date);
		return date;
	}

	// findDayOfTheWeek
	public static DayOfWeek findDayOfTheWeek(String dateString) {
		LocalDate date = convertStringToDate(dateString);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println("DayOfTheWeek: " + date.getDayOfWeek());
		return dayOfWeek;
	}

	// get week number
	public static int getWeekNumber(String dateString) {
		LocalDate date = convertStringToDate(dateString);
		WeekFields weekFields = WeekFields.ISO;
		int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
		System.out.println("WeekNumber: " + weekNumber);
		return weekNumber;
	}

	// check leap year
	public static String checkLeap(String dateString) {
		LocalDate date = convertStringToDate(dateString);
		boolean leapYear = date.isLeapYear();
		String result="";
		if(leapYear==true)
			result=dateString + " is a leap year";
		else
			result=dateString + " is not a leap year";
		return result;
	}
}
