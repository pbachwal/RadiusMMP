package org.iit.healthcare.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminCreateReportsPage 
{
	public WebDriver driver;
	//By selectAppointment = By.xpath("//select[@name='app_date']");
	By reportName = By.xpath("//input[@id='exampleInputcardnumber1']");
	By chooseFile = By.xpath("//input[@id='file']");
	By reportDesc = By.xpath("//textarea[@name = 'report_desc']");
	By submit = By.xpath("//input[@type='submit']");

	public AdminCreateReportsPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	/* Report details returning boolean */
	public boolean reportDetails(String reptName, String reptDesc, String fileName) 
	{

		/*WebElement we2 = driver.findElement(selectAppointment);
		Select selectAppt = new Select(we2);
		selectAppt.selectByIndex(1);*/

		driver.findElement(reportName).sendKeys(reptName);

		driver.findElement(chooseFile).sendKeys(fileName);

		driver.findElement(reportDesc).sendKeys(reptDesc);

		driver.findElement(submit).click();
		return true;

	}

	/* Report details returning HashMap */
	public HashMap<String, String> reportDetail(String reptName, String reptDesc, String fileName)
			throws InterruptedException {

		HashMap<String, String> hMap = new HashMap<String, String>();

		/*WebElement we2 = driver.findElement(selectAppointment);
		Select selectAppt = new Select(we2);
		selectAppt.selectByIndex(1);*/

		driver.findElement(reportName).sendKeys(reptName);
		hMap.put("Report name", reptName);

		driver.findElement(chooseFile).sendKeys(fileName);
		hMap.put("File name", fileName);

		driver.findElement(reportDesc).sendKeys(reptDesc);
		hMap.put("Report desc", reptDesc);

		driver.findElement(submit).click();

		return hMap;

	}

}
