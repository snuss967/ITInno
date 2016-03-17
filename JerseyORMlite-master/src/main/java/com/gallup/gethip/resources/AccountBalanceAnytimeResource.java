
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.account_balances;
import com.gallup.gethip.model.user_accounts;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;
//TODO go through and fix this code
// The Java class will be hosted at the URI path "/user_accounts"
@Path("/balance/anytime")
public class AccountBalanceAnytimeResource {

    // TODO: update the class to suit your needs
    
    @SuppressWarnings("deprecation")
	// The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    //@PathParam userName the identifier by which we are attempting to retrieve the data
    //@PathParam StartDate the StartDate of the cycle of the records we are retrieving
    //@PathParam EndDate the EndDate of the cycle of the records we are retrieving
    //@Param authorizationCode the authorizationCode that permits access to the data
    
    //TODO go through the method and suit to our functionality it will operate much like the Trash or Recycle Resources
    @Path("/{userName}/{StartDate}/{EndDate}")
    @Produces("application/json")
    @Consumes("application/json")
    public List<account_balances> getIt(@PathParam("userName") String userName, @PathParam("StartDate") String StartDate, @PathParam("EndDate") String EndDate, String authorizationCode) {
    	boolean authenticate = authentication.authenticate(userName, authorizationCode);
    	//authenticate the user making sure that they have the right authorization code and UserName
    	List<account_balances> trashList = new ArrayList<account_balances>();
    	//create a list to hold all of our account_balance records
    	if(authenticate)
    	{
    		//if it is authenticated separate the MMDDYYYY Strings into individual characters
    		char M1 = StartDate.charAt(0); 
    		char M2 = StartDate.charAt(1);
    		char D1 = StartDate.charAt(2);
    		char D2 = StartDate.charAt(3);
    		char Y1 = StartDate.charAt(4);
    		char Y2 = StartDate.charAt(5); 
    		char Y3 = StartDate.charAt(6);
    		char Y4 = StartDate.charAt(7);
    		//concatonate the MMDDYYYY charcters to form the Month, Day, and Year variables
    		String Month = String.valueOf(M1);
    		Month += M2;
    		String Day = String.valueOf(D1);
    		Day += D2;
    		String Year = String.valueOf(Y1);
    		Year += Y2;
    		Year += Y3;
    		Year += Y4;
    		//Parse Month Day Year to ints
    		int month = (Integer.parseInt(Month) - 1);
    		int year = (Integer.parseInt(Year) - 1900);
    		int day = Integer.parseInt(Day);
    		Date startDate = new Date();
    		//set them into the Date object
    		startDate.setMonth(month);
    		startDate.setYear(year);
    		startDate.setDate(day);
    		M1 = EndDate.charAt(0); 
    		M2 = EndDate.charAt(1);
    		D1 = EndDate.charAt(2);
    		D2 = EndDate.charAt(3);
    		Y1 = EndDate.charAt(4);
    		Y2 = EndDate.charAt(5); 
    		Y3 = EndDate.charAt(6);
    		Y4 = EndDate.charAt(7);
    		Month = String.valueOf(M1);
    		Month += M2;
    		Day = String.valueOf(D1);
    		Day += D2;
    		Year = String.valueOf(Y1);
    		Year += Y2;
    		Year += Y3;
    		Year += Y4;
    		month = (Integer.parseInt(Month) - 1);
    		year = (Integer.parseInt(Year) - 1900);
    		day = Integer.parseInt(Day);
    		Date endDate = new Date();
    		endDate.setMonth(month);
    		endDate.setYear(year);
    		endDate.setDate(day);
    		try {
				List<account_balances>userNameList = getDao().queryForEq("UserName", userName);
				//get all account_balances records containing the UserName we passed
				for(account_balances tr : userNameList)
				{
					//loop through the userNameList seeing if its dates fall between start and end
					Date picked = tr.getbillingStartDate();
					if(picked.compareTo(startDate) > 0 && picked.compareTo(endDate) < 0)
					{
						//if yes add it to the list
						trashList.add(tr);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    		return null;
			}
    	}
    	else
    	{	
    		//if auth fails return null
    		
    		return null;
    	}
    	return trashList;
        
    }
    
    private Dao<account_balances, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<account_balances, String> dao = DataSourceManager.getInstance().getDao(account_balances.class);
    	return dao;
    }
}
