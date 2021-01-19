package org.iit.healthcare.patientmodule.pages;

import org.iit.healthcare.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.adminmodule.pages.AdminLoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientSendMessagesPage {
	private WebDriver driver;
	private By contactReason = By.xpath("//input[@id = 'subject']");
	private By enterMessage = By.id("message");
	private By sendBtn = By.xpath("//input[@value='Send']");
	By firstNameTB = By.id("fname");
	By editBtn = By.id("Ebtn");

	AdminLoginPage adminLoginPage;
	AdminHomePage adminHomePage;
    PatientHomePage patHomePage;

	public PatientSendMessagesPage(WebDriver driver) {
		this.driver = driver;
		patHomePage = new PatientHomePage(driver);

	}

	public void sendMessage(String subject, String message) {

		driver.findElement(contactReason).sendKeys(subject);
		driver.findElement(enterMessage).sendKeys(message);
		driver.findElement(sendBtn).click();
		System.out.println("Done entering message");

	}

	public String validateSendMessage() {

		System.out.println("Validating.....");
		String actualMsg = null;
		try {
			Alert alert = driver.switchTo().alert();
			actualMsg = alert.getText();
			alert.accept();
		} catch (Exception e) {
			System.out.println("Alert Not Present : " + e.getMessage());
		}
		return actualMsg;

	}

	public String retrieveFirstName() {

		patHomePage.navigationMenuItem("Profile");
		driver.findElement(editBtn).click();
		// String name = driver.findElement(firstNameTB).getText();
		String name = driver.findElement(firstNameTB).getAttribute("value");
		System.out.println("Patient first name:" + name);
		return name;

	}

}
