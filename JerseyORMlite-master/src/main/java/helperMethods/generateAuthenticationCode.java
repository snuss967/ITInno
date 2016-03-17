package helperMethods;

import java.util.Random;

public class generateAuthenticationCode {
	//@Param length the length of the random String
	public static String generateString(int length)
	{
		//generates a random string of @Param length
		//returns that String
		//integers 33 through 126 are usable
		String randomString = "";
		Random rand = new Random();
		
		for(int i = 0; i < length; i++)
		{
			int letterPosistion = (rand.nextInt(93) + 33);
			char letter = (char)letterPosistion;
			randomString += letter;
		}
		return randomString;
	}
}
