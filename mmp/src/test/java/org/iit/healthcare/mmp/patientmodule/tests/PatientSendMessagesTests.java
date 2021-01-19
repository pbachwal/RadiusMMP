package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.helper.HelperClass;

import org.iit.healthcare.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.patientmodule.pages.PatientSendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSendMessagesTests extends TestBase{
	private String patLoginUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
	private String patUname = "Laya1";
	private String patPword = "Laya12345";
	private String subject = "Flu symptoms";
	private String message = "with headache";

	private String actualMsg;
	private String expectedMsg = "Messages Successfully sent.";

	private PatientLoginPage patLoginPage;
	private PatientHomePage patHomePage;
	private PatientSendMessagesPage patSendMsgPg;
	private HelperClass helperClass;

	@Test(priority = 1, enabled = true)
	public void validateSendMessageTest() throws InterruptedException {

		patLoginPage = new PatientLoginPage(driver);
		patHomePage = new PatientHomePage(driver);
		patSendMsgPg = new PatientSendMessagesPage(driver);
		launchApplication(prop.getProperty("URL"));
		patLoginPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
		helperClass = new HelperClass(driver);
		patSendMsgPg.retrieveFirstName();
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

}
