package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyserPractice 
{
	@Test(retryAnalyzer = vtiger.GeneralUtility.RetryAnalyserImplementation.class)
	public void retryAnalyserPractice() 
	{
		Assert.fail();
		System.out.println("Hi");
	}
}
