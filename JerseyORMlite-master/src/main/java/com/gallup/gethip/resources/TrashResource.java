
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.trash_records;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;
import helperMethods.billing;
import helperMethods.systemTotalsTrash;

// The Java class will be hosted at the URI path "/trash_records"
@Path("/trash")
public class TrashResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    @SuppressWarnings("deprecation")
	@GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Path("/{userName}/{StartDate}/{EndDate}/{authorizationCode}")
    @Produces("application/json")
    @Consumes("application/json")
    //@PathParam userName the identifier by which we are attempting to retrieve the data
    //@PathParam StartDate the StartDate of the cycle of the records we are retrieving
    //@PathParam EndDate the EndDate of the cycle of the records we are retrieving
    //@Param authorizationCode the authorizationCode that permits access to the data
    public List<trash_records> getIt(@PathParam("userName") String userName, @PathParam("StartDate") String StartDate, @PathParam("EndDate") String EndDate, @PathParam("authorizationCode") String authorizationCode) {
    	boolean authenticate = authentication.authenticate(userName, authorizationCode);
    	
    	//authenticate the login with the authentication code and the userName
    	List<trash_records> trashList = new ArrayList<trash_records>();
    	//create a list to hold our trash recrords
    	if(authenticate)
    	{
    		//if they match then continue
    		// separate the MMDDYYYY into Month Year and Date and set into a new Date object for comparison
    		char M1 = StartDate.charAt(0); 
    		char M2 = StartDate.charAt(1);
    		char D1 = StartDate.charAt(2);
    		char D2 = StartDate.charAt(3);
    		char Y1 = StartDate.charAt(4);
    		char Y2 = StartDate.charAt(5); 
    		char Y3 = StartDate.charAt(6);
    		char Y4 = StartDate.charAt(7);
    		String Month = String.valueOf(M1);
    		Month += M2;
    		String Day = String.valueOf(D1);
    		Day += D2;
    		String Year = String.valueOf(Y1);
    		Year += Y2;
    		Year += Y3;
    		Year += Y4;
    		//Convert the MMDDYYYY charcters seoarated above into Year Day and Month ints
    		int month = (Integer.parseInt(Month) - 1);
    		int year = (Integer.parseInt(Year) - 1900);
    		int day = Integer.parseInt(Day);
    		Date startDate = new Date();
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
    		//turn the year Day and Month Strings into Integers we can store
    		month = (Integer.parseInt(Month) - 1);
    		year = (Integer.parseInt(Year) - 1900);
    		day = Integer.parseInt(Day);
    		Date endDate = new Date();
    		endDate.setMonth(month);
    		endDate.setYear(year);
    		endDate.setDate(day);
    		System.out.println(endDate.getMonth());
    		try {
				List<trash_records>userNameList = getDao().queryForEq("UserName", userName);
				//get all records for the user
				for(trash_records tr : userNameList)
				{
					//for each collecion see if it fell between Start and End
					Date picked = tr.getPickedUp();
					if(picked.compareTo(startDate) > 0 && picked.compareTo(endDate) < 0)
					{
						trashList.add(tr);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				trashList = new ArrayList<trash_records>();
	    		trash_records tr = new trash_records();
	    		trashList.add(tr);
			}
    	}
    	else
    	{	
    		//if authentication fails return a list of nothing
    		trashList = new ArrayList<trash_records>();
    		trash_records tr = new trash_records();
    		trashList.add(tr);
    	}
    	//return the list of trash collection objects either way
    	return trashList;
        
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    //@Param recycleList a list of all of the data that we have collected
    public trash_records createtrash_records(List<trash_records> trashList){
    	// TODO update this to take the information we pass through to it and create individual objects based on it. 
    	// TODO modify to return success code
    	billing billSystem = billing.getInstance();
    	systemTotalsTrash sysTotalsTrashSystem = systemTotalsTrash.getInstance();
    	for(trash_records rec : trashList)
    	{
    		try {
    			billSystem.updateBillingRecord(rec.getUserName(), 0, rec.getWeight());
    			sysTotalsTrashSystem.updateSystemTotals(rec.getWeight());
				getDao().createIfNotExists(rec);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	return null;
    }
    
	private static Dao<trash_records, String> getDao(){
		@SuppressWarnings({ "unchecked", "static-access" })
		Dao<trash_records, String> dao = DataSourceManager.getInstance().getDao(trash_records.class);
    	return dao;
    }
}
