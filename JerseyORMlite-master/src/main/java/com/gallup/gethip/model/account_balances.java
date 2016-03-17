package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="account_balances")
public class account_balances {
	
	@DatabaseField(generatedId = true, columnName = "ID")
	private int ID;
	
	@DatabaseField(columnName = "trashWeight")
	private double trashWeight;
	
	@DatabaseField(columnName = "recycleWeight")
	private double recycleWeight;
	
	@DatabaseField(columnName = "billingStartDate")
	private Date billingStartDate;
	
	@DatabaseField(columnName = "billingEndDate")
	private Date billingEndDate;
	
	@DatabaseField(columnName = "billingExpirationDate")
	private Date billingExpirationDate;
	
	@DatabaseField(columnName = "trashPrice")
	private double trashPrice;
	
	@DatabaseField(columnName = "recycleCredit")
	private double recycleCredit;
	
	@DatabaseField(columnName = "totalPrice")
	private double totalPrice;
	
	@DatabaseField(columnName = "userName")
	private String userName;
	
	@DatabaseField(columnName = "billingCycleNumber")
	private int billingCycleNumber;
	
	
	
	public account_balances(){
		
	}
	
	public account_balances(double trashWeight, double recycleWeight, Date billingStartDate, Date billingEndDate, Date billingExpirationDate, double trashPrice, double recycleCredit, double totalPrice, String userName, int billingCycleNumber)
	{
		this.trashWeight = trashWeight;
		this.recycleWeight = recycleWeight;
		this.billingEndDate = billingEndDate;
		this.billingExpirationDate = billingExpirationDate;
		this.billingStartDate = billingStartDate;
		this.billingCycleNumber = billingCycleNumber;
		this.recycleCredit = recycleCredit;
		this.totalPrice = totalPrice;
		this.userName = userName;
		this.trashPrice = trashPrice;
	}
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getbillingCycleNumber() {
		return billingCycleNumber;
	}

	public void setbillingCycleNumber(int billingCycleNumber) {
		this.billingCycleNumber = billingCycleNumber;
	}
	
	public double gettrashWeight() {
		return trashWeight;
	}

	public void settrashWeight(double trashWeight) {
		this.trashWeight = trashWeight;
	}

	public double getrecycleWeight() {
		return recycleWeight;
	}

	public void setrecycleWeight(double recycleWeight) {
		this.recycleWeight = recycleWeight;
	}

	public Date getbillingStartDate() {
		return billingStartDate;
	}

	public void setbillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
	}

	public Date getbillingEndDate() {
		return billingEndDate;
	}

	public void setbillingEndDate(Date billingEndDate) {
		this.billingEndDate = billingEndDate;
	}
	
	public Date getbillingExpirationDate() {
		return billingExpirationDate;
	}

	public void setbillingExpirationDate(Date billingExpirationDate) {
		this.billingExpirationDate = billingExpirationDate;
	}

	public double gettrashPrice() {
		return trashPrice;
	}

	public void settrashPrice(double trashPrice) {
		this.trashPrice = trashPrice;
	}
	
	public double getrecycleCredit() {
		return recycleCredit;
	}

	public void setrecycleCredit(double recycleCredit) {
		this.recycleCredit = recycleCredit;
	}
	
	public double gettotalPrice() {
		return totalPrice;
	}

	public void settotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

}
