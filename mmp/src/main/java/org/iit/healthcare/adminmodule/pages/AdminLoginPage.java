package org.iit.healthcare.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage 
{
	private final WebDriver driver;
	private By unameLocator = By.xpath("//input[@id = 'username']");
	private By pwdLocator = By.xpath("//input[@id = 'password']");
	private By submitLocator = By.name("admin");

	public AdminLoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void login(String uname, String pword) 
	{
		// login
		driver.findElement(unameLocator).sendKeys(uname);
		driver.findElement(pwdLocator).sendKeys(pword);
		driver.findElement(submitLocator).click();

	}
}
