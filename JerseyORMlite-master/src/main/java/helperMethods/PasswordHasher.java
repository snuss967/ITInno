package helperMethods;

import java.security.MessageDigest;
import java.util.Calendar;

public class PasswordHasher {
	
	//@Param password the password the user entered
	//@Return PasswordSaltHolder holds the new hashed password and the salt string
	public static PasswordSaltHolder hashPassword(String password) throws Exception
    {	
		//Get a calendar object (it is a singleton) so that we can get the time in milliseconds the salt and hash it
        Calendar calendar = Calendar.getInstance();
        Long time = calendar.getTimeInMillis();
        password += time;
        //Hash the password
    	MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Sets the salt and passcode into the PasswordSaltHolder returns that PasswordSaltHolder
        String salt = time.toString();
        String passcode = sb.toString();
        PasswordSaltHolder holder = new PasswordSaltHolder(passcode, salt);
        return holder;
    }
}
