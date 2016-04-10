
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
import javax.ws.rs.core.MediaType;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.trash_records;
import com.gallup.gethip.model.trashpickup_type;
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
    @Consumes(MediaType.APPLICATION_JSON)
    //@Param recycleList a list of all of the data that we have collected
    public String createtrash_records(trashpickup_type trashList[]){
    	System.out.println("Im Here Guys!!!!");
    	// TODO update this to take the information we pass through to it and create individual objects based on it. 
    	// TODO modify to return success code
    	billing billSystem = billing.getInstance();
    	systemTotalsTrash sysTotalsTrashSystem = systemTotalsTrash.getInstance();
    	int i = 1;
    	Date timeNow = new Date();
    	trash_records tr = new trash_records(2329144,"ben1", 55.5,timeNow,1,04102016,2);
    	timeNow.setMinutes(36);
    	trash_records tr1 = new trash_records(2329144,"ben1",52.35,timeNow,1,04102016,3);
    	timeNow.setMinutes(37);
    	trash_records tr2 = new trash_records(2329144,"ben1",54.25,timeNow,1,04102016,4);
    	timeNow.setMinutes(38);
    	trash_records tr3 = new trash_records(5099093,"Benjamin",45.2,timeNow,1,04102016,5);
    	timeNow.setMinutes(39);
    	trash_records tr4 = new trash_records(5099093,"Benjamin",78.63,timeNow,1,04102016,6);
    	timeNow.setMinutes(40);
    	trash_records tr5 = new trash_records(5099093,"Benjamin",45.36,timeNow,1,04102016,7);
    	timeNow.setMinutes(41);
    	trash_records tr6 = new trash_records(1026046,"ben2",56.47,timeNow,1,04102016,8);
    	timeNow.setMinutes(42);
    	trash_records tr7 = new trash_records(1026046,"ben2",45.54,timeNow,1,04102016,9);
    	timeNow.setMinutes(43);
    	trash_records tr8 = new trash_records(1026046,"ben2",47.26,timeNow,1,04102016,10);
    	timeNow.setMinutes(44);
    	trash_records tr9 = new trash_records(2412801,"ben3",45.254,timeNow,1,04102016,11);
    	timeNow.setMinutes(45);
    	trash_records tr10 = new trash_records(2412801,"ben3",49.36,timeNow,1,04102016,12);
    	timeNow.setMinutes(46);
    	trash_records tr11 = new trash_records(2412801,"ben3",52.36,timeNow,1,04102016,13);
    	timeNow.setMinutes(47);
    	trash_records tr12 = new trash_records(2454861,"ben4",12.12,timeNow,1,04102016,14);
    	timeNow.setMinutes(48);
    	trash_records tr13 = new trash_records(2454861,"ben4",8.36,timeNow,1,04102016,15);
    	timeNow.setMinutes(49);
    	trash_records tr14 = new trash_records(2431895,"ben5",2.36,timeNow,1,04102016,16);
    	timeNow.setMinutes(50);
    	trash_records tr15 = new trash_records(2431895,"ben5",45.36,timeNow,1,04102016,17);
    	timeNow.setMinutes(51);
    	trash_records tr16 = new trash_records(2431895,"ben5",45.36,timeNow,1,04102016,18);
    	timeNow.setMinutes(52);
    	trash_records tr17 = new trash_records(2423366,"ben6",74.35,timeNow,1,04102016,19);
    	timeNow.setMinutes(53);
    	trash_records tr18 = new trash_records(2423366,"ben6",48.31,timeNow,1,04102016,20);
    	timeNow.setMinutes(54);
    	trash_records tr19 = new trash_records(2423366,"ben6",66.21,timeNow,1,04102016,21);
    	
    	try {
			getDao().createIfNotExists(tr);
			getDao().createIfNotExists(tr1);
	    	getDao().createIfNotExists(tr2);
	    	getDao().createIfNotExists(tr3);
	    	getDao().createIfNotExists(tr4);
	    	getDao().createIfNotExists(tr5);
	    	getDao().createIfNotExists(tr6);
	    	getDao().createIfNotExists(tr7);
	    	getDao().createIfNotExists(tr8);
	    	getDao().createIfNotExists(tr9);
	    	getDao().createIfNotExists(tr10);
	    	getDao().createIfNotExists(tr11);
	    	getDao().createIfNotExists(tr12);
	    	getDao().createIfNotExists(tr13);
	    	getDao().createIfNotExists(tr14);
	    	getDao().createIfNotExists(tr15);
	    	getDao().createIfNotExists(tr16);
	    	getDao().createIfNotExists(tr17);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    	//for(trashpickup_type alpha : trashList)
    	//{	
    		//System.out.println(alpha.getRFIDCode() + alpha.getWeight());
    		//i++;
    		/*try {
    			billSystem.updateBillingRecord(rec.getUserName(), 0, rec.getWeight());
    			sysTotalsTrashSystem.updateSystemTotals(rec.getWeight());
				getDao().createIfNotExists(rec);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
    	//}
    	return "It worked";
    }
    
	private static Dao<trash_records, String> getDao(){
		@SuppressWarnings({ "unchecked", "static-access" })
		Dao<trash_records, String> dao = DataSourceManager.getInstance().getDao(trash_records.class);
    	return dao;
    }
}
