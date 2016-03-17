
package helperMethods;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.account_balances;
import com.j256.ormlite.dao.Dao;

public class billing {
	//create a singleton that holds the rate at which we charge billing and credit recycling and the billing cycle that we are on
	private static int billingCycleNumber = 1;
	private static final double weightRate = .25;
	private static final double recycleCreditRate = .1; 
    private billing()
    {
    	
    }
    
    public static int getBillingCycleNumber()
    {
    	return billingCycleNumber;
    }
    
    private static billing billingInstance;
    private static boolean instantiated = false;
    //gets the Instance of the billing class
    public static billing getInstance()
    {
    	//refernces the billingInstance
    	//if billingInstance is null then it creates a new billing instance only happens the first time
    	if(!instantiated)
    	{
    		billingInstance = new billing();
    		instantiated = true;
    	}
    	return billingInstance;
    }
    
    @SuppressWarnings("deprecation")
	//@Param userName the userName of the account we are trying to access
    //@Param Type recycling(0) or trash(1) 
    //@Param weight the weight of the most recent collection
    public void updateBillingRecord(String userName, int Type, double weight)
    {
    	//updates a the billing record
    	//if a billing record for the period exists
    	//if one does not then it creates a new instance
    	try {
			List<account_balances> account = getDao().queryForEq("userName", userName);
			account_balances accountToUse;
			boolean instantiated = false;
			for(account_balances acc : account)
			{
				int billingNumber = acc.getbillingCycleNumber();
				if(billingNumber == billingCycleNumber)
				{
					accountToUse = acc;
					instantiated = true;
					if(Type == 1)
					{
						double recycleWeight = accountToUse.getrecycleWeight();
						recycleWeight += weight;
						double newBalance = (recycleCreditRate * recycleWeight);
						double totalBalance = accountToUse.gettotalPrice();
						totalBalance -= (recycleCreditRate * weight);
						accountToUse.settotalPrice(totalBalance);
						accountToUse.setrecycleWeight(recycleWeight);
						accountToUse.setrecycleCredit(newBalance);
						getDao().update(accountToUse);
					}
					else
					{
						double trashWeight = accountToUse.gettrashWeight();
						trashWeight += weight;
						double newBalance = (weightRate * trashWeight);
						double totalBalance = accountToUse.gettotalPrice();
						totalBalance += (weightRate * weight);
						accountToUse.settotalPrice(totalBalance);
						accountToUse.settrashWeight(trashWeight);
						accountToUse.settrashPrice(newBalance);
						getDao().update(accountToUse);
					}
				}
			}
			if(!instantiated)
			{
				Date today = new Date();
				Date expiration = new Date();
				Date lateDate = new Date();
				expiration.setDate(1);
				lateDate.setDate(15);
				int month = expiration.getMonth();
				month += 1;
				if(month == 12)
					month = 0;
				expiration.setMonth(month);
				lateDate.setMonth(month);
				if(Type == 1)
				{
					double recycleWeight = weight;
					double newBalance = (recycleCreditRate * recycleWeight);
					double totalBalance = 0;
					totalBalance -= (recycleCreditRate * weight);
					accountToUse = new account_balances(0,recycleWeight,today,expiration,lateDate,0,newBalance,totalBalance,userName,billingCycleNumber);
					
				}
				else
				{
					double trashWeight = weight;
					double newBalance = (weightRate * trashWeight);
					double totalBalance = 0;
					totalBalance += (weightRate * weight);
					accountToUse = new account_balances(trashWeight,0,today,expiration,lateDate,newBalance,0,totalBalance,userName,billingCycleNumber);
				}
				getDao().createIfNotExists(accountToUse);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private static Dao<account_balances, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<account_balances, String> dao = DataSourceManager.getInstance().getDao(account_balances.class);
    	return dao;
    }
}
