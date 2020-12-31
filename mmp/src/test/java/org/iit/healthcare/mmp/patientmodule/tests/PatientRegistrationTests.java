package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientRegistrationTests extends TestBaseClass {
	PatientRegistrationPage patRegPage;

	@Test(description = "US_001 Registration of the Page", groups = { "US_001", "regression", "sanity",
			"patientmodule" })
	public void validateRegistration() throws Exception {
		instantiateDriver();
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

		patRegPage = new PatientRegistrationPage(driver);
		patRegPage.clickRegisterButton();
		patRegPage.fillData();
		String actual = patRegPage.readSuccessMessage();
		String expected = "Thank you for registering with MMP. ";
		Assert.assertEquals(actual, expected);
	}
}
