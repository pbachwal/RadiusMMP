package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduledAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBase
{
	@Test
	public void validateScheduledAppointment() throws InterruptedException
	{
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		LoginPage lPage = new LoginPage(driver);
		lPage.login("ria1", "Ria12345");
		
		HomePage hPage = new HomePage(driver);
		
		boolean result = hPage.validatePatientPortalMessage();
		Assert.assertTrue(result);
		System.out.println("The assert 1 detailes :" + result);
		System.out.println("This line has been printed");
		
		hPage.navigationMenuItem("Schedule Appointment");
		
		ScheduledAppointmentPage schAppPage = new ScheduledAppointmentPage(driver);
		HashMap<String,String> appointmentDetailsHMap = schAppPage.bookAnAppointment("Dr.Beth");
		
		HashMap<String,String> homePageDetailsHMap = hPage.validateApptDetailsinHomePage();
		HashMap<String,String> x1 = new HashMap<String,String>();
		HashMap<String,String> x2 = new HashMap<String,String>();
		Assert.assertEquals(x1, x2);
		System.out.println("Assertion worked");
		
		Assert.assertEquals(appointmentDetailsHMap, homePageDetailsHMap);
		System.out.println("Assertion2 worked");
		
		hPage.navigationMenuItem("Schedule Appointment");
				
		HashMap<String,String> sPageHMap = schAppPage.validateAppDetailsinSpage();
		Assert.assertEquals(appointmentDetailsHMap, sPageHMap);
		System.out.println("Assertion3 worked");
	}
}