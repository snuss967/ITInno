package helperMethods;

public class PasswordSaltHolder {
	//This is not meant to be secure, it is built with security intent but I would
	//be taking precautions if it were meant to be secure, it is for demonstration
	
	//Holds the passcode the hashed password 
	private String passcode;
	//Holds the salt the time in milliseconds
	private String salt;
	
	
	public PasswordSaltHolder(String passcode, String salt) 
	{
		this.passcode = passcode;
		this.salt = salt;
	}
	
	//can only set when it is created
	//can get whenever

	public String getPasscode()
	{
		return passcode;
	}
	
	public String getSalt()
	{
		return salt;
	}
	
}
