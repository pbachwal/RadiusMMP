package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
	public WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void navigationMenuItem(String tabName)
	{
		//Navigation to the module
		driver.findElement(By.xpath("//span[contains(text(), '"+tabName+"')]")).click();
	}
	
	public boolean validatePatientPortalMessage()
	{ 
		//Validation-1
		WebDriverWait wait = new WebDriverWait(driver,30);
		Boolean result = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3[@class='panel-title']"), "Patient Portal"));
		return result;
	}
	
	public HashMap<String, String> validateApptDetailsinHomePage()
	{
		HashMap<String, String> homePageDetailsHMap = new HashMap<String, String>();
		homePageDetailsHMap.put("dateofAppointment",driver.findElement(By.xpath("//table[@class='table']//tr[1]/td[1]")).getText());
		System.out.println("Appointment date is:" + driver.findElement(By.xpath("//table[@class='table']//tr[1]/td[1]")).getText());
	    homePageDetailsHMap.put("time",driver.findElement(By.xpath("//table[@class='table']//tr[1]/td[2]")).getText());
		homePageDetailsHMap.put("sym",driver.findElement(By.xpath("//table[@class='table']//tr[1]/td[3]")).getText());
		homePageDetailsHMap.put("doctorName",driver.findElement(By.xpath("//table[@class='table']//tr[1]/td[4]")).getText());
		System.out.println("Returning home details test map");
		return homePageDetailsHMap;
	}
}
