package org.iit.healthcare.mmp.adminmodule.pages;

import java.util.HashMap;

import org.iit.healthcare.mmp.helper.HelperClass;
import org.iit.healthcare.mmp.utility.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminScheduleAppointmentpage {
	private WebDriver driver;
	HelperClass helperObj;
	AppLibrary utilityObj;

	private By datepicker = By.xpath("//input[@id='datepicker']");
	private By appoitmentTime = By.id("time");
	private By continueB = By.id("ChangeHeatName");
	private By sForm = By.name("sym");
	private By sySumbit = By.xpath("//input[@value='Submit']");
	private By anyPlace = By.xpath("//body");

	public AdminScheduleAppointmentpage(WebDriver driver) {
		this.driver = driver;
		helperObj = new HelperClass(driver);
	}

	// create visit schedule appointment
	public HashMap<String, String> scheduleAppointment(String doctorName) throws InterruptedException {
		HashMap<String, String> hMap = new HashMap<String, String>();
		driver.findElement(By.xpath("//h4[contains(text(),'" + doctorName + "')]/ancestor::td/button[@id='opener']"))
				.click();
		driver = helperObj.switchToAFrameAvailable("myframe", 20);
		String dateOfAppointment = AppLibrary.selectFutureDate(10);
		driver.findElement(datepicker).sendKeys(dateOfAppointment);
		String time = "10Am";
		new Select(driver.findElement(appoitmentTime)).selectByVisibleText(time);
		driver.findElement(anyPlace).click();
		// Thread.sleep(2000);
		driver.findElement(continueB).click();
		String symptoms = "Fever";
		Thread.sleep(2000);
		driver.findElement(sForm).clear();
		driver.findElement(sForm).sendKeys(symptoms);
		hMap.put("doctorName", doctorName);
		hMap.put("dateOfAppointment", dateOfAppointment);
		hMap.put("time", time);
		hMap.put("symptoms", symptoms);
		driver.findElement(sySumbit).click();

		return hMap;
	}

}
