package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.healthcare.mmp.utility.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {
	WebDriver driver;
	HashMap<String,String> appointmentDetailsHMap = new HashMap<String,String>();
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HashMap<String, String> bookAnAppointment(String doctorName) throws InterruptedException
	{
		//Create new appointment
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();

		driver.findElement(By.xpath("//h4[contains(text(),'"+doctorName+"')]/ancestor::ul/following-sibling::button[@id='opener']")).click();
		String[] drName = doctorName.split("\\.");
		appointmentDetailsHMap.put("doctorName",drName[1]);

		//Switch to a frame
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).sendKeys(AppLibrary.selectFutureDate(10));
		appointmentDetailsHMap.put("dateofAppointment",AppLibrary.selectFutureDate(10));

		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByVisibleText("10Am");
		appointmentDetailsHMap.put("time","10Am");

		Thread.sleep(3000);

		driver.findElement(By.id("ChangeHeatName")).click();

		driver.findElement(By.id("sym")).sendKeys("Fever and Cold");
		appointmentDetailsHMap.put("sym","Fever and Cold");

		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		return appointmentDetailsHMap;
	}
	public HashMap<String, String> validateApptDetailsinSPage()
	{
		//a[contains(text(),'Time')] - time
		//a[contains(text(),'Provider')] - doctorName
		//a[contains(text(),'Symptoms')]- sym
		//div[@class='panel panel-info']//h3[@class='panel-title'] - 	dateofAppointment


		HashMap<String,String> sPageHMap = new HashMap<String,String>();
		sPageHMap.put("dateofAppointment",driver.findElement(By.xpath("//div[@class='panel panel-info']//h3[@class='panel-title']")).getText().trim());


		String timeWE = driver.findElement(By.xpath("//a[contains(text(),'Time')]")).getText();
		System.out.println("timeWE value ::: " + timeWE);
		String timeWEArr[] = timeWE.split(":");
		sPageHMap.put("time",timeWEArr[1].trim());

		String symWE= driver.findElement(By.xpath("//a[contains(text(),'Symptoms')]")).getText();
		String symWEArr[] = symWE.split(":");
		sPageHMap.put("sym",  symWEArr[1].trim());

		String doctorNameWE= driver.findElement(By.xpath("//a[contains(text(),'Provider')]")).getText();
		String doctorNameWEArr[] =doctorNameWE.split(":");
		sPageHMap.put("doctorName",doctorNameWEArr[1].trim() );
		return sPageHMap;
		
	}
}
