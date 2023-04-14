package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains web elements in login page
 * @author Piyusha Chipare
 *
 */
public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement UsernameEdt;
		
	@FindBy(name = "user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;
	
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Layer-Generic method-Project Specific
	/**
	 * This method will login to Application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD) 
	{
		getUsernameEdt().sendKeys(USERNAME);
		getPasswordEdt().sendKeys(PASSWORD);
		getSubmitBtn().click();
	}
	
}
