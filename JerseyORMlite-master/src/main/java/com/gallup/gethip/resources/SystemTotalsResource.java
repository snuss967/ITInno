
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.system_totals;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;


// The Java class will be hosted at the URI path "/system_totals"
@Path("/totals")
public class SystemTotalsResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    @SuppressWarnings("deprecation")
	@GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
	//@PathParam StartDate the StartDate of the list of information from the system totals table taken as MMDDYYYY
	//@PathParam EndDate the EndDate of the list of information from the system totals table taken as MMDDYYYY
	@Path("/{StartDate}/{EndDate}")
    @Produces("application/json")
    public List<system_totals> getIt(@PathParam("StartDate") String StartDate, @PathParam("EndDate") String EndDate) {
    	List<system_totals> trashList = new ArrayList<system_totals>();
    	//Create a new list to hold system_totals objects
    		//Separate the MMDDYYYY string into its separate characters
    		char M1 = StartDate.charAt(0); 
    		char M2 = StartDate.charAt(1);
    		char D1 = StartDate.charAt(2);
    		char D2 = StartDate.charAt(3);
    		char Y1 = StartDate.charAt(4);
    		char Y2 = StartDate.charAt(5); 
    		char Y3 = StartDate.charAt(6);
    		char Y4 = StartDate.charAt(7);
    		//Concatonate the MMDDYYYY charcters into Month String and Day strings
    		String Month = String.valueOf(M1);
    		Month += M2;
    		String Day = String.valueOf(D1);
    		Day += D2;
    		String Year = String.valueOf(Y1);
    		Year += Y2;
    		Year += Y3;
    		Year += Y4;
    		//parse those strings to integers
    		int month = (Integer.parseInt(Month) - 1);
    		int year = (Integer.parseInt(Year) - 1900);
    		int day = Integer.parseInt(Day);
    		Date startDate = new Date();
    		startDate.setMonth(month);
    		startDate.setYear(year);
    		startDate.setDate(day);
    		//Same as above
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
    		List<system_totals> sysTotalList = new ArrayList<system_totals>();
    		CloseableIterator<system_totals> iterator = getDao().closeableIterator();
    			try {
    				//loop through all of the system collections searching for those that fall between start and end
    			    while (iterator.hasNext()) {
    			        system_totals sysTot = iterator.next();
    			        Date picked = sysTot.getDate();
    			        //if it falls between append to the list
    			        if(picked.compareTo(startDate) > 0 && picked.compareTo(endDate) < 0)
    					{
    						sysTotalList.add(sysTot);
    					}
    			    }
    			} 
    			finally {
    			    // close it at the end to close underlying SQL statement
    			    try {
    			    	//once were done close the loop so that it doesnt leak resources
						iterator.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
    			}
    		return sysTotalList;
    	}
    
        
    
    private Dao<system_totals, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<system_totals, String> dao = DataSourceManager.getInstance().getDao(system_totals.class);
    	return dao;
    }
}
