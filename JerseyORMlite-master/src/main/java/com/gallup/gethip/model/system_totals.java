package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="system_totals")
public class system_totals {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "Day")
	private double Day;
	
	@DatabaseField(columnName = "Week")
	private double Week;
	
	@DatabaseField(columnName = "Month")
	private double Month;
	
	@DatabaseField(columnName = "Year")
	private double Year;
	
	@DatabaseField(columnName = "Lifetime")
	private double Lifetime;
	
	@DatabaseField(columnName = "Date")
	private Date Date;
	
	@DatabaseField(columnName = "DateInt")
	private int DateInt;
	
	public system_totals(double Day, double Week, double Month, double Year, double Lifetime, Date Date, int DateInt, int ID)
	{
		this.Date = Date;
		this.DateInt = DateInt;
		this.Day = Day;
		this.Lifetime = Lifetime;
		this.Month = Month;
		this.Week = Week;
		this.Year = Year;
		this.ID = ID;
	}
	public system_totals(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public double getDay() {
		return Day;
	}

	public void setDay(double Day) {
		this.Day = Day;
	}

	public double getWeek() {
		return Week;
	}

	public void setWeek(double Week) {
		this.Week = Week;
	}

	public double getMonth() {
		return Month;
	}

	public void setMonth(double Month) {
		this.Month = Month;
	}

	public double getYear() {
		return Year;
	}

	public void setYear(double Year) {
		this.Year = Year;
	}

	public double getLifetime() {
		return Lifetime;
	}

	public void setLifetime(double Lifetime) {
		this.Lifetime = Lifetime;
	}
	
	public Date getDate() {
		return Date;
	}

	public void setDate(Date Date) {
		this.Date = Date;
	}

	public int getDateInt() {
		return DateInt;
	}

	public void setDateInt(int DateInt) {
		this.DateInt = DateInt;
	}

}
