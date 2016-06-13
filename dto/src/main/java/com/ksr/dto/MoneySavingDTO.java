package com.ksr.dto;

import java.sql.Timestamp;

public class MoneySavingDTO {

		private long moneySavingId;
		private String moneySavingName;
		private int moneySavingTypeId;
		private double savingAmount;
		private int savingTerms;
		private Timestamp createDate;
		
		
		public long getMoneySavingId() {
			return moneySavingId;
		}
		public void setMoneySavingId(long moneySavingId) {
			this.moneySavingId = moneySavingId;
		}
		public String getMoneySavingName() {
			return moneySavingName;
		}
		public void setMoneySavingName(String moneySavingName) {
			this.moneySavingName = moneySavingName;
		}
		public int getMoneySavingTypeId() {
			return moneySavingTypeId;
		}
		public void setMoneySavingTypeId(int moneySavingTypeId) {
			this.moneySavingTypeId = moneySavingTypeId;
		}
		public double getSavingAmount() {
			return savingAmount;
		}
		public void setSavingAmount(double savingAmount) {
			this.savingAmount = savingAmount;
		}
		public int getSavingTerms() {
			return savingTerms;
		}
		public void setSavingTerms(int savingTerms) {
			this.savingTerms = savingTerms;
		}
		public Timestamp getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Timestamp createDate) {
			this.createDate = createDate;
		}
		
		
		
}
