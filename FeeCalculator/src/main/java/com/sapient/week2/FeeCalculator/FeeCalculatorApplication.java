package com.sapient.week2.FeeCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeeCalculatorApplication {
	
	public static void main(String[] args) {
		TransactionProcessing obj= new TransactionProcessing();
		obj.readFromCSV();
		obj.printTransactions();
		SpringApplication.run(FeeCalculatorApplication.class, args);
	}

}
