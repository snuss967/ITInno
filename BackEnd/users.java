package com.gallup.gethip.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="users")
public class users {
	
	@DatabaseField(generatedId = true, columnName = "AccountID")
	private int AccountID;
	
	@DatabaseField(columnName = "TRASH12212015")
	private double TRASH12212015;
	
	@DatabaseField(columnName = "RECYCABLES12212015")
	private double RECYCABLES12212015;
	
	@DatabaseField(columnName = "TIMEOFLASTPICKUP")
	private Date TIMEOFLASTPICKUP;
	
	@DatabaseField(columnName = "TrashBalance")
	private double TrashBalance;
	
	@DatabaseField(columnName = "RecycableBalance")
	private double RecycableBalance;
	
	@DatabaseField(columnName = "TotalBalance")
	private double TotalBalance;
	
	public users(){
		
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int AccountID) {
		this.AccountID = AccountID;
	}

	public double getTRASH12212015() {
		return TRASH12212015;
	}

	public void setTRASH12212015(double TRASH12212015) {
		this.TRASH12212015 = TRASH12212015;
	}

	public double getFirstName() {
		return RECYCABLES12212015;
	}

	public void setRECYCABLES12212015(double RECYCABLES12212015) {
		this.RECYCABLES12212015 = RECYCABLES12212015;
	}

	public Date getTIMEOFLASTPICKUP() {
		return TIMEOFLASTPICKUP;
	}

	public void setTIMEOFLASTPICKUP(Date TIMEOFLASTPICKUP) {
		this.TIMEOFLASTPICKUP = TIMEOFLASTPICKUP;
	}

	public double getTrashBalance() {
		return TrashBalance;
	}

	public void setHireDate(double TrashBalance) {
		this.TrashBalance = TrashBalance;
	}

	public double getRecycableBalance() {
		return RecycableBalance;
	}

	public void setGender(double RecycableBalance) {
		this.RecycableBalance = RecycableBalance;
	}
	
	public double TotalBalance()
	{
		return TotalBalance;
	}
	
	public void setTotalBalance(double TotalBalance)
	{
		this.TotalBalance = TotalBalance;
	}

}
