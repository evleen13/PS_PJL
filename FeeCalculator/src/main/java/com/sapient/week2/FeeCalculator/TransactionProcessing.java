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
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class TransactionProcessing {
	List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public TransactionProcessing() {
		this.transactions = new ArrayList<Transaction>();
	}

	public void readFromCSV() {
		Path pathToFile = Paths.get("Sample_Data_Fee_Calculator.csv");
		// create an instance of BufferedReader
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			// read the first line from the text file
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				// use string.split to load a string array with the values from
				// each line of the
				// file
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
		DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
				.append(DateTimeFormatter.ofPattern("[MM/dd/yyyy]" + "[MM-dd-yyyy]"));

		DateTimeFormatter formatter = dateTimeFormatterBuilder.toFormatter();
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
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

	public void processTransactions() {
		// Normal transaction
		processNormalTransaction();
		// Intra day tx
		processIntraDayTransaction();
	}

	private void processIntraDayTransaction() {
		
		for(int i=0;i<transactions.size();i++) {
			String clientId1=transactions.get(i).getClientId();
			
			String securityId1 =transactions.get(i).getSecurityId();
			LocalDate transactionDate1 =transactions.get(i).getTransactionDate();
			String transactionType1 = transactions.get(i).getTransactionType();
			for(int j=i+1;j<transactions.size();j++) {
				String clientId2=transactions.get(j).getClientId();
				String securityId2 =transactions.get(j).getSecurityId();
				LocalDate transactionDate2 =transactions.get(j).getTransactionDate();
				String transactionType2 = transactions.get(j).getTransactionType();
				if(clientId1.equals(clientId2) && securityId1.equals(securityId2) && transactionDate1.equals(transactionDate2)) {
					System.out.println("Intraday2");
					if(transactionType1.equals("BUY") && transactionType2.equals("SELL") || transactionType1.equals("SELL") && transactionType2.equals("BUY")) {
						long fee1=transactions.get(i).getProcessingFee();
						long fee2=transactions.get(j).getProcessingFee();
						transactions.get(i).setProcessingFee(fee1+10);
						transactions.get(j).setProcessingFee(fee2+10);
					}
					if(transactionType1.equals("DEPOSIT") && transactionType2.equals("WITHDRAW") || transactionType1.equals("DEPOSIT") && transactionType2.equals("WITHDRAW")) {
						long fee1=transactions.get(i).getProcessingFee();
						long fee2=transactions.get(j).getProcessingFee();
						transactions.get(i).setProcessingFee(fee1+10);
						transactions.get(j).setProcessingFee(fee2+10);
					}
				}
			}
		}
	}

	private void processNormalTransaction() {
		long fee;
		for (Transaction tx : transactions) {

			// for high priority tx charge $500
			if (tx.getPriorityFlag().equals("Y")) {
				fee = tx.getProcessingFee();
				tx.setProcessingFee(fee + 500);
			} else if (tx.getPriorityFlag().equals("N")) {
				String type = tx.getTransactionType();
				if (type.equals("SELL") || type.equals("WITHDRAW")) {
					fee = tx.getProcessingFee();
					tx.setProcessingFee(fee + 100);
				}
				if (type.equals("BUY") || type.equals("DEPOSIT")) {
					fee = tx.getProcessingFee();
					tx.setProcessingFee(fee + 50);
				}
			}
		}
	}
}
