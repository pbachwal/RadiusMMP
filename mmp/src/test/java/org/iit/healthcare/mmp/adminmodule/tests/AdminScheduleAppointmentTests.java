package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;
import java.util.Map.Entry;
import org.iit.healthcare.mmp.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminScheduleAppointmentpage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminCreateFeePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminSearchPatientsPage;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminScheduleAppointmentTests extends TestBaseClass {
	private AdminLoginPage admLoginPage;
	private AdminHomePage admHomePage;
	private AdminSearchPatientsPage searPatPage;
	private AdminCreateFeePage patAppPage;
	private AdminScheduleAppointmentpage admSchAppPage;
	private PatientLoginPage patLoginPage;
	private PatientHomePage patHomepage;
	private String admUrl = "http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
	private String admUname = "mahi1";
	private String admPassword = "Mahi12345";
	private String tabName = "Patients";
	private String ssn = "987656789";
	private String name = "Laya";
	private String btnName = "Create Visit";
	private String doctorName = "Smith";
	private String tabName1 = "Logout";
	private String patUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
	private String patUname = "laya1";
	private String patPassword = "Laya12345";
	/*
	 * @BeforeClass public void setUp() { instantiateDriver();
	 * launchApplication(admUrl); admLoginPage = new AdminLoginPage(driver);
	 * admLoginPage.login(admUname, admPassword);
	 * 
	 * }
	 */

	@Test
	public void validateAppointmentDetails() throws InterruptedException {
		instantiateDriver();
		launchApplication(admUrl);
		admLoginPage = new AdminLoginPage(driver);
		admLoginPage.login(admUname, admPassword);

		admHomePage = new AdminHomePage(driver);
		admHomePage.navigationMenuItem(tabName);
		searPatPage = new AdminSearchPatientsPage(driver);
		searPatPage.searchPatientBySsn(ssn);
		searPatPage.clickOnSearch();
		searPatPage.clickOnPatientRecord(name);
		patAppPage = new AdminCreateFeePage(driver);
		patAppPage.navigationToButton(btnName);
		admSchAppPage = new AdminScheduleAppointmentpage(driver);
		HashMap<String, String> expectedMap = admSchAppPage.scheduleAppointment(doctorName);
		System.out.println("Expected:" + expectedMap);
		admHomePage.navigationMenuItem(tabName1);
		launchApplication(patUrl);
		patLoginPage = new PatientLoginPage(driver);
		patLoginPage.login(patUname, patPassword);
		patHomepage = new PatientHomePage(driver);
		HashMap<String, String> actualMap = patHomepage.validateApptDetailsinHomePage();
		System.out.println("Actual:" + actualMap);
		System.out.println("Getactual:" + actualMap.get("symptoms"));
		System.out.println("GetExpected:" + expectedMap.get("symptoms"));
		Assert.assertEquals(actualMap.get("symptoms"), expectedMap.get("symptoms"));

		String actual = null;
		String expected = null;
		for (Entry<String, String> a : actualMap.entrySet()) {
			System.out.println("Actual key:" +a.getKey());
			System.out.println("Actual value:" +a.getValue());
			actual = a.getValue();
			
		}

		for (Entry<String, String> e : expectedMap.entrySet()) {
			System.out.println("Expected key:" +e.getKey());
			System.out.println("Expected value:" +e.getValue());
			expected = e.getValue();
		}

		Assert.assertEquals(actual, expected);

		/*
		 * Set<String> keys = actualMap.keySet();
		 * 
		 * for (String key : keys) {
		 * 
		 * Assert.assertEquals(expectedMap.get(key), actualMap.get(key));
		 * 
		 * }
		 */

	}

}
