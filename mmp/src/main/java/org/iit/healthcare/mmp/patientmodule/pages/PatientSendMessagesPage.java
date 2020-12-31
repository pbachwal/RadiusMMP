package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.healthcare.mmp.adminmodule.pages.AdminHomePage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.iit.healthcare.mmp.adminmodule.pages.AdminMessagesPage;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientSendMessagesPage extends TestBaseClass {
	private WebDriver driver;
	private By contactReason = By.xpath("//input[@id = 'subject']");
	private By enterMessage = By.id("message");
	private By sendBtn = By.xpath("//input[@value='Send']");
	By firstNameTB = By.id("fname");
	By editBtn = By.id("Ebtn");

	AdminLoginPage adminLoginPage;
	AdminHomePage adminHomePage;
	AdminMessagesPage adminObj;
	PatientHomePage patHomePage;

	public PatientSendMessagesPage(WebDriver driver) {
		this.driver = driver;
		patHomePage = new PatientHomePage(driver);
		adminLoginPage = new AdminLoginPage(driver);
		adminHomePage = new AdminHomePage(driver);
		adminObj = new AdminMessagesPage(driver);
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
		System.out.println("Patient first name:" +name);
		return name;

	}
	
	

	public boolean validatePatientMessageFromAdminModule(String adminLoginUrl, String uName, String password, 
			String name, String subject, String message) throws InterruptedException {

		boolean result = false;
		instantiateDriver();
		Thread.sleep(2000);
		launchApplication(adminLoginUrl);
		
        adminLoginPage.login(uName, password);
        adminHomePage.navigationMenuItem("Messages");

		HashMap<String, String> hMap = adminObj.retrieveRecentMessageDetails();
		if (hMap.get("Subject").equals(subject) && hMap.get("Description").equals(message)
				&& hMap.get("Name").equals(name)) {
			result = true;
			System.out.println("Passed");
		}
		System.out.println(hMap.get("Name") + " hMap******name " + name);
		System.out.println(hMap.get("Subject") + " hMap******subject " + subject);
		System.out.println(hMap.get("Description") + " hMap********message " + message);
		return result;
	}
}
