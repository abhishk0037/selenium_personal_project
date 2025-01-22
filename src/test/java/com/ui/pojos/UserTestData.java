package com.ui.pojos;

public class UserTestData {
	private String emailAddress;
	private String password;
	
	
	public UserTestData(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	

}
