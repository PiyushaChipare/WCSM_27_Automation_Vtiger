package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedContactInfoPage 
{
	WebDriver driver;

	public CreatedContactInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CreatedContactsHeader;

	public WebElement getCreatedContactsHeader() {
		return CreatedContactsHeader;
	}
	
	
}
