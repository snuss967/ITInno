package com.gallup.gethip.model;

public class returnable_user_accounts {
	
	public returnable_user_accounts(String UserName, String Address, int Zip, String City, String State, int PhoneNumber){
		this.UserName = UserName;
		this.Address = Address;
		this.Zip = Zip;
		this.City = City;
		this.State = State;
		this.PhoneNumber = PhoneNumber;
		
	}
	String UserName;
	String Address;
	int Zip;
	int PhoneNumber;
	String City;
	String State;
	
	public String getUserName() {
		return UserName;
	}
	//UserName is unable to be changed
	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public int getZip() {
		return Zip;
	}

	public void setZip(int Zip) {
		this.Zip = Zip;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}
	
	public String getState() {
		return State;
	}

	public void setState(String State) {
		this.State = State;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

}
