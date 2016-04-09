
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.account_balances;
import com.j256.ormlite.dao.Dao;

import helperMethods.authentication;
import helperMethods.billing;

// The Java class will be hosted at the URI path "/account_balances"
@Path("/balance/current")
public class AccountBalanceResource {
	
	@GET
	@Produces("application/json")
	@Path("/{UserName}/{authorizationCode}")
	//@PathParam UserName the username by which the user is trying to access
	public account_balances getBalance(@PathParam("UserName") String UserName, @PathParam("authenticationCode") String authenticationCode)
	{
		boolean authenticated = authentication.authenticate(UserName, authenticationCode);
		if(authenticated)
		{
			int billingCycleNum = billing.getBillingCycleNumber();
			try {
				List<account_balances> accBalList = getDao().queryForEq("UserName", UserName);
				for(account_balances acc1 : accBalList)
				{
					if(acc1.getbillingCycleNumber() == billingCycleNum)
					{
						return acc1;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		return null;
        
    }
    
    private Dao<account_balances, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<account_balances, String> dao = DataSourceManager.getInstance().getDao(account_balances.class);
    	return dao;
    }
}
