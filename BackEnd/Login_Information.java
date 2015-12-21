package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="employees")
public class Login_Information {

	@DatabaseField(generatedId = true, columnName = "UserID")
	private int UserID;
	
	@DatabaseField(columnName = "password")
	private String password;
	
	@DatabaseField(columnName = "UserName")
	private String UserName;
	
	@DatabaseField(columnName = "SecurityQuestion1")
	private String SecurityQuestion1;
	
	@DatabaseField(columnName = "SecurityQuestion2")
	private String SecurityQuestion2;
	
	@DatabaseField(columnName = "SecurityQuestion3")
	private String SecurityQuestion3;
	
	@DatabaseField(columnName = "SecurityAnswer1")
	private String SecurityAnswer1;
	
	@DatabaseField(columnName = "SecurityAnswer2")
	private String SecurityAnswer2;
	
	@DatabaseField (columnName = "SecurityAnswer3")
	private String SecurityAnswer3;
	
	@DatabaseField (columnName = "IPAddressOfLastLogOn")
	private String IPAddressOfLastLogOn;
	
	@DatabaseField (columnName = "RegistrationDate")
	private Date RegistrationDate;
	
	@DatabaseField(columnName = "Active")
	private int Active;
	
	@DatabaseField(columnName = "Address")
	private String Address;
	@DatabaseField (columnName = "EmailAddress")
	private String EmailAddress;
	@DatabaseField (columnName = "Zip")
	private int Zip;
	
	@DatabaseField (columnName = "City")
	private String City;
	
	@DatabaseField (columnName = "State")
	private String State;
	
	public Login_Information(){
		
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int UserID) {
		this.UserID = UserID;
	}

	public String UserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getSecurityQuestion1() {
		return SecurityQuestion1;
	}

	public void setSecurityQuestion1(String SecurityQuestion1) {
		this.SecurityQuestion1 = SecurityQuestion1;
	}

	public String getSecurityQuestion2() {
		return SecurityQuestion2;
	}

	public void setSecurityQuestion2(String SecurityQuestion1) {
		this.SecurityQuestion2 = SecurityQuestion2;
	}

	public String getSecurityQuestion3() {
		return SecurityQuestion3;
	}

	public void setSecurityQuestion3(String SecurityQuestion3) {
		this.SecurityQuestion3 = SecurityQuestion3;
	}

	public String getSecurityAnswer1() {
		return SecurityAnswer1;
	}

	public void setSecurityAnswer1(String SecurityAnswer1) {
		this.SecurityAnswer1 = SecurityAnswer1;
	}
	
	public String getSecurityAnswer2()
	{
		return SecurityAnswer2;
	}
	
	public void setSecurityAnswer2(String SecurityAnswer2){
		this.SecurityAnswer2 = SecurityAnswer2; }
	
	public String getSecurityAnswer3(){
		return SecurityAnswer3;
	}
	
	public void setSecurityAnswer3(String SecurityAnswer3)
	{
		this.SecurityAnswer3 = SecurityAnswer3;
	}
	
	public String getIPAddressOfLastLogOn()
	{
		return IPAddressOfLastLogOn;
	}
	
	public void setIPAddressOfLastLogOn(String IPAddressOfLastLogOn)
	{
		this.IPAddressOfLastLogOn = IPAddressOfLastLogOn;
	}
	
	public Date getRegistrationDate()
	{
		return RegistrationDate;
	}
	
	public void setRegistrationDate(Date RegistrationDate)
	{
		this.RegistrationDate = RegistrationDate;
	}
	
	public String getEmailAddress()
	{
		return EmailAddress;
	}
	
	public void setEmailAddress(String EmailAddress)
	{
		this.EmailAddress = EmailAddress;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public void setAddress(String Address)
	{
		this.Address = Address;
	}
	
	public int getZip()
	{
		return Zip;
	}
	
	public String getState()
	{
		return State;
	}
	
	public void setState(String State)
	{
		this.State = State;
	}
	
	public String getCity()
	{
		return City;
	}
	
	public void setCity(String City)
	{
		this.City = City;
	}
	
	public void setPassword (String Password)
	{
		this.password = Password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public boolean getActive()
	{
		if(Active == 0)
			return true;
		else
			return false;
	}
	
	public void setActive(boolean active)
	{
		if(active == false)
			Active = 0;
		else
			Active = 1;
	}
}
