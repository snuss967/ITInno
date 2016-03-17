package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="pick_up_days")
public class pick_up_days {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "day")
	private int day;
	
	@DatabaseField(columnName = "pickedUp")
	private short pickedUp;
	
	@DatabaseField(columnName = "AssignedPickUpDay")
	private Date AssignedPickUpDay;
	
	@DatabaseField(columnName = "UserName")
	private String UserName;
	
	public pick_up_days(){
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getday() {
		return day;
	}

	public void setday(int day) {
		this.day = day;
	}
	
	public short getpickedUp() {
		return pickedUp;
		
	}

	public void setpickedUp(short pickedUp) {
		this.pickedUp = pickedUp;
	}

	public Date getAssignedPickUpDay() {
		return AssignedPickUpDay;
	}

	public void setrecycleWeight(Date AssignedPickUpDay) {
		this.AssignedPickUpDay = AssignedPickUpDay;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}


}
