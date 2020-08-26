package com.sapient.calculator.calculator;

import org.springframework.stereotype.Component;

@Component
public class CalculatorDao {
	double number1, number2;
	private String operation;

	public CalculatorDao() {

	}

	public CalculatorDao(double number1, double number2, String operation) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}

	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double add(double number1, double number2) {
		return number1 + number2;
	}

	public double subtract(double number1, double number2) {
		return number1 - number2;
	}

	public double multiply(double number1, double number2) {
		return number1 * number2;
	}

	public double divide(double number1, double number2) {
		try {
			return number1 / number2;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Divide by zero");
		}
		return 0;
	}
}
