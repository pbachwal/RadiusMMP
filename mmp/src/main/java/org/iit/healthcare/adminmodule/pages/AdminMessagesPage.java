package org.iit.healthcare.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminMessagesPage 
{
	private WebDriver driver;
	private String name, subject, description;
	private HashMap<String, String> hMap;
	private By patientName = By.xpath("//table[@class='table']//tr[2]/td[1]");
	private By subjectMessage = By.xpath("//table[@class='table']//tr[2]/td[2]");
	private By descriptionMessage = By.xpath("//table[@class='table']//tr[3]/td[2]");

	public AdminMessagesPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public HashMap<String, String> retrieveRecentMessageDetails() 
	{

		name = driver.findElement(patientName).getText();
		subject = driver.findElement(subjectMessage).getText();
		description = driver.findElement(descriptionMessage).getText();
		hMap = new HashMap<String, String>();
		hMap.put("Name", name);
		hMap.put("Subject", subject);
		hMap.put("Description", description);
		System.out.println(driver.findElement(patientName).getText());
		System.out.println(driver.findElement(subjectMessage).getText());
		System.out.println(driver.findElement(descriptionMessage).getText());
		return hMap;

	}

	public boolean validatePatientMessageFromAdminModule(HashMap<String, String> hMap, String name, String subject,
			String description) {

		boolean result = false;
		if (hMap.get("Subject").equals(subject) && hMap.get("Description").equals(description)
				&& hMap.get("Name").equals(name)) {

			System.out.println("Passed");
			result = true;

		}
		return result;
	}
	
}
