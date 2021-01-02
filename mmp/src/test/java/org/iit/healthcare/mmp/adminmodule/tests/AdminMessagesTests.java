package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminMessagesPage;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminMessagesTests extends TestBaseClass {
	private String admUrl = "http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
	private String admUname = "mahi1";
	private String admPword = "Mahi12345";
	private String tabName = "Messages";
	private String patFirstname = "Laya";
	private String subject = "Flu symptoms";
	private String message = "with headache";
	private AdminLoginPage adminLoginPage;
	private AdminHomePage adminHomePage;
	private AdminMessagesPage adminMessagesPage;

	@Test
	public void AdminModuleMessagesTests() throws InterruptedException {

		launchApplication(admUrl);
		adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.login(admUname, admPword);
		adminHomePage = new AdminHomePage(driver);
		adminHomePage.navigationMenuItem(tabName);
		adminMessagesPage = new AdminMessagesPage(driver);
		HashMap<String, String> mssgHmap = adminMessagesPage.retrieveRecentMessageDetails();
		Assert.assertTrue(
				adminMessagesPage.validatePatientMessageFromAdminModule(mssgHmap, patFirstname, subject, message));
	}

}
