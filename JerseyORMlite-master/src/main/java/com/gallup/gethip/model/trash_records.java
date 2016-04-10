package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="trash_records")
public class trash_records {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "RFIDNumber")
	private int RFIDNumber;
	
	@DatabaseField(columnName = "UserName")
	private String UserName;
	
	@DatabaseField(columnName = "Weight")
	private double Weight;
	
	@DatabaseField(columnName = "PickedUp")
	private Date PickedUp;
	
	@DatabaseField(columnName = "TruckNumber")
	private int TruckNumber;
	
	@DatabaseField(columnName = "Date")
	private int Date;
	
	public trash_records(){
		
	}
	public trash_records(int RFIDNumber, String UserName, double Weight, Date PickedUp, int TruckNumber, int Date, int ID )
	{
		this.ID = ID;
		this.RFIDNumber = RFIDNumber;
		this.UserName = UserName;
		this.Weight = Weight;
		this.PickedUp = PickedUp;
		this.TruckNumber = TruckNumber;
		this.Date = Date;
	}
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getRFIDNumber() {
		return RFIDNumber;
	}

	public void setRFIDNumber(int RFIDNumber) {
		this.RFIDNumber = RFIDNumber;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double Weight) {
		this.Weight = Weight;
	}

	public Date getPickedUp() {
		return PickedUp;
	}

	public void setPickedUp(Date PickedUp) {
		this.PickedUp = PickedUp;
	}
	//will also need to put in a service number or create a table for each 
	//individual trash service
	public int getTruckNumber() {
		return TruckNumber;
	}

	public void setTruckNumber(int TruckNumber) {
		this.TruckNumber = TruckNumber;
	}
	
	public int getDate() {
		return Date;
	}

	public void setDate(int Date) {
		this.Date = Date;
	}

}
