package com.sapient.week2.FeeCalculator;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private LocalDate transactionDate;
	private double marketValue;
	private String priorityFlag;

	public Transaction() {

	}

	@Override
	public String toString() {
		return "Transaction [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priorityFlag=" + priorityFlag + "]";
	}

	public Transaction(String externalTransactionId, String clientId, String securityId, String transactionType,
			LocalDate transactionDate, double marketValue, String priorityFlag) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

}
