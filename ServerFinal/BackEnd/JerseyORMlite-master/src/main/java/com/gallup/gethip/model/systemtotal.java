package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="systemtotal")
public class systemtotal {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "LifetimeTrashTotal")
	private double LifetimeTrashTotal;
	
	@DatabaseField(columnName = "YearlyTrashTotal")
	private double YearlyTrashTotal;
	
	@DatabaseField(columnName = "WeeklyTrashTotal")
	private double WeeklyTrashTotal;
	
	@DatabaseField(columnName = "MonthlyTrashTotal")
	private double MonthlyTrashTotal;
	
	@DatabaseField(columnName = "DailyTrashTotal")
	private double DailyTrashTotal;
	
	@DatabaseField(columnName = "WeeklyAccounts")
	private int WeeklyAccounts;
	
	@DatabaseField(columnName = "YearlyAccounts")
	private int YearlyAccounts;
	
	@DatabaseField(columnName = "MonthlyAccounts")
	private int MonthlyAccounts;
	
	@DatabaseField(columnName = "DailyAccounts")
	private int DailyAccounts;
	
	@DatabaseField(columnName = "LifetimeAccounts")
	private int LifetimeAccounts;
	
	public systemtotal(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public double getLifetimeTrashTotal() {
		return LifetimeTrashTotal;
	}

	public void setLifetimeTrashTotal(double LifetimeTrashTotal) {
		this.LifetimeTrashTotal = LifetimeTrashTotal;
	}

	public double getYearlyTrashTotal() {
		return YearlyTrashTotal;
	}

	public void setYearlyTrashTotal(double YearlyTrashTotal) {
		this.YearlyTrashTotal = YearlyTrashTotal;
	}

	public double getWeeklyTrashTotal() {
		return WeeklyTrashTotal;
	}

	public void setWeeklyTrashTotal(double WeeklyTrashTotal) {
		this.WeeklyTrashTotal = WeeklyTrashTotal;
	}

	public double getDailyTrashTotal() {
		return DailyTrashTotal;
	}

	public void setDailyTrashTotal(double DailyTrashTotal) {
		this.DailyTrashTotal = DailyTrashTotal;
	}
	
	public double getMonthlyTrashTotal() {
		return MonthlyTrashTotal;
	}

	public void setTruckNumber(double MonthlyTrashTotal) {
		this.MonthlyTrashTotal = MonthlyTrashTotal;
	}
	
	public int getWeeklyAccounts() {
		return WeeklyAccounts;
	}

	public void setWeeklyAccounts(int WeeklyAccounts) {
		this.WeeklyAccounts = WeeklyAccounts;
	}
	
	public int getDailyAccounts() {
		return DailyAccounts;
	}

	public void setDailyAccounts(int DailyAccounts) {
		this.DailyAccounts = DailyAccounts;
	}
	
	public int getYearlyAccounts() {
		return YearlyAccounts;
	}

	public void setYearlyAccounts(int YearlyAccounts) {
		this.YearlyAccounts = YearlyAccounts;
	}
	
	public int getMonthlyAccounts() {
		return MonthlyAccounts;
	}

	public void setMonthlyAccounts(int MonthlyAccounts) {
		this.MonthlyAccounts = MonthlyAccounts;
	}
	
	public int getLifetimeAccounts() {
		return LifetimeAccounts;
	}

	public void setLifetimeAccounts(int LifetimeAccounts) {
		this.LifetimeAccounts = LifetimeAccounts;
	}
	
	

}
