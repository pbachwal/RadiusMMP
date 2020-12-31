package org.iit.healthcare.mmp.patientmodule.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.iit.healthcare.mmp.utility.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientRegistrationPage {
	private WebDriver driver;
	Random rand = new Random();
	private HashMap<String, String> hMap = new HashMap<String, String>();
	WebDriverWait wait;
	int noOfChars = 5;
	int noOfDigitsZip = 5;
	int noOfDigitsAge = 2;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerBtn;
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@name='dob']")
	WebElement dob;
	@FindBy(xpath = "//input[@id='license']")
	WebElement licence;
	@FindBy(xpath = "//input[@id='ssn']")
	WebElement ssn;
	@FindBy(xpath = "//input[@id='state']")
	WebElement state;
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	@FindBy(xpath = "//input[@id='address']")
	WebElement address;
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcode;
	@FindBy(xpath = "//input[@id='age']")
	WebElement age;
	@FindBy(xpath = "//input[@id='height']")
	WebElement height;
	@FindBy(xpath = "//input[@id='weight']")
	WebElement weight;
	@FindBy(xpath = "//input[@id='pharmacy']")
	WebElement pharmacy;
	@FindBy(xpath = "//input[@id='pharma_adress']")
	WebElement pharmacyAddress;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='confirmpassword']")
	WebElement confirmPassword;
	@FindBy(xpath = "//select[@id='security']")
	WebElement security;
	@FindBy(xpath = "//input[@id='answer']")
	WebElement answer;
	@FindBy(xpath = "//input[@name='register']")
	WebElement saveBtn;

	// Constructor - Initializing the elements
	/*
	 * public PatientRegistrationPage() { PageFactory.initElements(driver, this); }
	 */

	public PatientRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Methods

	public void clickRegisterButton() {
		registerBtn.click();
	}

	public void enterFirstName() {
		String firstNameValue = "AUTFName" + AppLibrary.getRandomString(noOfChars);
		firstname.sendKeys(firstNameValue);
		hMap.put("FirstName", firstNameValue);
	}

	public void enterLastName() {
		String lastNameValue = "AUTLName" + AppLibrary.getRandomString(noOfChars);
		lastname.sendKeys(lastNameValue);
		hMap.put("LastName", lastNameValue);
	}

	public void enterDateOfBirth() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String datePickerValue = sdf.format(d);
		dob.sendKeys(datePickerValue);
		hMap.put("DatePicker", datePickerValue);
	}

	public void enterLicense() {
		// String licenseValue = 99999+ rand.nextInt(1000)+"";
		String licenseValue = AppLibrary.generateRandom(2, 100);
		System.out.println("licenseValue:" + licenseValue);
		licence.sendKeys(licenseValue);
		hMap.put("License", licenseValue);

	}

	public void enterSSN() {
		String ssnValue = Calendar.getInstance().getTimeInMillis() % 1000000000 + "";
		ssn.sendKeys(ssnValue);
		hMap.put("SSN", ssnValue);
	}

	public void enterState() {

		String stateValue = AppLibrary.getRandomState();
		state.sendKeys(stateValue);
		hMap.put("State", stateValue);

	}

	public void enterCity() {
		String cityValue = "Chicago";
		city.sendKeys(cityValue);
		hMap.put("City", cityValue);
	}

	public void enterAddressValue() {

		String addressValue = "9 Street";
		address.sendKeys(addressValue);
		hMap.put("Address", addressValue);
	}

	public void enterZipCodeValue() {

		String zipCodeValue = AppLibrary.getRandomNoOfDigits(noOfDigitsZip) + "";
		zipcode.sendKeys(zipCodeValue);
		hMap.put("ZipCode", zipCodeValue);
	}

	public void enterAgeValue() {
		String ageValue = AppLibrary.getRandomNoOfDigits(noOfDigitsAge) + "";
		age.sendKeys(ageValue);
		hMap.put("Age", ageValue);
	}

	public void enterHeightValue() {

		String heightValue = rand.nextInt(100) + "";
		height.sendKeys(heightValue);
		hMap.put("Height", heightValue);
	}

	public void enterWeightValue() {
		String weightValue = rand.nextInt(100) + "";
		weight.sendKeys(weightValue);
		hMap.put("Weight", weightValue);

	}

	public void enterPharmaDetails() {

		String pharmacyValue = "CVS Pharmacy";
		pharmacy.sendKeys(pharmacyValue);
		hMap.put("Pharma", pharmacyValue);

		String pharma_adressValue = "4242 North st";
		pharmacyAddress.sendKeys(pharma_adressValue);
		hMap.put("PharmaAddress", pharma_adressValue);
	}

	public void enterUserDetails() {
		String emailValue = "mmp" + rand.nextInt(1000) + "@gmail.com";
		email.sendKeys(emailValue);
		hMap.put("Email", emailValue);

		String usernameValue = "mmp" + rand.nextInt(1000);
		username.sendKeys(usernameValue);
		hMap.put("Username", usernameValue);

		String passwordValue = "Mmpiit20" + rand.nextInt(1000);
		password.sendKeys(passwordValue);
		hMap.put("Password", passwordValue);
		confirmPassword.sendKeys(passwordValue);
		hMap.put("ConfirmPassword", passwordValue);
	}

	public void enterSecurityInfo() {
		new Select(security).selectByVisibleText("What is your mother maiden name");
		hMap.put("SecurityQuestion", "What is your mother maiden name");

		String answerValue = "Jan" + rand.nextInt(100);
		answer.sendKeys(answerValue);
		hMap.put("SecurityAnswer", answerValue);

	}

	public void clickOnSaveButton() {
		saveBtn.click();
		;
	}

	public String readSuccessMessage() throws InterruptedException {
		String mssg = null;
		try {
			wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);
			mssg = alert.getText();
			System.out.println("Alert mssg:" + mssg);
			alert.accept();
		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}

		return mssg;

	}

	public void fillData() {
		enterFirstName();
		enterLastName();
		enterDateOfBirth();
		enterLicense();
		enterSSN();
		enterState();
		enterCity();
		enterAddressValue();
		enterZipCodeValue();
		enterAgeValue();
		enterHeightValue();
		enterWeightValue();
		enterPharmaDetails();
		enterUserDetails();
		enterSecurityInfo();
		clickOnSaveButton();

	}

}
