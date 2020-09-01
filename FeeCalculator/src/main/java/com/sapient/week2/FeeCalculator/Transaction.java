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
	private long processingFee;
	
	public Transaction() {

	}

	@Override
	public String toString() {
		return "Transaction [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priorityFlag=" + priorityFlag
				+ ", processingFee=" + processingFee + "]";
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

	public Transaction(String externalTransactionId, String clientId, String securityId, String transactionType,
			LocalDate transactionDate, double marketValue, String priorityFlag, long processingFee) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
		this.processingFee = processingFee;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public long getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(long processingFee) {
		this.processingFee = processingFee;
	}

	

}
