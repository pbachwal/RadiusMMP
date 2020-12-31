package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeesPage {
	private WebDriver driver;
	private By payNowLocator = By.xpath("//button[contains(text(), 'Pay Now')]");

	public FeesPage(WebDriver driver) {
		this.driver = driver;
	}

	public PayNowPage clickOnPayNowBtn() {
		driver.findElement(payNowLocator).click();
		return new PayNowPage(driver);
	}
	
	public String getPatientFeeBalance(String balance) {
		return driver.findElement(By.xpath("//p[contains(text(), '"+ balance +"')]")).getText();
	}
}
