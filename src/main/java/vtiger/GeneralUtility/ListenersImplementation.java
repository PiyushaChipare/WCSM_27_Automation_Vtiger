package vtiger.GeneralUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide implementation for ITestListeners Interface of TestNG
 * @author Piyusha Chipare
 *
 */
public class ListenersImplementation implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;

	public void onFinish(ITestContext context) 
	{
		System.out.println("=========Execution Completed=========");
		report.flush();//This will create the extent report
	}

	public void onStart(ITestContext context) 
	{
		System.out.println("=========Execution Started=========");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReoprt\\Report_"+new JavaUtility().getSystemDateFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Extent Report");
		htmlReport.config().setReportName("Automation Extent Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("Reporter Name", "Piyusha");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(result.getThrowable());//print the exception
		test.log(Status.FAIL, methodName+"Executation Failed");
		test.log(Status.INFO, result.getThrowable());
		
		String screenshotName = methodName+""+new JavaUtility().getSystemDateFormat();
		try 
		{
			String path = new WebDriverUtility().takeScreenShot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution SKIPPED");
		System.out.println(result.getThrowable());//print the exception
	}

	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution STARTED");
		test=report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution PASSED");
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.PASS, methodName+" Execution Passed");//It will print in report
	}
	
}
