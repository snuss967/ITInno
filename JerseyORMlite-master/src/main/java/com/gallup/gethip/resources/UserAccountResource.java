
package com.gallup.gethip.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.PasswordHolder;
import com.gallup.gethip.model.returnable_user_accounts;
import com.gallup.gethip.model.user_accounts;
import com.j256.ormlite.dao.Dao;

import helperMethods.PasswordHasher;
import helperMethods.PasswordSaltHolder;
import helperMethods.authentication;
import helperMethods.generateAuthenticationCode;

// The Java class will be hosted at the URI path "/user_accounts"
@Path("/accounts")
public class UserAccountResource {

    // TODO: update so that POST returns only returnable_user_accounts
    
    // The Java method will process HTTP GET requests
    @GET 
    //Get User Account Information
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    //@Param UserName is the username of the account that we are trying to access
    //Method will return the details that the user should be able to access
    //need to make sure that the user is unable to access the UserName parameter on the client
    @Path("/{UserName}")
    public returnable_user_accounts getIt(@PathParam("UserName") String UserName, String authenticationCode) {
    	user_accounts emp = null;
    	//creates an empty user account reference
    	boolean authorized = authentication.authenticate(UserName, authenticationCode);
    	//reaches out to the static authenticate method on the authentication class separate login lookup from the method
    	if(authorized)
    	{
    		//if user logged in
    	try {
    		//look for the useraccount that matches the ID its username
			emp = getDao().queryForId(UserName);
			if(emp == null){
				return null;
			}else{
				returnable_user_accounts rua = new returnable_user_accounts(emp.getUserName(), emp.getAddress(), emp.getZip(), emp.getCity(), emp.getState(), emp.getPhoneNumber());
				return rua;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw error message
		}
    	}
    	return null;
        
    }
    
    @POST
    //Create a new user account
    // TODO @Param user_accounts is the user_account with all of its information we need to update this to take in only the 
    //the information that is inserted through the form
    @Produces("application/json")
    @Consumes("application/json")
    public user_accounts createuser_accounts(user_accounts ua){
    	try {
    		//takes the information the client passed in and creates a new account
    		//generates the authentication code and sets it
    		ua.setAuthorizationCode(generateAuthenticationCode.generateString(45));
			user_accounts empPrime = getDao().createIfNotExists(ua);
			if(empPrime == null){
				//maybe put in code later to see if ua is populated
				return null;
			}else{
				//returns empPrime with the authentiaction code
				return empPrime;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  null;
    }
    
    @PUT
    //Update user account for now this will only be password updating 
    //@Param passhold object holds the currentPassword and the newPassword
    //@Param UserName String that retrieves the username from the Path
    @Produces("application/jsonl")
    @Consumes("application/json")
    @Path("/{UserName}")
    public boolean updateuser_accounts(PasswordHolder passhold, @PathParam("UserName")String UserName){
    	//Take the current password and check to see if it is right
    	boolean success = false;

    	try {
			boolean authenticated = authentication.authenticatePassword(passhold.getCurrentPassword(), UserName);
			if(authenticated)
			{
				//if passwords match
				PasswordSaltHolder psh = PasswordHasher.hashPassword(passhold.getNewPassword());
				//hash the password they put in we will get the salt which is the time in milliseconds too
				try
				{
					//then update the password 
				user_accounts ua = getDao().queryForId(UserName);
				ua.setSalt(psh.getSalt());
				ua.setPassword(psh.getPasscode());
				getDao().update(ua);
				success = true;
				}
				catch(Exception e)
				{
					success = false;
				}
				
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
			
		}
    	return success;
    }
    
    private Dao<user_accounts, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<user_accounts, String> dao = DataSourceManager.getInstance().getDao(user_accounts.class);
    	return dao;
    }
}
