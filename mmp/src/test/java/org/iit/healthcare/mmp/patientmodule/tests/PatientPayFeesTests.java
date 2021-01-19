package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.List;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.patientmodule.pages.CardInfoPage;
import org.iit.healthcare.patientmodule.pages.FeesPage;
import org.iit.healthcare.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.patientmodule.pages.PayNowPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientPayFeesTests extends TestBase 
{

	private PatientLoginPage loginPage;
	private PatientHomePage homePage;
	private FeesPage feesPage;
	private PayNowPage payNowPage;
	private CardInfoPage cardInfoPage;

	@Test(priority = 1)
	public void verifyAmountDisplayedOnCardDetailsPage() 
	{
		launchApplication(prop.getProperty("URL"));
		loginPage = new PatientLoginPage(driver);
		loginPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
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
