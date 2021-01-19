package org.iit.healthcare.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeesPage 
{
	private WebDriver driver;
	private By payNowLocator = By.xpath("//button[contains(text(), 'Pay Now')]");

	public FeesPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public PayNowPage clickOnPayNowBtn() 
	{
		driver.findElement(payNowLocator).click();
		return new PayNowPage(driver);
	}
	
	public boolean getPatientFeeBalance(String balance) 
	{
		boolean feeBal = false;
		String actualBal = driver.findElement(By.xpath("//p[contains(text(), '"+ balance +"')]")).getText();
		System.out.println("Actual balance:" +actualBal);
		return feeBal;
	}
}
