package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedOrganizationsInfoPage 
{
	WebDriver driver;

	public CreatedOrganizationsInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CreatedOrganizationHeader;

	public WebElement getCreatedOrganizationHeader() {
		return CreatedOrganizationHeader;
	}
	
	//Business Library
	public void verifyCreatedOrganization(String ORGNAME) 
	{
		if(getCreatedOrganizationHeader().getText().contains(ORGNAME))
		{System.out.println("Pass");}
		else
			System.out.println("Fail");
	}

}
