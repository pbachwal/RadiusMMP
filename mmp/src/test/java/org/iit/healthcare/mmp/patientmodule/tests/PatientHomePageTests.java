package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientHomePageTests extends TestBaseClass {
	PatientLoginPage loginPage;
	PatientHomePage homePage;
	
	@BeforeClass
	public void setUp() {
		instantiateDriver();
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	}

	@Test
	public void validateHomePage() {
		loginPage = new PatientLoginPage(driver);
		loginPage.login("ria1", "Ria12345");
		homePage = new PatientHomePage(driver);
		boolean expected = true;
		boolean actual = homePage.validatePatientPortalMessage();
		Assert.assertEquals(actual, expected);
		//homePage.navigationMenuItem("Messages");
	}
}
