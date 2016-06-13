package com.ksr.dto;

import java.sql.Timestamp;

public class BankTransactionDTO {
	
	private long bankTrasactionId;
	private long bankId;
	private double trasactionAmount;
	private Timestamp processedDate;
	private long userId;
	
	
	public long getBankTrasactionId() {
		return bankTrasactionId;
	}
	public void setBankTrasactionId(long bankTrasactionId) {
		this.bankTrasactionId = bankTrasactionId;
	}
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public double getTrasactionAmount() {
		return trasactionAmount;
	}
	public void setTrasactionAmount(double trasactionAmount) {
		this.trasactionAmount = trasactionAmount;
	}
	public Timestamp getProcessedDate() {
		return processedDate;
	}
	public void setProcessedDate(Timestamp processedDate) {
		this.processedDate = processedDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
