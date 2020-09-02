package com.sapient.week2.IncomeCalculator;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private String country;
	private String gender;
	private double income;

	public Person() {
		super();

	}

	public Person(String country, String gender, double income) {
		super();
		this.country = country;
		this.gender = gender;
		this.income = income;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Person [country=" + country + ", gender=" + gender + ", income=" + income + "]";
	}

}
