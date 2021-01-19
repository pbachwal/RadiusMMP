package org.iit.healthcare.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCreateFeePage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	private By serviceLocator = By.xpath("//select[@id = 'service']");
	private By submitLocator = By.xpath("//input[@value= 'submit']");

	public AdminCreateFeePage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void navigationToButton(String btnName) 
	{
		driver.findElement(By.xpath("//input[@value = '" + btnName + "']")).click();

	}

	public void selectService(String serviceName) 
	{

		Select select = new Select(driver.findElement(serviceLocator));
		select.selectByVisibleText(serviceName);

	}

	public String getAdminCreatedFee() 
	{
		String fee = "";
		for (int i = 0; i < 5; i++) {
			try {
				// driver.navigate().refresh(); will clear all the above values and by default
				// fee is null
				fee = driver.findElement(By.xpath("//div[@id='show']/input")).getAttribute("value");
				System.out.println("Fee amount: " + fee);
				break;
			} catch (Exception e) {
				System.out.println("Trying to avoid the staleElementException " + e.getMessage());
			}
		}
		return fee;
	}

	public void clickOnSubmit() 
	{
		driver.findElement(submitLocator).click();
	}

	public void handleAlert() 
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
