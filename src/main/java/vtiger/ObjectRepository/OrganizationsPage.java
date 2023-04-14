package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains of all web elements on Organizations Page
 * @author Piyusha Chipare
 *
 */
public class OrganizationsPage 
{
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationsBtn;
	
	public WebElement getCreateOrganizationsBtn() {
		return CreateOrganizationsBtn;
	}
	
	//Business Library
	public void clickOnCreateOrganizationsLookupIcon() 
	{
		getCreateOrganizationsBtn().click();
	}
	
}
