package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="trashcollected")
public class trashcollected {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "PickUpTime")
	private Date PickUpTime;
	
	@DatabaseField(columnName = "PickUpTimeStamp")
	private int PickUpTimeStamp;
	
	
	@DatabaseField(columnName = "Weight")
	private double Weight;
	
	@DatabaseField(columnName = "AccountNum")
	private int AccountNum;
	
	@DatabaseField(columnName = "TruckNumber")
	private int TruckNumber;
	
	@DatabaseField(columnName = "Date")
	private String date;
	
	public trashcollected(int TruckNumber, int AccountNum, double Weight, int ID, String date){
		this.ID = ID;
		this.AccountNum = AccountNum;
		this.TruckNumber = TruckNumber;
		this.Weight = Weight;
		this.date = date;
	}
	public trashcollected()
	{
		
	}
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Date getPickUpTime() {
		return PickUpTime;
	}

	public void setPickUpTime(Date PickUpTime) {
		this.PickUpTime = PickUpTime;
	}

	public int getPickUpTimeStamp() {
		return PickUpTimeStamp;
	}

	public void setPickUpTimeStamp(int PickUpTimeStamp) {
		this.PickUpTimeStamp = PickUpTimeStamp;
	}

	public int getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(int AccountNum) {
		this.AccountNum = AccountNum;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double Weight) {
		this.Weight = Weight;
	}
	
	public int getTruckNumber() {
		return TruckNumber;
	}

	public void setTruckNumber(int TruckNumber) {
		this.TruckNumber = TruckNumber;
	}

}
