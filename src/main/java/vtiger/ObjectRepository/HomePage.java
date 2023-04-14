package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GeneralUtility.WebDriverUtility;

/**
 * This Class contains all web Elements on HomePage
 * @author Piyusha Chipare
 *
 */
public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsBtn;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement ProfileBtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutBtn;
	
	public WebElement getOrganizationsBtn() {
		return OrganizationsBtn;
	}

	public WebElement getContactsBtn() {
		return ContactsBtn;
	}

	public WebElement getProfileBtn() {
		return ProfileBtn;
	}

	public WebElement getSignoutBtn() {
		return SignoutBtn;
	}
	
	//Business Library
	public void SignoutFromApp(WebDriver driver) 
	{
		mouseHoverAction(driver, ProfileBtn);
		getSignoutBtn().click();
	}
	
	
}
