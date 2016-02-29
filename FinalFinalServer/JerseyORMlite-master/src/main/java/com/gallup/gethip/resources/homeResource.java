
package com.gallup.gethip.resources;

import java.sql.SQLException;
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
import com.gallup.gethip.model.home;
import com.j256.ormlite.dao.Dao;

// The Java class will be hosted at the URI path "/employee"
@Path("/home")
public class homeResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    @Path("/{username}")
    public home getIt(@PathParam("username") String username) {
    	home h = new home(1, 455621, 4852, 300, 45, 20);
    	/* try {
			h = getDao().queryForId(username);
			System.out.println("I Failed");
			return h;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("In Catch");
			h = new 
			e.printStackTrace();
			return h;
		}
		*/
    	return h;
    }
    
    private Dao<home, String> getDao(){
    	Dao<home, String> dao = DataSourceManager.getInstance().getDao(home.class);
    	return dao;
    }
}
