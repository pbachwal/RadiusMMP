package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminMessagesPage;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientSendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSendMessagesTests extends TestBaseClass {
	private String patLoginUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
	private String patUname = "Laya1";
	private String patPword = "Laya12345";
	private String subject = "Flu symptoms";
	private String message = "with headache";

	private String adminLoginUrl = "http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
	private String admUname = "mahi1";
	private String admPword = "Mahi12345";
	private String patFirstname = "Laya";
	private String actualMsg;
	private String expectedMsg = "Messages Successfully sent.";

	private PatientLoginPage patLoginPage;
	private PatientHomePage patHomePage;
	private PatientSendMessagesPage patSendMsgPg;
	private AdminMessagesPage adminMessagesPage;
	private AdminLoginPage adminLoginPage;
	private AdminHomePage adminHomePage;
	private HelperClass helperClass;

	@Test(priority = 1, enabled = false)
	public void validateSendMessageTest() throws InterruptedException {

		instantiateDriver();
		patLoginPage = new PatientLoginPage(driver);
		patHomePage = new PatientHomePage(driver);
		patSendMsgPg = new PatientSendMessagesPage(driver);
		launchApplication(patLoginUrl);
		patLoginPage.login(patUname, patPword);
		helperClass = new HelperClass(driver);
		patFirstname = patSendMsgPg.retrieveFirstName();
		Thread.sleep(3000);
		helperClass.switchToSideBar();
		Thread.sleep(3000);
		patHomePage.navigationMenuItem("Messages");
		Thread.sleep(3000);
		patSendMsgPg.sendMessage(subject, message);
		Thread.sleep(3000);
		actualMsg = patSendMsgPg.validateSendMessage();
		System.out.println("actualMsg" + actualMsg);

		Assert.assertEquals(actualMsg, expectedMsg);

	}

	@Test(priority = 2)
	public void validatePatientMessageFromAdminModuleTest() throws InterruptedException {

		instantiateDriver();

		
		launchApplication(adminLoginUrl);
		adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.login(admUname, admPword);

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.navigationMenuItem("Messages");
		adminMessagesPage = new AdminMessagesPage(driver);
		HashMap<String, String> hMap = adminMessagesPage.retrieveRecentMessageDetails();
		if (hMap.get("Subject").equals(subject) && hMap.get("Description").equals(message)
				&& hMap.get("Name").equals(patFirstname)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority = 3)
	public void test() throws InterruptedException {
		
		patSendMsgPg = new PatientSendMessagesPage(driver);
		patSendMsgPg.validatePatientMessageFromAdminModule(adminLoginUrl, admUname, admPword, patFirstname, subject, message);
	}


}
