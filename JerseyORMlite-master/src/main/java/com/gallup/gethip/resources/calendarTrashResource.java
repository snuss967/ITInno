
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.trash_records;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;

// The Java class will be hosted at the URI path "/trash_records"
@Path("/calendar/trash")
public class calendarTrashResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
	 @GET 
	    // The Java method will produce content identified by the MIME Media
	    // type "application/json"
	    @Produces("application/json")
	    @Consumes("application/json")
	 //@PathParam UserName the UserName of the account that is trying to be accessed
	 //@PathParam MMYYYY the month and the year that we will retrieve all of the collection data for
	 //@Param authorizationCode String consumed that will permit the user to access 
	 @Path("/{UserName}/{MMYYYY}")
	    public List<trash_records> getIt(@PathParam("UserName") String UserName, @PathParam("MMYYYY")String MMYYYY, String authorizationCode) {
	    	boolean authenticated = authentication.authenticate(UserName, authorizationCode);
	    	if(authenticated)
	    	{
	    		//extract month from Parameter
	    		char M1 = MMYYYY.charAt(0); 
	    		char M2 = MMYYYY.charAt(1);
	    		String month = String.valueOf(M1);
	    		month += M2;
	    		//extract year from Parameter
	    		char Y1 = MMYYYY.charAt(2);
	    		char Y2 = MMYYYY.charAt(3); 
	    		char Y3 = MMYYYY.charAt(4);
	    		char Y4 = MMYYYY.charAt(5);
	    		String year = String.valueOf(Y1);
	    		year += (Y2 + Y3 + Y4);
	    		//grab list of all objects with userName
	    		try {
					List<trash_records> recycleList = getDao().queryForEq("UserName", UserName);
					List<trash_records> monthList = new ArrayList<trash_records>();
					//loop through all objects pulling out DateInt
		    		for(trash_records rec : recycleList)
		    		{
		    			//Extract month from DateINT
		    	    	int DateInt = rec.getDate();
		    	    	String Date = Integer.toString(DateInt);
		    	    	char m1 = Date.charAt(0); 
		        		char m2 = Date.charAt(1);
		        		String Month = String.valueOf(m1);
		        		Month += m2;
		        		//Extract Year from DateINT
		        		char y1 = Date.charAt(4);
		        		char y2 = Date.charAt(5); 
		        		char y3 = Date.charAt(6);
		        		char y4 = Date.charAt(7);
		        		String Year = String.valueOf(y1);
		        		Year += y2;
		        		Year += y3;
		        		Year += y4;
			    		
			    		if(Year.equals(year) && Month.equals(month))
			    		{
			    			//compare Month and Year (from DateINT and from Parameter)
				    		//if both match add to list
			    			monthList.add(rec);
			    		}
			    		
			    		//after it loops through the list return that list
		    		}
		    		return monthList;
		    		
	    		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	    		
	    		
	    	}
	    	else
	    		return null;
	        
	    }
    
    private Dao<trash_records, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<trash_records, String> dao = DataSourceManager.getInstance().getDao(trash_records.class);
    	return dao;
    }
}
