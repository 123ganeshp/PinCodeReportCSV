package com.example.models;

public class Reports {
	private String zipCode;
	private String palceName;
	private String country;
	private String stateCode;
	private String state;
	private String city;
	
	public Reports() {
		// TODO Auto-generated constructor stub
	}

	public Reports(String zipCode, String palceName, String country, String stateCode, String state, String city) {
		super();
		this.zipCode = zipCode;
		this.palceName = palceName;
		this.country = country;
		this.stateCode = stateCode;
		this.state = state;
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPalceName() {
		return palceName;
	}

	public void setPalceName(String palceName) {
		this.palceName = palceName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Reports [zipCode=" + zipCode + ", palceName=" + palceName + ", country=" + country + ", stateCode="
				+ stateCode + ", state=" + state + ", city=" + city + "]";
	}
	
	

}
