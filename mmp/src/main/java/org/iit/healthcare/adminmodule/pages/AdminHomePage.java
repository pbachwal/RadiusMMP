package org.iit.healthcare.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHomePage 
{
	private final WebDriver driver;
	public AdminHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void navigationMenuItem(String tabName)
	{
		//Navigation to the module
		driver.findElement(By.xpath("//span[contains(text(), '"+tabName+"')]")).click();

	}
}
