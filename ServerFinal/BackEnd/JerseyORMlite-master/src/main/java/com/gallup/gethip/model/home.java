package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="home")
public class home {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "LifetimeTotal")
	private double LifetimeTotal;
	
	@DatabaseField(columnName = "YearlyTotal")
	private double YearlyTotal;
	
	@DatabaseField(columnName = "MonthlyTotal")
	private double MonthlyTotal;
	
	@DatabaseField(columnName = "WeeklyTotal")
	private double WeeklyTotal;
	
	@DatabaseField(columnName = "DailyTotal")
	private double DailyTotal;
	
	
	public home(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public double getLifetimeTotal() {
		return LifetimeTotal;
	}

	public void setLifetimeTotal(double LifetimeTotal) {
		this.LifetimeTotal = LifetimeTotal;
	}
	
	public double getYearlyTotal() {
		return YearlyTotal;
	}

	public void setYearlyTotal(double YearlyTotal) {
		this.YearlyTotal = YearlyTotal;
	}
	
	public double getWeeklyTotal() {
		return WeeklyTotal;
	}

	public void setWeeklyTotal(double WeeklyTotal) {
		this.WeeklyTotal = WeeklyTotal;
	}
	
	public double getDailyTotal() {
		return DailyTotal;
	}

	public void setDailyTotal(double DailyTotal) {
		this.DailyTotal = DailyTotal;
	}
	

}
