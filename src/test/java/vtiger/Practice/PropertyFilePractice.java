package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFilePractice {
public static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
		//1. load file in java using FileInputStream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//2. create properties object
		Properties pObj=new Properties();
		
		//3. load file into properties
		pObj.load(fis);
		
		//.4 read values using keys
		String browser = pObj.getProperty("browser");
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else
			driver=new FirefoxDriver();
		driver.get(pObj.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(pObj.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pObj.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		
	}

}
