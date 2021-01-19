package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.patientmodule.pages.PatientRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientRegistrationTests extends TestBase
{
		
	PatientRegistrationPage regPage;
		
	@Test
	public void validateRegistration() throws InterruptedException
	{
	
		launchApplication(prop.getProperty("URL"));
		regPage = new PatientRegistrationPage(driver);
		regPage.clickOnRegisterBtn();
		regPage.enterRegistrationDetails();
		String actual = regPage.clickonSaveButton();
		//String actual = patRegPage.readSuccessMessage();
		String expected ="Thank you for registering with MMP. ";
		Assert.assertEquals(actual, expected);
		System.out.println("User got created successfully");
	}		
}
