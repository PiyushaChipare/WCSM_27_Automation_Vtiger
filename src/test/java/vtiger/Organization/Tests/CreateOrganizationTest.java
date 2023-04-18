package vtiger.Organization.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GeneralUtility.BaseClass;
import vtiger.ObjectRepository.CreateOrganizationsPage;
import vtiger.ObjectRepository.CreatedOrganizationsInfoPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GeneralUtility.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void createOrganizationTest() throws IOException 
	{
		//Step 1. Create objects of Generic Utilities

		String ORGNAME = eUtil.readDataFromExcelFile("Organisation", 1, 2)+jUtil.getRandomNumber();
		
		
		//Step 5: Navigate to organization link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsBtn().click();
		
		//Step 6: Click on create organization look up image 
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrganizationsBtn().click();
		
		//Step 7: Create organization with mandatory fields
		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
		cop.getOrganizationNameEdt().sendKeys(ORGNAME);
		
		//Step 8: Save
		cop.getSaveBtn().click();
				
		//Step 9: Validate for organization
		CreatedOrganizationsInfoPage coip=new CreatedOrganizationsInfoPage(driver);
		
		String orgHeader =coip.getCreatedOrganizationHeader().getText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
	}

}
