package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.UpdatePatientProfilePage;

public class UpdatePatientProfilePageTest extends TestBase
{
	UpdatePatientProfilePage updateprofilepage;
	LoginPage lpage;
	HomePage hpage;
	
	@Test
	public void validateUpdateProfilePage() 
	{
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		LoginPage lPage = new LoginPage(driver);
		lPage.login("ria1", "Ria12345");
		
		HomePage hPage = new HomePage(driver);
		hPage.navigationMenuItem("Profile");
		
		
	}
	
}
