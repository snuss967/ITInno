
package helperMethods;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.system_totals;
import com.gallup.gethip.model.system_totals_trash;
import com.j256.ormlite.dao.Dao;

public class systemTotals {
	private Calendar calendar;
	private Date dailyRefresh;
	private Date weeklyRefresh;
	private Date monthlyRefresh;
	private Date yearlyRefresh;
	private Integer entryIDNumber = 1;
	private boolean instantiated = false;
	private systemTotals soloInstantiation;
	@SuppressWarnings("deprecation")
	private systemTotals()
	{
		Date date = new Date();
		system_totals tots = new system_totals(0,0,0,0,0,date,4182016,1);
		try {
			getDao().createIfNotExists(tots);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*//Create a private constructor that when it is first constructed will set the Dates for the dailyRefresh, weeklyRefresh, monthlyRefresh, yearlyRefresh
		//Takes the current date and adds one day, 7 days, 1 month and 1 year
		//Checks if day is 31 if it is then it will add 1 day
		dailyRefresh = new Date();
		int day = dailyRefresh.getDate();
		if(day <= 31)
		{
			day += 1;
			dailyRefresh.setDate(day);
		}
		else
		{
			day = 1;
			int month = dailyRefresh.getMonth();
			month += 1;
			dailyRefresh.setMonth(month);
			dailyRefresh.setDate(day);
			
		}
		weeklyRefresh = new Date();
		int monthDay = weeklyRefresh.getDay();
		monthDay += 7;
		//adds 7 days will increment the month
		if(monthDay <= 31)
		{
			weeklyRefresh.setDate(monthDay);
		}
		else
		{
			int month = weeklyRefresh.getMonth();
			int year = (weeklyRefresh.getYear() + 1900);
			
			monthDay -= 31;
			switch(month)
			{
				case 0:
					break;
				case 1:
					break;
				case 2:
					boolean leapYearWeekly;
					if((year % 4) == 0)
					{
						if((year % 100) == 0)
						{
							if((year % 400) == 0)
								leapYearWeekly = true;
							else
								leapYearWeekly = false;
						}
						else
							leapYearWeekly = true;
					}
					else
						leapYearWeekly = false;
					if(leapYearWeekly)
					{
						monthDay += 2;
					}
					else
					{
						monthDay += 3;
					}
					break;
				case 3:
					break;
				case 4:
					monthDay += 1;
					break;
				case 5:
					break;
				case 6:
					monthDay += 1;
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					monthDay += 1;
					break;
				case 10:
					break;
				case 11:
					monthDay += 1;
					break;
			}
				int month1 = weeklyRefresh.getMonth();
				if(month1 == 12)
					month1 = 0;
				weeklyRefresh.setMonth(month1);
				weeklyRefresh.setDate(monthDay);
		}
		monthlyRefresh = new Date();
		int month = monthlyRefresh.getMonth();
		if(month == 12)
		{
			month = 0;
		}
		monthlyRefresh.setMonth(month);
		yearlyRefresh = new Date();
		int year = (yearlyRefresh.getYear() + 1901);
		yearlyRefresh.setYear(year);
	}
	
	public systemTotals getInstance()
	{
		if(!instantiated)
		{
			soloInstantiation = new systemTotals();
		}
		return soloInstantiation;
		*/
			
	}
	//greater than 0 if after
	//less than 0 if before
	@SuppressWarnings({ "unused", "deprecation" })
	private void updateSystemTotals(double weight)
	{	
		/*boolean newEntry = false;
		Date timeNow = calendar.getTime();
		int dailyStatus = timeNow.compareTo(dailyRefresh);
		int weeklyStatus = timeNow.compareTo(weeklyRefresh);
		int monthlyStatus = timeNow.compareTo(monthlyRefresh);
		int yearlyStatus = timeNow.compareTo(yearlyRefresh);
		boolean newWeek = false;
		boolean newMonth = false;
		boolean newYear = false;
		if(dailyStatus > 0)
		{
			newEntry = true;
			entryIDNumber++;
			int day = dailyRefresh.getDate();
			if(day <= 31)
			{
				day += 1;
				dailyRefresh.setDate(day);
			}
			else
			{
				day = 1;
				int month = dailyRefresh.getMonth();
				month += 1;
				dailyRefresh.setMonth(month);
				dailyRefresh.setDate(day);
				
			}
			if(weeklyStatus > 0)
			{
				newWeek = true;
				int monthDay = weeklyRefresh.getDay();
				monthDay += 7;
				if(monthDay <= 31)
				{
					weeklyRefresh.setDate(monthDay);
				}
				else
				{
					int month = weeklyRefresh.getMonth();
					int year = (weeklyRefresh.getYear() + 1900);
					
					monthDay -= 31;
					switch(month)
					{
						case 0:
							break;
						case 1:
							break;
						case 2:
							boolean leapYearWeekly;
							if((year % 4) == 0)
							{
								if((year % 100) == 0)
								{
									if((year % 400) == 0)
										leapYearWeekly = true;
									else
										leapYearWeekly = false;
								}
								else
									leapYearWeekly = true;
							}
							else
								leapYearWeekly = false;
							if(leapYearWeekly)
							{
								monthDay += 2;
							}
							else
							{
								monthDay += 3;
							}
							break;
						case 3:
							break;
						case 4:
							monthDay += 1;
							break;
						case 5:
							break;
						case 6:
							monthDay += 1;
							break;
						case 7:
							break;
						case 8:
							break;
						case 9:
							monthDay += 1;
							break;
						case 10:
							break;
						case 11:
							monthDay += 1;
							break;
					}
						int month1 = weeklyRefresh.getMonth();
						if(month1 == 12)
							month1 = 0;
						weeklyRefresh.setMonth(month1);
						weeklyRefresh.setDate(monthDay);
				}
						if(monthlyStatus > 0)
						{
							newMonth = true;
							int month = monthlyRefresh.getMonth();
							if(month == 12)
							{
								month = 0;
							}
							monthlyRefresh.setMonth(month);
							if(yearlyStatus > 0)
							{
								newYear = true;
								int year = (yearlyRefresh.getYear() + 1901);
								yearlyRefresh.setYear(year);
							}
						}
			}
		}
		system_totals systotal;
		if(newEntry)
		{
			Integer oldID = entryIDNumber;
			oldID--;
			String IDNumber = oldID.toString();
			try {
				systotal = getDao().queryForId(IDNumber);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			system_totals oldSystemTotal;
			try {
				oldSystemTotal = getDao().queryForId(IDNumber);
				Date today = calendar.getTime();
				double month = oldSystemTotal.getMonth();
				double week = oldSystemTotal.getWeek();
				double year = oldSystemTotal.getYear();
				Integer dayInt = today.getDay();
				Integer monthInt = today.getMonth();
				Integer yearInt = (today.getYear() + 1900);
				String dayString = "";
				if(dayInt < 10)
				{
					dayString = ("0" + dayInt); 
				}
				else
					dayString = dayInt.toString();
				String monthString = "";
				if(monthInt < 10)
				{
					monthString = ("0" + monthInt); 
				}
				else
					monthString = monthInt.toString();
				String yearString = yearInt.toString(); 
				String dateString = dayString + monthString + yearString;
				int date = Integer.parseInt(dateString);
				if(newMonth)
				{
					month = 0;
				}
				if(newYear)
				{
					year = 0;
				}
				if(newWeek)
				{
					week = 0;
				}
				month += weight;
				year += weight;
				week += weight;
				double lifetime = oldSystemTotal.getLifetime() + weight;
				system_totals newSystemTotal = new system_totals(weight, week, month, year, lifetime, today, date ,entryIDNumber);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String IDNumber = entryIDNumber.toString();
			try {
				systotal = getDao().queryForId(IDNumber);
				double month = systotal.getMonth() + weight;
				double week = systotal.getWeek() + weight;
				double year = systotal.getYear() + weight;
				double day = systotal.getDay() + weight;
				double lifetime = systotal.getLifetime() + weight;
				systotal.setDay(day);
				systotal.setLifetime(lifetime);
				systotal.setMonth(month);
				systotal.setWeek(week);
				systotal.setDay(day);
				int suc = getDao().update(systotal);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		*/
		system_totals sysTotal;
		try {
			sysTotal = getDao().queryForId("1");
			double Lifetime = sysTotal.getLifetime();
			double Month = sysTotal.getMonth();
			double Week = sysTotal.getWeek();
			double Year = sysTotal.getYear();
			double Day = sysTotal.getDay();
			Day += weight;
			Lifetime += weight;
			Week += weight;
			Year += weight;
			Month += weight;
			sysTotal.setDay(Day);
			sysTotal.setLifetime(Lifetime);
			sysTotal.setMonth(Month);
			sysTotal.setWeek(Week);
			sysTotal.setYear(Year);
			getDao().update(sysTotal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    private Dao<system_totals, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<system_totals, String> dao = DataSourceManager.getInstance().getDao(system_totals.class);
    	return dao;
    }
}
