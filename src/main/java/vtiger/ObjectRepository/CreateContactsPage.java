package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GeneralUtility.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility
{
	WebDriver driver;

	public CreateContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement OrganizationLookupBtn;
	
	@FindBy(id = "search_txt")
	private WebElement SearchEdt;
		
	@FindBy(name = "search")	
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrganizationLookupBtn() {
		return OrganizationLookupBtn;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Layer
	public void createContact(WebDriver driver,String LASTNAME)
	{
		getLastNameEdt().sendKeys(LASTNAME);
		getSaveBtn().click();
	}
	
	public void createContactWithOrganization(WebDriver driver,String LASTNAME,String ORGNAME) 
	{
		getLastNameEdt().sendKeys(LASTNAME);
		getOrganizationLookupBtn().click();
		switchToWindow(driver, "Accounts");
		getSearchEdt().sendKeys(ORGNAME);
		getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		getSaveBtn().click();
	}
	
	
}
