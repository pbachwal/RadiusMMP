package org.iit.healthcare.mmp.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	WebDriver driver;

	public HelperClass(WebDriver driver) {

		this.driver = driver;

	}

	public WebDriver switchToAFrameAvailable(String frameId, int timeinSecs) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		return driver;
	}
	
	public void switchToSideBar(){
		
		driver.findElement(By.xpath("//div[@class='left-sidebar']")).click();
	}

}
