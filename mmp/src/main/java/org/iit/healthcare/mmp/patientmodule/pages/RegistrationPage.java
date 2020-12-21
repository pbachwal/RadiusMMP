package org.iit.healthcare.mmp.patientmodule.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.iit.healthcare.utility.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage 
{
	public WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();
	int noOfChars;
	Random rand;
	int noOfDigitsAge=2;
	int noOfDigitsZip=5;
	
	By txt_register1 = By.xpath("//input[@type='button']");
	By txt_firstname = By.id("firstname");
	By txt_lastname =  By.id("lastname");
	By txt_dateofbirth = By.id("datepicker");
	By txt_license = By.id("license");
	By txt_ssn = By.id("ssn");
	By txt_state = By.id("state");
	By txt_city = By.id("city");
	By txt_address = By.id("address");
	By txt_zipcode = By.id("zipcode");
	By txt_age = By.id("age");
	By txt_height = By.id("height");
	By txt_weight = By.id("weight");
	By txt_pharmacy = By.id("pharmacy");
	By txt_pharmacyaddress = By.id("pharma_adress");
	By txt_email = By.id("email");
	By txt_password = By.id("password");
	By txt_username = By.id("username");
	By txt_conf_pwd = By.id("confirmpassword");
	By txt_sel_secquestion = By.name("question"); 
	By txt_answer = By.id("answer");
	By txt_save = By.name("register");
	
	public RegistrationPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickOnRegisterBtn() 
	{
		driver.findElement(txt_register1).click();
	}
	
	public void enterFName() 
	{
		String firstName = "FName" + AppLibrary.getRandomString(noOfChars);
		driver.findElement(txt_firstname).sendKeys(firstName);
		hMap.put("FirstName",firstName);
	}
	
	public void enterLName() 
	{
		String lastName = "LName" + AppLibrary.getRandomString(noOfChars);
		driver.findElement(txt_lastname).sendKeys(lastName);
		hMap.put("LastName",lastName);
	}
	
	public void enterDateOfBirth() 
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		String datePickerValue = sdf.format(date);
		driver.findElement(txt_dateofbirth).sendKeys(datePickerValue);
		hMap.put("DatePicker",  datePickerValue);
	}
	
	public void enterLicenseNo() 
	{
		String s = AppLibrary.getRandomNo(6,10000);
		String LicenseNo = s.substring(0, 8);
		driver.findElement(txt_license).sendKeys(LicenseNo);
		hMap.put("LicenseNumber",  LicenseNo);
	}
	
	public void enterSSN()
	{
		String ssn = Calendar.getInstance().getTimeInMillis()%1000000000+"";
		driver.findElement(txt_ssn).sendKeys(ssn);
		hMap.put("SSN", ssn);
	}
	
	public void enterState() 
	{
		String state = AppLibrary.getRandomState();
		driver.findElement(txt_state).sendKeys(state);
		hMap.put("State", state);
	}
	public void enterCity() 
	{
		String city = "Boston";
		driver.findElement(txt_state).sendKeys(city);
		hMap.put("City", city);
	}
	public void enterAddress() 
	{
		String address = "PrincetonPark";
		driver.findElement(txt_state).sendKeys(address);
		hMap.put("Address", address);
	}
	public void enterZipCode() 
	{
		String zipCode = AppLibrary.getRandomNoOfDigits(noOfDigitsZip)+"";
		driver.findElement(txt_state).sendKeys(zipCode);
		hMap.put("ZipCode", zipCode);
	}
	
	public void enterAge() 
	{
		String age = AppLibrary.getRandomNoOfDigits(noOfDigitsAge)+"";
		driver.findElement(txt_age).sendKeys(age);
		hMap.put("Age", age);
	}
	
	public void enterHeight()
	{

		String height =  rand.nextInt(100)+"";
		driver.findElement(txt_height).sendKeys(height);
		hMap.put("Height", height);
	}
	
	public void enterWeight()
	{		
		String weight =  rand.nextInt(100)+"";
		driver.findElement(txt_weight).sendKeys(weight);
		hMap.put("Weight", weight);
	}
	
	public void enterPharmaDetails()
	{

		String pharmacy =  "CVS Pharmacy";
		driver.findElement(txt_pharmacy).sendKeys(pharmacy);
		hMap.put("Pharmacy", pharmacy);
		
		
		String pharmacyAddress = "12 Chipmunk Crossing";
		driver.findElement(txt_pharmacyaddress).sendKeys(pharmacyAddress);
		hMap.put("Pharmacy Address", pharmacyAddress);
	}
	
	public void enterUserDetails()
	{
		String emailId = "Rob"+rand.nextInt(100)+"@gmail.com";
		driver.findElement(txt_email).sendKeys(emailId);
		hMap.put("Email", emailId);
		
		
		String userName = "Rob"+rand.nextInt(100);
		driver.findElement(txt_username).sendKeys(userName);
		hMap.put("Username", userName);
		
	 
		String password="pwd"+rand.nextInt(100);
		driver.findElement(txt_password).sendKeys(password);
		hMap.put("Password", password);
		
		
		driver.findElement(txt_conf_pwd).sendKeys(password);
		hMap.put("ConfirmPassword", password);
	}
	
	public void enterSecurityQuestion() 
	{
		Select select = new Select(driver.findElement(txt_sel_secquestion));
		select.selectByVisibleText(("what is your pet name"));
		
		String answer = "Fraiser"+rand.nextInt(10);
		driver.findElement(txt_answer).sendKeys(answer);
		hMap.put("SecurityAnswer", answer);
	}
	
	public String clickonSaveButton() 
	{
		String msg="";
		try{
			driver.findElement(txt_save).click();
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			alert.accept();
		}
		catch(Exception e)
		{
			System.out.println("Exception got: "+e.getMessage());
			//msg = checkError();
		}
		return msg;
	}
	
	public void enterRegistrationDetails() 
	{
		enterFName();
		enterLName();
		enterDateOfBirth();
		enterLicenseNo();
		enterSSN();
		enterState();
		enterCity();
		enterAddress();
		enterZipCode();
		enterAge();
		enterHeight();
		enterWeight();
		enterPharmaDetails();
		enterUserDetails();
		enterSecurityQuestion();
		clickonSaveButton();
	}
}	
	
	
		
	

