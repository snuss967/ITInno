
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.pick_up_days;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;

// The Java class will be hosted at the URI path "/pickedup"
@Path("/pickedup")
public class PickUpDaysResource {

	//will eventually need to put in code that loops through and checks for each account what day it assigned to be pickedup that week
	//we will now only statically type in information
	
    //Create the beginning of the week
	Date startDate = new Date();
	//Set to Midnight on Sunday
	//Create the ending of the week
    Date endDate = new Date();
    //Set to 11:59 the following Saturday
    //these are unchangeable we will eventually put in a method to change them
    // The Java method will process HTTP GET requests
    @SuppressWarnings("deprecation")
	@GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
	//@PathParam UserName the ID by which the user is identified
	//@Param AuthenticationCode the code that is stored in cookie on login used to get access to the UsersInformation proves they loggedin 
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{UserName}")
    public pick_up_days getIt(@PathParam("UserName") String UserName, String AuthenticationCode) {
    	startDate.setDate(13);
    	startDate.setHours(0);
    	startDate.setMinutes(0);
    	startDate.setSeconds(0);
    	endDate.setDate(19);
    	endDate.setHours(23);
    	endDate.setMinutes(59);
    	endDate.setSeconds(59);
    	pick_up_days pup;
    	//authorize the transaction
    	boolean authorized = authentication.authenticate(UserName, AuthenticationCode);
    	if(authorized)
    	{
    	//query for all entries with username
    		try {
				List<pick_up_days> days = getDao().queryForEq("UserName", UserName);
				for(pick_up_days obj : days)
				{
					//loop through this list and see if any have dates that fall into the category defined
					if(endDate.after(obj.getAssignedPickUpDay()) && startDate.before(obj.getAssignedPickUpDay()))
					{
						//set our pick_up_days variable to this object
						pup = obj;
						return pup;
					}
				}
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
    	}
    	return null;
        
    }
    
    private static Dao<pick_up_days, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<pick_up_days, String> dao = DataSourceManager.getInstance().getDao(pick_up_days.class);
    	return dao;
    }
}
