package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;
import java.util.Map;

import org.iit.healthcare.mmp.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminCreateFeePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminSearchPatientsPage;
import org.iit.healthcare.mmp.adminmodule.pages.PatientAppPage;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.FeesPage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.mmp.utility.AppLibrary;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCreateFeeTests extends TestBaseClass {
	private AdminLoginPage adminLoginPage;
	private AdminHomePage adminHomePage;
	private AdminSearchPatientsPage patientsPage;
	private PatientAppPage fourButtonsPage;
	private AdminCreateFeePage createFeePage;
	private PatientLoginPage patientLoginPage;
	private PatientHomePage patientHomePage;
	private FeesPage feesPage;
	private Map<String ,String> adminCredentialsMap;
	private Map<String ,String> patientCredentialsMap;
		
	@BeforeClass()
	public void setUp() {
		instantiateDriver();
		launchApplication("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		adminLoginPage = new AdminLoginPage(driver);	
		getAdminLoginCredentials();
		getPatientLoginCredentials();
		adminLoginPage.login( adminCredentialsMap.get("userName") , adminCredentialsMap.get("password"));
			
	}

	@Test(priority = 1)
	public void validateIfFeeIsAddedToPatientPortal() throws InterruptedException {
		adminHomePage = new AdminHomePage(driver);
		adminHomePage.navigationMenuItem("Patients");
		patientsPage = new AdminSearchPatientsPage(driver);
		patientsPage.searchPatientBySsn("987656789");
		patientsPage.clickOnSearch();
		patientsPage.clickOnPatientRecord("Laya");
		fourButtonsPage = new PatientAppPage(driver);		
		fourButtonsPage.navigationToButton("Create Fee");
		createFeePage = new AdminCreateFeePage(driver);
		createFeePage.selectService("blood work");
		Thread.sleep(3000);
		String expectedFee = createFeePage.getAdminCreatedFee();
		System.out.println("expectedFee:" + expectedFee);
		createFeePage.clickOnSubmit();
		createFeePage.handleAlert();
		adminHomePage.navigationMenuItem("Logout");
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		patientLoginPage = new PatientLoginPage(driver);
		patientLoginPage.login( patientCredentialsMap.get("userName") , patientCredentialsMap.get("password"));
		patientHomePage = new PatientHomePage(driver);
		patientHomePage.navigationMenuItem("Fees");
		feesPage = new FeesPage(driver);
		String actualBalance = feesPage.getPatientFeeBalance("$0");
		System.out.println("actualBalance:" + actualBalance);

		Assert.assertEquals(actualBalance, expectedFee);
	}
	
	private Map<String, String> getPatientLoginCredentials() {
		AppLibrary readExcel = new  AppLibrary("C:\\kalpana\\projects\\mmp\\mmpTestData\\mmpLogin.xlsx");				
		Object[][] patientCredentials = readExcel.getTestData("PatientCredentials");
		patientCredentialsMap = new HashMap<String,String>();
		patientCredentialsMap.put("userName" ,patientCredentials[0][0].toString() );
		patientCredentialsMap.put("password" ,patientCredentials[0][1].toString() );
		return patientCredentialsMap;
	}
	
	private Map<String, String> getAdminLoginCredentials() {
		AppLibrary readExcel = new  AppLibrary("C:\\kalpana\\projects\\mmp\\mmpTestData\\mmpLogin.xlsx");
		Object[][] adminCredentials = readExcel.getTestData("AdminCredentials");
     	adminCredentialsMap = new HashMap<String,String>();
		adminCredentialsMap.put("userName" ,adminCredentials[0][0].toString() );
		adminCredentialsMap.put("password" ,adminCredentials[0][1].toString() );
		return adminCredentialsMap;
	}
	
	

}
