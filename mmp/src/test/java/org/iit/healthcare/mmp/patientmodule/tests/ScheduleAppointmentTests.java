package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.patientmodule.pages.ScheduledAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBase
{
	@Test
	public void validateScheduledAppointment() throws InterruptedException
	{
		launchApplication(prop.getProperty("URL"));
		
		PatientLoginPage lPage = new PatientLoginPage(driver);
		lPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
		
		PatientHomePage hPage = new PatientHomePage(driver);
		
		boolean result = hPage.validatePatientPortalMessage();
		Assert.assertTrue(result);
		
		System.out.println("The assert 1 detailes :" + result);
		System.out.println("This line has been printed");
		
		hPage.navigationMenuItem("Schedule Appointment");
		
		ScheduledAppointmentPage schAppPage = new ScheduledAppointmentPage(driver);
		HashMap<String,String> appointmentDetailsHMap = schAppPage.bookAnAppointment("Dr.Becky");
		
		HashMap<String,String> homePageDetailsHMap = hPage.validateApptDetailsinHomePage();
		HashMap<String,String> x1 = new HashMap<String,String>();
		HashMap<String,String> x2 = new HashMap<String,String>();
		Assert.assertEquals(x1, x2);
		System.out.println("Assertion worked");
		
		Assert.assertEquals(appointmentDetailsHMap, homePageDetailsHMap);
		System.out.println("Assertion2 worked");
		
		hPage.navigationMenuItem("Schedule Appointment");
		//hPage.navigationMenuItem(tabName);
		
		HashMap<String,String> sPageHMap = schAppPage.validateAppDetailsinSpage();
		Assert.assertEquals(appointmentDetailsHMap, sPageHMap);
		System.out.println("Assertion3 worked");
	}
}



		