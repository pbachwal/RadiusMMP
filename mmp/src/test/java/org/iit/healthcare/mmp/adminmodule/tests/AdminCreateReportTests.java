package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.adminmodule.pages.AdminCreateReportsPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminSearchPatientsPage;
import org.iit.healthcare.mmp.adminmodule.pages.PatientAppPage;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCreateReportTests extends TestBaseClass {
	private AdminLoginPage adminLoginPage;
	private AdminHomePage adminHomePage;
	private AdminSearchPatientsPage patientsPage;
	private PatientAppPage fourButtonsPage;
	private AdminCreateReportsPage createReportsPage;
	private String uname = "mahi1";
	private String pword = "Mahi12345";
	private String menuItem = "Patients";
	private String btnName = "Reports";
	private String ssn = "987656789";
	private String patientFname = "Laya";
	private String reptName = "Bone report";
	private String reptDesc = "Bone fractured";
	private String fileName = System.getProperty("user.dir") + "\\mmpTestData\\\\Bone_report.txt";

	@BeforeClass()
	public void setUp() {
		launchApplication("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.login(uname, pword);
	}

	@Test(priority = 1)
	public void validateIfFeeIsAddedToPatientPortal() throws InterruptedException {
		adminHomePage = new AdminHomePage(driver);
		adminHomePage.navigationMenuItem(menuItem);
		patientsPage = new AdminSearchPatientsPage(driver);
		patientsPage.searchPatientBySsn(ssn);
		patientsPage.clickOnSearch();
		patientsPage.clickOnPatientRecord(patientFname);
		fourButtonsPage = new PatientAppPage(driver);
		fourButtonsPage.navigationToButton(btnName);
		createReportsPage = new AdminCreateReportsPage(driver);

		HashMap<String, String> expectedMap = createReportsPage.reportDetail(reptName, reptDesc, fileName);
		System.out.println("expectedMap:" + '\t' + expectedMap);
		HashMap<String, String> actualMap = new HashMap<String, String>();
		actualMap.put("Report name", expectedMap.get("Report name"));
		actualMap.put("File name", expectedMap.get("File name"));
		actualMap.put("Report desc", expectedMap.get("Report desc"));
		System.out.println("actualMap:" + '\t' + actualMap);
		Assert.assertEquals(actualMap, expectedMap);

	}
}
