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
	
	@DatabaseField(columnName = "DailyAccounts")
	private int DailyAccounts;
	
	@DatabaseField(columnName = "MonthlyAccounts")
	private int MonthlyAccounts;
	
	@DatabaseField(columnName = "WeeklyAccounts")
	private int WeeklyAccounts;
	
	@DatabaseField(columnName = "YearlyAccounts")
	private int YearlyAccounts;
	
	@DatabaseField(columnName = "LifetimeAccounts")
	private int LifetimeAccounts;
	
	public home()
	{
		
	}
	public home(int ID, double LifetimeTotal, double YearlyTotal, double MontlyTotal, double WeeklyTotal, double DailyTotal){
		this.LifetimeTotal = LifetimeTotal;
		this.YearlyTotal = YearlyTotal;
		this.MonthlyTotal = MontlyTotal;
		this.WeeklyTotal = WeeklyTotal;
		this.DailyTotal = DailyTotal;
		this.ID = ID;
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
