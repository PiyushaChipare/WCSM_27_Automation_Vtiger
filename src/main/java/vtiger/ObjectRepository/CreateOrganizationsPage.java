package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GeneralUtility.WebDriverUtility;

public class CreateOrganizationsPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateOrganizationsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name = "accountname")
	private WebElement OrganizationNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropdown;
	
	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}

	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	public void createOrganization(String ORGNAME) 
	{
		getOrganizationNameEdt().sendKeys(ORGNAME);
		getSaveBtn().click();		
	}
	
	public void createOrganizationWithIndustryType(String ORGNAME,String INDUSTRY_TYPE) 
	{
		getOrganizationNameEdt().sendKeys(ORGNAME);
		handleDropdown(IndustryDropdown, INDUSTRY_TYPE);
		getSaveBtn().click();
	}
}
