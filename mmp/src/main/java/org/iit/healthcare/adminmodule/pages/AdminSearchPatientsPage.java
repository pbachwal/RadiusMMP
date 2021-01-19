package org.iit.healthcare.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSearchPatientsPage 
{
	private WebDriver driver;
	private By searchLocator = By.id("search");
	private By searchBtnLocator = By.xpath("//input[@value = 'search']");

	public AdminSearchPatientsPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void searchPatientBySsn(String ssn)
	{
		driver.findElement(searchLocator).sendKeys(ssn);

	}

	public void searchPatientByName(String fname) 
	{
		driver.findElement(searchLocator).sendKeys(fname);

	}

	public void clickOnSearch() 
	{
		driver.findElement(searchBtnLocator).click();
	}

	public AdminCreateFeePage clickOnPatientRecord(String name) 
	{
		driver.findElement(By.linkText(name)).click();
		return new AdminCreateFeePage(driver);
	}

	public HashMap<String, String> putPatientsInMap() 
	{
		HashMap<String, String> patientsPageDetailsHMap = new HashMap<String, String>();
		patientsPageDetailsHMap.put("Name",
				driver.findElement(By.xpath("//table[@style = 'width:100%']/thead/tr[1]/th[1]")).getText());
		patientsPageDetailsHMap.put("SSN",
				driver.findElement(By.xpath("//table[@style = 'width:100%']/thead/tr[1]/th[2]")).getText());
		patientsPageDetailsHMap.put("AGE",
				driver.findElement(By.xpath("//table[@style = 'width:100%']/thead/tr[1]/th[3]")).getText());

		return patientsPageDetailsHMap;

	}
}
