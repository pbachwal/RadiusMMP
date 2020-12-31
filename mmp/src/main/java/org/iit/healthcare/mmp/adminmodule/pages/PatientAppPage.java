package org.iit.healthcare.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientAppPage {
	private WebDriver driver;

	public PatientAppPage(WebDriver driver) {
		this.driver = driver;
	}
	public void navigationToButton(String btnName) {
		driver.findElement(By.xpath("//input[@value = '" + btnName + "']")).click();

	}
	
}
