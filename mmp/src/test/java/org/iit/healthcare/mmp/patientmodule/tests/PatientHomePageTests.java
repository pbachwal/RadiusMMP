package org.iit.healthcare.mmp.patientmodule.tests;


import java.io.IOException;
import java.util.Properties;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.config.PropertiesFile;
import org.iit.healthcare.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.patientmodule.pages.PatientLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientHomePageTests extends TestBase 
{
	PatientLoginPage loginPage;
	PatientHomePage homePage;
	PropertiesFile propFile;
	Properties property;
	
	@BeforeClass
	public void setUp() throws IOException 
	{
		instantiateDriver();
		launchApplication(prop.getProperty("URL"));
	}

	@Test
	public void validateHomePage() throws IOException 
	{
		loginPage = new PatientLoginPage(driver);
		//loginPage.login(property.getProperty("patientUser", "patientUser");
		loginPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
		
		homePage = new PatientHomePage(driver);
		boolean expected = true;
		boolean actual = homePage.validatePatientPortalMessage();
		Assert.assertEquals(actual, expected);
		System.out.println("The assertion has passed");
		//homePage.navigationMenuItem("Messages");
	}
}
