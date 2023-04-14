package vtiger.Practice;

import java.io.IOException;

import vtiger.GeneralUtility.ExcelFileUtility;
import vtiger.GeneralUtility.JavaUtility;
import vtiger.GeneralUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String data = pUtil.readDataFromPropertyFile("url");
		String data1 = pUtil.readDataFromPropertyFile("abcd");
		System.out.println(data);
		System.out.println(data1);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String value = eUtil.readDataFromExcelFile("Organisation", 1, 2);
		System.out.println(value);
		
		eUtil.writeDataInExcelFile("Organisation", 10, 4, value);
		System.out.println("data added");
		
		JavaUtility jUtil=new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		System.err.println(jUtil.getSystemDateFormat());
		
		
		
	}

}
