package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoScript 
{
	public static void main(String[] args) throws IOException 
	{
		//Step 1. Read all necessary data 
		/*Read necessary data from property file*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		System.out.println(URL);
		
		Random r=new Random();
		int value=r.nextInt(1000);
		
		/*Read necessary data from property file*/
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData0.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organisation").getRow(4).getCell(2).getStringCellValue()+value;
		
		
		WebDriver driver=null;
		//Step 2: Launch browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?module=Leads&action=index");
		
		
		//Step 3: Log in to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: Click on create organization look up image 
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Step 8: Validate for organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(orgHeader.contains(ORGNAME))
			{
				System.out.println("Pass");
			}
			else
				System.out.println("Fail");
				
		//Step 9: Logout of app
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successfull");
		
		
	}
}
