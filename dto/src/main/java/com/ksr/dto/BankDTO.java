package com.ksr.dto;

import java.sql.Timestamp;

public class BankDTO {

	private long bankId;
	private String bankName;
	private double currentAcountBalance;
	private double currentLoanBalance;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	
	
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getCurrentAcountBalance() {
		return currentAcountBalance;
	}
	public void setCurrentAcountBalance(double currentAcountBalance) {
		this.currentAcountBalance = currentAcountBalance;
	}
	public double getCurrentLoanBalance() {
		return currentLoanBalance;
	}
	public void setCurrentLoanBalance(double currentLoanBalance) {
		this.currentLoanBalance = currentLoanBalance;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "BankDTO [bankId=" + bankId + ", bankName=" + bankName
				+ ", currentAcountBalance=" + currentAcountBalance
				+ ", currentLoanBalance=" + currentLoanBalance
				+ ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}
	
	
	
	
}
