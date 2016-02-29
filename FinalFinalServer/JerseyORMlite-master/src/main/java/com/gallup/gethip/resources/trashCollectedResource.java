
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
    	List<trashcollected> Trash = new ArrayList<trashcollected>();
    	if(duration.equals("week"))
    	{
    		trashcollected tuesday1 = new trashcollected(1, 1, 20, 1, "0312016");
    		trashcollected tuesday2 = new trashcollected(1, 1, 25, 2, "0223016");
    		trashcollected tuesday3 = new trashcollected(1, 1, 23, 3, "02162016");
    		trashcollected tuesday4 = new trashcollected(1, 1, 32, 4, "02092016");
    		trashcollected tuesday5 = new trashcollected(1, 1, 21, 5, "02022016");
    		trashcollected tuesday6 = new trashcollected(1, 1, 24, 6, "01262016");
    		trashcollected tuesday7 = new trashcollected(1, 1, 12, 7, "01192016");
    		trashcollected tuesday8 = new trashcollected(1, 1, 20, 8, "01122016");
    		trashcollected tuesday9 = new trashcollected(1, 1, 26.45, 9, "01052016");
    		trashcollected tuesday10 = new trashcollected(1, 1, 24.65, 10, "12292015");
    		Trash.add(tuesday1);
    		Trash.add(tuesday2);
    		Trash.add(tuesday3);
    		Trash.add(tuesday4);
    		Trash.add(tuesday5);
    		Trash.add(tuesday6);
    		Trash.add(tuesday7);
    		Trash.add(tuesday8);
    		Trash.add(tuesday9);
    		Trash.add(tuesday10);
    		return Trash;
    	}
    	return Trash;
    	
    }
    
//our normal user will not have access to the following two methods these will only be accessible by the client that the machine uploads information to
    //eventually over cellular, right now over local host wifi. However for now we will only use wired connection so I am not implementing this for now.
    
    
    private Dao<trashcollected, String> getDao(){
    	Dao<trashcollected, String> trashcollectedDao = DataSourceManager.getInstance().getDao(trashcollected.class);
    	
    	return trashcollectedDao;
    }
}
