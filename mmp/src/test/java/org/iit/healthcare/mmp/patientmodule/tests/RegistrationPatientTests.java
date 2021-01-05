package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.mmp.patientmodule.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPatientTests extends TestBase
{
		
	RegistrationPage regPage;
	
	@Test
	public void validateRegistration() throws InterruptedException
	{
	
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		regPage = new RegistrationPage(driver);
		regPage.clickOnRegisterBtn();
		regPage.enterRegistrationDetails();
		String actual = regPage.clickonSaveButton();
		String expected ="Thank you for registering with MMP. ";
		Assert.assertEquals(actual, expected);
		System.out.println("User got created successfully");
	}		
}
