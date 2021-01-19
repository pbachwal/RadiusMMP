package org.iit.healthcare.patientmodule.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PayNowPage 
{
	private WebDriver driver;
	private By selectAmountLocator = By.xpath("//select[@id = 'amount']");
	private By continueLocator = By.xpath("//input[@value = 'Continue']");

	public PayNowPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getSelectedAmounts() 
	{
		WebElement paymentElement = driver.findElement(selectAmountLocator);
		Select selectPayment = new Select(paymentElement);
		List<WebElement> paymentAmountElements = selectPayment.getOptions();

		List<String> paymentAmounts = null;
		if (!paymentAmountElements.isEmpty()) 
		{
			// logic
			paymentAmounts = convertToStringList(paymentAmountElements);

			selectPayment.selectByVisibleText(paymentAmounts.get(20));
			System.out.println("Expected fees amount at 20:" +paymentAmounts.get(20));
		}

		return paymentAmounts;

	}

	public CardInfoPage clickOnContinue() 
	{
		driver.findElement(continueLocator).click();
		return new CardInfoPage(driver);
	}

	private List<String> convertToStringList(List<WebElement> paymentAmountWebElements) 
	{
		List<String> paymentAmounts = new ArrayList<String>(paymentAmountWebElements.size());
		for (WebElement paymentElementAmount : paymentAmountWebElements) 
		{
			String payAmount = paymentElementAmount.getText();
			paymentAmounts.add(payAmount);
		}
		return paymentAmounts;
	}
}
