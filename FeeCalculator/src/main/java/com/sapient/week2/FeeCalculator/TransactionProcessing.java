package com.sapient.week2.FeeCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

public class TransactionProcessing {
	List<Transaction> transactions;

	public void readFromCSV() {
		Path pathToFile = Paths.get("Sample_Data_Fee_Calculator.csv");
		// create an instance of BufferedReader
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			// read the first line from the text file
			String line = br.readLine();
			while (line != null) {
				// use string.split to load a string array with the values from
				// each line of the
				// file
				System.out.println("Reading from file");
				String[] attributes = line.split(",");
				Transaction transaction = createTransaction(attributes);

				// adding book into ArrayList
				transactions.add(transaction);

				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Transaction createTransaction(String[] metadata) {

		String externalTransactionId = metadata[0];
		String clientId = metadata[1];
		String securityId = metadata[2];
		String transactionType = metadata[3];
		//DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
	   //         .append(DateTimeFormatter.ofPattern("[MM/dd/yyyy]" + "[MM-dd-yyyy]"));

	   // DateTimeFormatter formatter = dateTimeFormatterBuilder.toFormatter();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate transactionDate = LocalDate.parse(metadata[4], formatter);
		double marketValue = Double.parseDouble(metadata[5]);
		String priorityFlag = metadata[6];

		// create and return book of this metadata
		return new Transaction(externalTransactionId, clientId, securityId, transactionType, transactionDate,
				marketValue, priorityFlag);
	}

	public void printTransactions() {
		for (Transaction b : transactions) {
			System.out.println(b);
		}

	}
}
