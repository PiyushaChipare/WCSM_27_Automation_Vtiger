package vtiger.GeneralUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class gives implementation for IRetryAnalyser Interface of TestNG
 * @author Piyusha Chipare
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer 
{

	public boolean retry(ITestResult result) 
	{
		int count=0;
		int retryCount=4;
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
