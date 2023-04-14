package vtiger.GeneralUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all generic methods related to webdriver actions
 * @author Piyusha Chipare
 *
 */
public class WebDriverUtility 
{

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	 
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait 20 seconds for page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait until particular element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until particular WebElement is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	//DROPDOWN METHODS
	
	/**
	 * This method handle dropdown option using Index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) 
	{
		Select dropdown=new Select(element);
		dropdown.selectByIndex(index);
	}
	
	/**
	 * This method handle dropdown option using Value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value) 
	{
		Select dropdown=new Select(element);
		dropdown.selectByValue(value);
	}
	
	/**
	 * This method handle dropdown option using Visible Text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropdown(String visibleText,WebElement element) 
	{
		Select dropdown=new Select(element);
		dropdown.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to get all options in dropdown
	 * @param element
	 * @return
	 */
	public List<WebElement> getDropdownOption(WebElement element) 
	{
		Select dropdown=new Select(element);
		return dropdown.getOptions();
	}
	
	/**
	 * This method is used to get the WebElement of selected option from dropdown
	 * @param element
	 * @return
	 */
	public List<WebElement> getSelectedDropdown(WebElement element) 
	{
		Select dropdown=new Select(element);
		return dropdown.getAllSelectedOptions();
	}
	
	//ACTIONS METHODS
	/**
	 * This method will perform hover action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used to click on current mouse pointer location on webpage	
	 * @param driver
	 */
	public void clickAction(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.click().perform();
	}
	
	/**
	 * This method is used to click on WebElement
	 * @param driver
	 */
	public void clickAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	
	/**
	 * This method will perform right click on current mouse pointer position of Webpage
	 * @param driver
	 */
	public void righClickAction(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on target WebElement
	 * @param driver
	 * @param targetEle
	 */
	public void righClickAction(WebDriver driver,WebElement targetEle) 
	{
		Actions act=new Actions(driver);
		act.contextClick(targetEle).perform();
	}
	
	/**
	 * This method will perform double click action on specified WebElement
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action from one element to another
	 * @param driver
	 * @param srcEle
	 * @param targetEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement targetEle)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle, targetEle).perform();		
	}
	
	/**
	 * This method will press ENTER key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException 
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will release ENTER key
	 * @throws AWTException
	 */
	public void releaseEnterKey() throws AWTException 
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
		
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will return the text of alert popup
	 * @param driver
	 * @return alertText
	 */
	public String getAlertText(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * This method will switch frame by given frame index
	 * @param driver
	 * @param index
	 */
	
	//FRAME METHODS
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch frame by given frame name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId) 
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will switch frame by given frame WebElement
	 * @param driver
	 * @param targetEle
	 */
	public void handleFrame(WebDriver driver,WebElement targetEle)
	{
		driver.switchTo().frame(targetEle);
	}
	
	/**
	 * This method will switch frame to immediate parent
	 * @param driver
	 */
	public void handleParentFrame(WebDriver driver) 
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch frame to default frame
	 * @param driver
	 */
	public void handleDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will take screenshot and save it in folder
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenshotname) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotname+".png");
		FileUtils.copyFile(src, dst);//commons-io dependency
		
		return dst.getAbsolutePath();//used in extent reports
	}
		
	/**
	 * This method will switch window based on partial window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		//Step 1. Capture all window IDs
		Set<String> windowID = driver.getWindowHandles();
		
		//Step 2. Use for each loop and navigate through each window
		for(String win:windowID)
		{
			//Step 3. capture the title for each window
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			//Step 4. Compare currentTitle with partialWindowTitle
			if(currentTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will scroll down randomly
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0,500)" , "");
	}
	
	/**
	 * This method will scroll down until particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("windows.scrollBy(0,"+y+")" , element);
	}
}
