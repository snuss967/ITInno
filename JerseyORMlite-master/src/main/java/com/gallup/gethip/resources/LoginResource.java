
package com.gallup.gethip.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.user_accounts;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;
import helperMethods.generateAuthenticationCode;

// The Java class will be hosted at the URI path "/user_accounts"
@Path("/login")
public class LoginResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    //@GET 
    @POST
	// The Java method will produce content identified by thxe MIME Media
    // type "application/json"
    @Produces("application/json")
    //@Consumes("application/json")
    //@PathParam UserName the UserName of the account that we are trying to retrieve
    //@Param password the password that is consumed, user entered password
    @Path("/{UserName}/{password}")
    public user_accounts getIt(@PathParam("UserName") String UserName, @PathParam("password") String password) {
    	try {
    		//System.out.println("username: " + UserName);
			//System.out.println("password: " + password);
    		//logs the user in, takes username as a path parameter and consumes the password as JSON
			boolean authenticated = authentication.authenticatePassword(password, UserName);
			//if the password and username match then it is authenticated and continues
			System.out.println(authenticated);
			if(authenticated)
			{
				try
				{
					//System.out.println("username: " + UserName);
					//System.out.println("password: " + password);
					//querys for the useraccount object its ID is its UserName we were passed
					user_accounts ua = getDao().queryForId(UserName);
					//generates a new authentication code and updates it in the database
					ua.setAuthorizationCode(generateAuthenticationCode.generateString());
					getDao().update(ua);
					//returns the authentication code
					return ua;
				}
				catch(Exception e)
				{
					return null;
				}
				
			}
			else
				return null;
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
        
    }
    
    private Dao<user_accounts, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<user_accounts, String> dao = DataSourceManager.getInstance().getDao(user_accounts.class);
    	return dao;
    }
}
