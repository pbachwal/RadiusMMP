package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.UpdatePatientProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePatientProfilePageTest extends TestBase
{
	UpdatePatientProfilePage updateprofilepage;
	LoginPage lPage;
	HomePage hPage;
	
	@Test
	public void validateUpdateProfilePage() 
	{
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		lPage = new LoginPage(driver);
		lPage.login("steven123", "Fa1r@point");
		
		hPage = new HomePage(driver);
		hPage.navigationMenuItem("Profile");
		
		updateprofilepage = new UpdatePatientProfilePage(driver);
		updateprofilepage.clickOnEditBtn();
		
		updateprofilepage.editFieldValues();
		String actual = updateprofilepage.clickOnSaveButton();
		String expected = "Your Profile has been updated.";
		
		Assert.assertEquals(actual, expected);
		System.out.println("User got updated successfully");
		
		updateprofilepage.tearDown();
	}
	
}
