package vtiger.Contacts.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GeneralUtility.BaseClass;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.CreateOrganizationsPage;
import vtiger.ObjectRepository.CreatedContactInfoPage;
import vtiger.ObjectRepository.CreatedOrganizationsInfoPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException 
	{
		//Step 2: Read all necessary data
		String LASTNAME = eUtil.readDataFromExcelFile("Contact", 4, 2);
		String ORGNAME = eUtil.readDataFromExcelFile("Contact", 4, 3)+jUtil.getRandomNumber();
		
		//Step 5: Navigate to Organizations page
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsBtn().click();
		
		//Step 6: Click on create Organization look up image 
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrganizationsBtn().click();
		//Step 7: Create Organization
		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
		cop.createOrganization(ORGNAME);
							
		//Step 8: Validate for organization
		CreatedOrganizationsInfoPage coip=new CreatedOrganizationsInfoPage(driver);
		String orgHeader = coip.getCreatedOrganizationHeader().getText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
					
		//Step 9: Create Contact with organization name
		hp.getContactsBtn().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactsLookupIcon();
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createContactWithOrganization(driver, LASTNAME, ORGNAME);
		
		CreatedContactInfoPage ccip=new CreatedContactInfoPage(driver);
		String contactHeader = ccip.getCreatedContactsHeader().getText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
	}

	@Test
	public void demo()
	{
		System.out.println("Demo done");
	}
}
