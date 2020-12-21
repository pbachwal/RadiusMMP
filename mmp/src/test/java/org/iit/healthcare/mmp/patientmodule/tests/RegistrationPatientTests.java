package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.mmp.patientmodule.pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationPatientTests extends TestBase
{
		
	RegistrationPage regPage;
	
	@Test
	public void validateRegisrtation() throws InterruptedException
	{
		
		instantiateDriver();
		regPage = new RegistrationPage(driver);
		regPage.clickOnRegisterBtn();
		regPage.enterRegistrationDetails();
		System.out.println("User got created successfully");
	}		
}
