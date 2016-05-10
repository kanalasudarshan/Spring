package com.ksr.dto;

public class UserDTO  {
	
	private long userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isActive;
	private boolean isEmailVerified;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isEmailVerified() {
		return isEmailVerified;
	}
	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName+ ", firstName=" + firstName + ", lastName=" + lastName+ ", isActive=" + isActive + ", isEmailVerified="+ isEmailVerified + "]";
	}
	
	

}
