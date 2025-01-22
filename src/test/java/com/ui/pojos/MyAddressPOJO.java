package com.ui.pojos;

import java.util.List;

public class MyAddressPOJO {
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zip;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String additionalInformation;
	private String addressAlias;
	private String state;
	
	public MyAddressPOJO(String company, String addressLine1, String addressLine2, String city, String zip,
			String homePhoneNumber, String mobilePhoneNumber, String additionalInformation, String addressAlias,
			String state) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zip = zip;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.additionalInformation = additionalInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	public String getState() {
		return state;
	}
	
	@Override
	public String toString() {
		return "MyAddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", zip=" + zip + ", homePhoneNumber=" + homePhoneNumber + ", mobilePhoneNumber="
				+ mobilePhoneNumber + ", additionalInformation=" + additionalInformation + ", addressAlias="
				+ addressAlias + ", state=" + state + "]";

}}
