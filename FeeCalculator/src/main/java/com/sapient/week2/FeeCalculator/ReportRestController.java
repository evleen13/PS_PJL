package com.sapient.week2.FeeCalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {
	@Autowired
	TransactionProcessing service;
	
	@GetMapping(path = "/report-unsorted")
	public List<Transaction> getUnsortedReport() {
		service.readFromCSV();
		service.processTransactions();
		List<Transaction> transactions= service.getTransactions();
		return transactions;
	}
}
