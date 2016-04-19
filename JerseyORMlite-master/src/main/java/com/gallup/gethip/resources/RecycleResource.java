
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
import com.gallup.gethip.model.recycle_records;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;
import helperMethods.billing;
import helperMethods.systemTotalsTrash;

// The Java class will be hosted at the URI path "/recycle"
@Path("/recycle")
public class RecycleResource {
	
    
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
    public List<recycle_records> getIt(@PathParam("userName") String userName, @PathParam("StartDate") String StartDate, @PathParam("EndDate") String EndDate, @PathParam("authorizationCode") String authorizationCode) {
    	boolean authenticate = authentication.authenticate(userName, authorizationCode);
    	List<recycle_records> trashList = new ArrayList<recycle_records>();
    	if(authenticate)
    	{
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
    		month = (Integer.parseInt(Month) - 1);
    		year = (Integer.parseInt(Year) - 1900);
    		day = Integer.parseInt(Day);
    		Date endDate = new Date();
    		endDate.setMonth(month);
    		endDate.setYear(year);
    		endDate.setDate(day);
    		try {
				List<recycle_records>userNameList = getDao().queryForEq("UserName", userName);
				for(recycle_records tr : userNameList)
				{
					Date picked = tr.getPickedUp();
					if(picked.compareTo(startDate) > 0 && picked.compareTo(endDate) < 0)
					{
						trashList.add(tr);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				trashList = new ArrayList<recycle_records>();
	    		recycle_records tr = new recycle_records();
	    		trashList.add(tr);
			}
    	}
    	else
    	{	
    		trashList = new ArrayList<recycle_records>();
    		recycle_records tr = new recycle_records();
    		trashList.add(tr);
    	}
    	return trashList;
        
    }
    
    @POST
    @Path("/{RFID}/{WEIGHT}/{USERNAME}")
    @Produces("application/json")
    @Consumes("application/json")
    //@Param recycleList a list of all of the data that we have collected
    public recycle_records createrecycle_records(@PathParam("RFID") String RFID, @PathParam("WEIGHT") String WEIGHT, @PathParam("USERNAME") String UserName){
    	// TODO update this to take the information we pass through to it and create individual objects based on it. 
    	// TODO modify to return success code
    	double weight = Double.parseDouble(WEIGHT);
    	billing billSystem = billing.getInstance();
    	recycle_records rec = new recycle_records();
    	Date date = new Date();
    	int RFIDNum = Integer.parseInt(RFID);
    	rec.setDate(4182016);
    	rec.setPickedUp(date);
    	rec.setRFIDNumber(RFIDNum);
    	rec.setTruckNumber(0);
    	rec.setUserName(UserName);
    	rec.setWeight(weight);
    	systemTotalsTrash sysTotalsTrashSystem = systemTotalsTrash.getInstance();
    		try {
    			billSystem.updateBillingRecord(UserName, 0, weight);
    			sysTotalsTrashSystem.updateSystemTotals(weight);
				getDao().createIfNotExists(rec);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	return null;
    }
    
    private Dao<recycle_records, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<recycle_records, String> dao = DataSourceManager.getInstance().getDao(recycle_records.class);
    	return dao;
    }
}
