
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.trashcollected;
import com.j256.ormlite.dao.Dao;

// The Java class will be hosted at the URI path "/employee"
@Path("/trashcollected")
public class trashCollectedResource {
    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    @Path("/{duration}/{startDate}/{endDate}/{userAccountNumber}/{authorizationCode}")
    public List<trashcollected> getIt(@PathParam("duration") String duration, @PathParam("startDate")String startDat, @PathParam("endDate")String endDat, @PathParam("userAccountNumber")String userAccountNum,  @PathParam("authorizationCode")String authorizationCod) {
    	List<trashcollected> trash = new ArrayList<trashcollected>();
    	int authCode = 1234; 
    	int startDate = Integer.parseInt(startDat);
    	int endDate = Integer.parseInt(endDat);
    	int authorizationCode = Integer.parseInt(authorizationCod);
    	int userAccountNumber = Integer.parseInt(userAccountNum);
    	if(authorizationCode == authCode)
    	{
    		Dao<trashcollected, String>trashcollectedDao = getDao();
    	if(duration == "day")
    	{
    		//code to package JSON up for day here
    		for(trashcollected trash1 : trashcollectedDao)
    		{
    			Date date = trash1.getPickUpTime();
    			@SuppressWarnings("deprecation")
				Integer month = date.getMonth();
    			@SuppressWarnings("deprecation")
				Integer day = date.getDay();
    			@SuppressWarnings("deprecation")
				Integer year = date.getYear();
    			String dateS = month.toString();
    			dateS += day.toString();
    			dateS += year.toString();
    			int dateI = Integer.parseInt(dateS);
    			if(trash1.getID() == userAccountNumber && dateI == startDate)
    			{
    				trash.add(trash1);
    				return trash;
    				//this is a bad use policy but we need to cancel because we can only have one collection per day and we need to save system resources
    			}
    		}
    			
    	}
    	if(duration == "week")
    	{
    		//code to Package JSON up for week here
    		for(trashcollected trash1 : trashcollectedDao)
    		{
    			Date date = trash1.getPickUpTime();
    			@SuppressWarnings("deprecation")
				Integer month = date.getMonth();
    			@SuppressWarnings("deprecation")
				Integer day = date.getDay();
    			@SuppressWarnings("deprecation")
				Integer year = date.getYear();
    			String dateS = month.toString();
    			dateS += day.toString();
    			dateS += year.toString();
    			int dateI = Integer.parseInt(dateS);
    			//trash that matches our userAccountNumber and is between or equal to the start and end dates
    			if(trash1.getID() == userAccountNumber && dateI >= startDate && dateI <= endDate)
    			{
    				trash.add(trash1);
    			}
    		}
    		return trash;
    			
    	}
    	if(duration == "month")
    	{
			//code to Package JSON up for month here
    		
    	}
    	if(duration == "year")
    	{
    		//code to Package JSON up for year here
    		for(trashcollected trash1 : trashcollectedDao)
    		{
	    		Date date = trash1.getPickUpTime();
				@SuppressWarnings("deprecation")
				Integer month = date.getMonth();
				@SuppressWarnings("deprecation")
				Integer day = date.getDay();
				@SuppressWarnings("deprecation")
				Integer year = date.getYear();
				String dateS = month.toString();
				dateS += day.toString();
				dateS += year.toString();
				int dateI = Integer.parseInt(dateS);
				//trash that matches our userAccountNumber and is between or equal to the start and end dates
					if(trash1.getID() == userAccountNumber && dateI >= startDate && dateI <= endDate)
					{
						trash.add(trash1);
					}
    		}
    		return trash;
    	}
    	else
    	{
    		return trash;
    		//an empty list will mean that there is an error
    	}
    	}
        return trash;
    }
    
//our normal user will not have access to the following two methods these will only be accessible by the client that the machine uploads information to
    //eventually over cellular, right now over local host wifi. However for now we will only use wired connection so I am not implementing this for now.
    
    
    private Dao<trashcollected, String> getDao(){
    	Dao<trashcollected, String> trashcollectedDao = DataSourceManager.getInstance().getDao(trashcollected.class);
    	
    	return trashcollectedDao;
    }
}
