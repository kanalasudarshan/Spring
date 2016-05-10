package com.ksr.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO  {
	
	private long userId;
	@NotEmpty
	@Size(min =10, max = 30)
	private String userName;
	@NotEmpty
	private String password;
	@NotEmpty
	@Size(min =5, max = 50)
	private String firstName;
	@Size(max = 50)
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
		return "UserDTO [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", isActive=" + isActive
				+ ", isEmailVerified=" + isEmailVerified + "]";
	}
	
	

}
