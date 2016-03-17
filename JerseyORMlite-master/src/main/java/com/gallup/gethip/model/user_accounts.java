package com.gallup.gethip.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="user_accounts")
public class user_accounts {
	
	@DatabaseField(columnName = "UserName")
	private String UserName;
	
	@DatabaseField(columnName = "Password")
	private String Password;
	
	@DatabaseField(columnName = "Address")
	private String Address;
	
	@DatabaseField(columnName = "Salt")
	private String Salt;
	
	@DatabaseField(columnName = "RFIDNumber")
	private int RFIDNumber;
	
	//when we allow for functionality for more than one can per person we will need to create
	//an RFID lookup table
	
	@DatabaseField(columnName = "Zip")
	private int Zip;
	
	@DatabaseField(columnName = "City")
	private String City;
	
	@DatabaseField(columnName = "State")
	private String State;
	
	@DatabaseField(columnName = "PhoneNumber")
	private int PhoneNumber;
	
	@DatabaseField(columnName = "AuthorizationCode")
	private String AuthorizationCode;
	
	public user_accounts(){
		
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getSalt()
	{
		return Salt;
	}
	
	public void setSalt(String Salt)
	{
		this.Salt = Salt;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public int getRFIDNumber() {
		return RFIDNumber;
	}

	public void setRFIDNumber(int RFIDNumber) {
		this.RFIDNumber = RFIDNumber;
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

	public String getAuthorizationCode() {
		return AuthorizationCode;
	}

	public void setAuthorizationCode(String AuthorizationCode) {
		this.AuthorizationCode = AuthorizationCode;
	}

}
