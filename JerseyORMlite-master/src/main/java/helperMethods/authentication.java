
package helperMethods;

import java.security.MessageDigest;
import java.sql.SQLException;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.user_accounts;
import com.j256.ormlite.dao.Dao;

// The Java class will be hosted at the URI path "/employee"
public class authentication {
	public static boolean authenticate(String userName, String authenticationCode)
	{
		//status if password matches or not
		boolean status;
		try {
			//gets the username account
			user_accounts ua = getDao().queryForId(userName);
			//gets the authorization code out of the user account
			System.out.println(ua.getUserName());
			String authCode = ua.getAuthorizationCode();
			System.out.println(authenticationCode + " " + authCode);
			if(authCode.equals(authenticationCode)) {
				//if authorization code passes the authentication code we passed in returns true
				status = true;
				System.out.println("equals");
			} else {
				status = false;
				System.out.println("not equals");
				
				//if it fails we return false
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = false;
			//fails and we set status to false
		}
		//returns status
		return status;
	}
	
	//@Param password the password the user entered
	//@Param userName the userName the user entered id of userAccount
	
	//takes in a userName and the supposed password for that username sees if they match
	public static boolean authenticatePassword(String password, String userName) throws Exception
	{
		user_accounts ua;
		//user account object reference
		boolean authenticate = false;
		//authenticate reference
		try {
			System.out.println("username: " + userName);
			System.out.println("password: " + password);
			ua = getDao().queryForId(userName);
			String uaPassword = ua.getPassword();
			System.out.println(uaPassword + " " + password);
			if(uaPassword.equals(password)) {
				System.out.println("equal");
				authenticate = true;
			} else {
				System.out.println(uaPassword + "\n" + password);
			}
			//gets the account that is the UserName
			/*String Salt = ua.getSalt();
			//gets the salt we used on that password
			password += Salt;
			//appends the salt to the password
			//hashes the password with SHA-256
	    	MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        if(sb.toString().equals(ua.getPassword()))
	        {
	        	//if the hash equals the user account password returns true
	        	authenticate = true;
	        }
	        else
	        	authenticate = false;
	        	//if they dont match then return false
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			authenticate = false;
			System.out.print("catch is running");
		}
		return authenticate;
		
	}
    private static Dao<user_accounts, String> getDao(){
    	@SuppressWarnings({ "unchecked", "static-access" })
		Dao<user_accounts, String> dao = DataSourceManager.getInstance().getDao(user_accounts.class);
    	return dao;
    }
}
