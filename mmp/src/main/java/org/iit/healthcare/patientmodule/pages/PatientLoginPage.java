package org.iit.healthcare.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientLoginPage 
{

	private final WebDriver driver;
	private By unameLocator = By.id("username");
	private By pwdLocator = By.id("password");
	private By submitLocator = By.name("submit");

	public PatientLoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void login(String uname, String pword) 
	{
		// login to patient portal application
		driver.findElement(unameLocator).sendKeys(uname);
		driver.findElement(pwdLocator).sendKeys(pword);
        driver.findElement(submitLocator).click();
	}

}
