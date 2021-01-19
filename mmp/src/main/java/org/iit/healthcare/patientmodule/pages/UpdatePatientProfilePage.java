package org.iit.healthcare.patientmodule.pages;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import org.iit.healthcare.utility.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdatePatientProfilePage 
{
	public WebDriver driver;
	WebElement we;
	
	HashMap<String, String> hMap = new HashMap<String, String>();
	HashMap<String, String> hMap1 = new HashMap<String, String>();
	Random rand1 = new Random();
	Select sel;
		
	By txt_firstname = By.id("fname");
	By txt_lastname = By.id("lname");
	By txt_License = By.id("licn");
	By txt_ssn = By.id("ssn");
	By txt_address = By.id("addr");
	By txt_age = By.id("age");
	By txt_weight = By.id("weight"); 
	By txt_height = By.id("height");
	By txt_city = By.id("city");
	By txt_state = By.id("state");
	By txt_zipcode = By.id("zip");
	By txt_providerinformation = By.id("proinfo");
	By txt_insuranceinformation = By.id("Insinfo");
	By txt_editbtn = By.id("Ebtn");
	By txt_save = By.id("Sbtn");
	
	public UpdatePatientProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HashMap<String, String> getFieldvalues()
	{
		//Before clicking the edit button capture all the values and store it in the hashmap
		hMap.put("FirstName", driver.findElement(txt_firstname).getAttribute("value"));
		hMap.put("LastName", driver.findElement(txt_lastname).getAttribute("value"));
		hMap.put("License", driver.findElement(txt_License).getAttribute("value"));
		hMap.put("SSN", driver.findElement(txt_ssn).getAttribute("value"));
		hMap.put("Address", driver.findElement(txt_address).getAttribute("value"));
		hMap.put("Age", driver.findElement(txt_age).getAttribute("value"));
		hMap.put("Weight", driver.findElement(txt_weight).getAttribute("value"));
		hMap.put("Height", driver.findElement(txt_height).getAttribute("value"));
		hMap.put("City", driver.findElement(txt_city).getAttribute("value"));
		hMap.put("State", driver.findElement(txt_state).getAttribute("value"));
		hMap.put("ZipCode", driver.findElement(txt_zipcode).getAttribute("value"));
		hMap.put("ProvidersInformation", driver.findElement(txt_providerinformation).getAttribute("value"));
		hMap.put("InsuranceInformation", driver.findElement(txt_insuranceinformation).getAttribute("value"));
		
		return hMap;
	}
	
	public void clickOnEditBtn() 
	{
		driver.findElement(txt_editbtn).click();
		System.out.println("User was successfully able to click on edit button");
	}
	
	public void editTextField() 
	{
		//need to write a for loop somewhere here
		System.out.println("User is trying to edit a random field");
		int num = 1+rand1.nextInt(13);
		System.out.println("User edited the field number:" + num );
		//for(int i=1; i<=num; i++) 
		switch(num) 
		{
			case 1:
				editFirstName();
				break;
			case 2:
				editLastName();
				break;
			case 3:
				editLicense();
				break;
			case 4:
				editSSN();
				break;
			case 5:
				editAddress();
				break;
			case 6:
				editWeight();
				break;
			case 7:
				editHeight();
				break;
			case 8:
				editAge();
				break;
			case 9:
				editState();
				break;
			case 10:
				editCity();
				break;
			case 11:
				editZipcode();
				break;
			/*case 12:
				editProvInfo();
				break;
			case 13:
				editInsuranceInfo();
				break;*/
		}
	}
	
	public void editFieldValues() 
	{
		editFirstName();
		editLastName();
		editLicense();
		editSSN();
		editHeight();
		editWeight();
		editCity();
		editAge();
		editState();
		editZipcode();
		//editProvInfo();
		//editInsuranceInfo();
	}		
	
	public void editFirstName() 
	{
		we = driver.findElement(txt_firstname);
		//System.out.println("FirstName:" + we.getText());
		System.out.println("FirstName:" + we.getAttribute("value"));
		String Editedfname = we.getAttribute("value")+(char)(65 + rand1.nextInt(26));
		System.out.println("The Editedfname value is:+ " +Editedfname);
		we.clear();
		we.sendKeys(Editedfname);
		hMap1.put("FName", Editedfname);
	}
	
	public void editLastName() 
	{
		we = driver.findElement(txt_lastname);
		System.out.println("LastName:" + we.getAttribute("value"));
		String Editedlname = we.getAttribute("value")+(char)(65 + rand1.nextInt(26));
		System.out.println("The Edited Lastname is :" + Editedlname);
		we.clear();
		we.sendKeys(Editedlname);
		hMap1.put("LName", Editedlname);
	}
	
	public void editLicense() 
	{
		we = driver.findElement(txt_License);
		System.out.println("License:" + we.getAttribute("value"));
		String Editedlname = "13265722";
		we.clear();
		we.sendKeys(Editedlname);
		hMap1.put("License", Editedlname);
	}
	
	public void editSSN() 
	{
		we = driver.findElement(txt_ssn);
		System.out.println("SSN:" + we.getAttribute("value"));
		String Editedssn = Calendar.getInstance().getTimeInMillis()%1000000000+"";
		we.clear();
		we.sendKeys(Editedssn);
		hMap1.put("SSN", Editedssn);
	}
	
	public void editHeight() 
	{
		we = driver.findElement(txt_height);
		System.out.println("Height:" + we.getAttribute("value"));
		String Editedheight =  rand1.nextInt(100)+"";
		we.clear();
		we.sendKeys(Editedheight);
		hMap1.put("Height", Editedheight);
	}
	
	public void editWeight() 
	{
		we = driver.findElement(txt_weight);
		System.out.println("Weight:" + we.getAttribute("value"));
		String EditedWeight =  rand1.nextInt(100)+"";
		we.clear();
		we.sendKeys(EditedWeight);
		hMap1.put("Weight", EditedWeight);
	}
	
	public void editCity() 
	{
		we = driver.findElement(txt_city);
		System.out.println("City:" + we.getAttribute("value"));
		String EditedCity =  "Houston";
		we.clear();
		we.sendKeys(EditedCity);
		hMap1.put("City", EditedCity);
	}
	
	public void editState() 
	{
		we = driver.findElement(txt_state);
		System.out.println("State:" + we.getAttribute("value"));
		//String Editedstate = AppLibrary.getRandomState();
		String EditedState = "MA";
		we.clear();
		we.sendKeys(EditedState);
		hMap1.put("State", EditedState);
	}
	
	public void editAddress() 
	{
		we = driver.findElement(txt_address);
		System.out.println("Address:" + we.getAttribute("value"));
		String Editedaddress = we.getAttribute("value")+(char)(65 + rand1.nextInt(26));
		we.clear();
		we.sendKeys(Editedaddress);
		hMap1.put("Address", Editedaddress);
	}
	
	public void editAge() 
	{
		we = driver.findElement(txt_age);
		System.out.println("Age:" + we.getAttribute("value"));
		int noOfDigitsAge = 2;
		String Editedage = AppLibrary.getRandomNoOfDigits(noOfDigitsAge)+"";
		System.out.println("The Edited age value is:" + Editedage);
		we.clear();
		we.sendKeys(Editedage);
		hMap1.put("Age", Editedage);
	}
	
	public void editZipcode()
	{
		int noOfDigitsZip = 5;
		we = driver.findElement(txt_zipcode);
		String EditedzipCode = AppLibrary.getRandomNoOfDigits(noOfDigitsZip)+"";
		System.out.println("The edited zipcode value is:" +EditedzipCode);
		we.clear();
		we.sendKeys(EditedzipCode);
		hMap1.put("Zipcode", EditedzipCode);
	}
		
	/*public void editProvInfo() 
	{
		we = driver.findElement(txt_providerinformation);
		Select sel = new Select(we);
		sel.selectByIndex(1);
		System.out.println("Text value : " + sel.getFirstSelectedOption());
		System.out.println("ProvInfo:" + we.getAttribute("value"));
		String Editedpinfo = we.getAttribute("value")+(char)(65 + rand1.nextInt(26));
		we.clear();
		we.sendKeys(Editedpinfo);
		hMap1.put("FName", Editedpinfo);
		
	}
	
	  public void editInsuranceInfo()
	{
		we = driver.findElement(txt_insuranceinformation);
		Select sel = new Select(we);
		sel.selectByIndex(0);
		System.out.println("Text value : " + sel.getFirstSelectedOption());
		System.out.println("InsuranceInformation:" + we.getAttribute("value"));
		String Editedinsinfo = we.getAttribute("value")+(char)(65 + rand1.nextInt(26));
		we.clear();
		we.sendKeys(Editedinsinfo);
		hMap1.put("FName", Editedinsinfo);
	}*/
	
	
	public String clickOnSaveButton() 
	{
		String msg = "";
		try 
			{
				driver.findElement(txt_save).click();
				Alert alert = driver.switchTo().alert();
				msg = alert.getText();
				alert.accept();
			}
		 catch(Exception e)
		{
			 System.out.println("Exception :" +e.getMessage());
	    }
		return msg;
		
		}
	
		public void tearDown()
		{
			driver.close();
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
