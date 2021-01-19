package org.iit.healthcare.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardInfoPage 
{
	private WebDriver driver;
	private By displayedAmountLocator = By.xpath("//p[contains(text(), '$11')]");
	public CardInfoPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	public String getDisplayedAmount() 
	{
		return driver.findElement(displayedAmountLocator).getText();
	}
}
