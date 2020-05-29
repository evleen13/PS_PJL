package com.sapient.week8;


public class CalculatorRunner {
	public static void main(String[] args) {
		Calculator calc= new Add();
		int result = calc.calculate(1,2);
		System.out.println(result);
	}
}
