package com.sapient.week2.IncomeCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncomeCalculatorApplication {

	public static void main(String[] args) {
		PersonImpl obj=new PersonImpl();
		obj.readData("input.csv");
		obj.printList();
		obj.processAndWriteToCSV("output_g.csv");
		SpringApplication.run(IncomeCalculatorApplication.class, args);
	}

}
