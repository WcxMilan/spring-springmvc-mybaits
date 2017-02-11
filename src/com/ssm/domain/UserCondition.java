package com.ssm.domain;

public class UserCondition {
	private String userName;
	private String address;
	private int minAge;
	private int maxAge;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public UserCondition(String userName, String address, int minAge, int maxAge) {
		super();
		this.userName = userName;
		this.address = address;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	public UserCondition() {
		super();
	}
	
	
}
