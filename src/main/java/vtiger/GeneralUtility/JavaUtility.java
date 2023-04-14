package vtiger.GeneralUtility;

import java.util.Date;
import java.util.Random;
/**
 * This class consists all generic methods related to Java
 * @author Piyusha Chipare
 *
 */
public class JavaUtility 
{
	/**
	 * This method will return random number after every run
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random rn=new Random();
		return rn.nextInt(1000);
	}
	  
	/**
	 * This method will return current system date
	 * @return
	 */
	public String getSystemDate() 
	{
		Date d=new Date();
		return d.toString();
	}
	
	/**
	 * This method till return system time in specified format
	 * @return
	 */
	public String getSystemDateFormat() 
	{
		Date d=new Date();
		String[] darr = d.toString().split(" ");
		String date = darr[2];
		String month = darr[1];
		String year = darr[5];
		String time = darr[3].replace(":", "-");
		String datevalue = date+"-"+month+"-"+year+"-"+time;
		return datevalue;
	}
	
	
	
	
	
	
	
	
	
}
