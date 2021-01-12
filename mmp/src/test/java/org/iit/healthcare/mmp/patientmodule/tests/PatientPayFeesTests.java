package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.List;

import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.CardInfoPage;
import org.iit.healthcare.mmp.patientmodule.pages.FeesPage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.PayNowPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientPayFeesTests extends TestBaseClass {

	private PatientLoginPage loginPage;
	private PatientHomePage homePage;
	private FeesPage feesPage;
	private PayNowPage payNowPage;
	private CardInfoPage cardInfoPage;

	@Test(priority = 1)
	public void verifyAmountDisplayedOnCardDetailsPage() {
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		loginPage = new PatientLoginPage(driver);
		loginPage.login("ria1", "Ria12345");
		homePage = new PatientHomePage(driver);
		homePage.navigationMenuItem("Fees");
		feesPage = new FeesPage(driver);
		feesPage.clickOnPayNowBtn();
		payNowPage = new PayNowPage(driver);
		List<String> expectedPaymentAmounts = payNowPage.getSelectedAmounts();
		payNowPage.clickOnContinue();
		cardInfoPage = new CardInfoPage(driver);
		String actualPaymentAmount = cardInfoPage.getDisplayedAmount();
		System.out.println("ActualPaymentAmount:" + actualPaymentAmount);
		Assert.assertTrue(expectedPaymentAmounts.contains((actualPaymentAmount)));
	}

}
