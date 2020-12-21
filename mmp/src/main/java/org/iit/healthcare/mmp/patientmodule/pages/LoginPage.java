package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void login(String uname, String pword)
	{
		/*login to patient portal application*/
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
	}	
}
