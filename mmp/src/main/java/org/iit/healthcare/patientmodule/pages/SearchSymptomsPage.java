package org.iit.healthcare.patientmodule.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSymptomsPage {
	private WebDriver driver;
	private By searchbox = By.xpath("//input[@id = 'search']");
	private By searchButton = By.xpath("//input[@name='submit']");
	private By symptomsRow = By.xpath("//table[@class = 'table'] /tbody/tr");
	private By symptomsRowData = By.xpath("//table[@class = 'table'] /tbody/tr/td");
	private List<WebElement> symptomsTableRowData;

	public SearchSymptomsPage(WebDriver driver) 
	{
		this.driver = driver;
		//new PatientHomePage(driver);
	}

	public void searchSymptoms(String symptom) 
	{
		//symptom = "";
		driver.findElement(searchbox).sendKeys(symptom);
		driver.findElement(searchButton).click();

	}

	public int getSymptomsTableRowCount() 
	{
		List<WebElement> symptomsTableRows = driver.findElements(symptomsRow);

		for (WebElement webElement : symptomsTableRows) 
		{
			System.out.println(webElement.getText());
		}

		return symptomsTableRows.size();

	}

	public String getActualRow() 
	{

		symptomsTableRowData = driver.findElements(symptomsRow);
		String actualData = null;
		for (WebElement webElement : symptomsTableRowData) 
		{
			actualData = webElement.getText();
			System.out.println("actualData:" +'\t'+actualData);
		}
		return actualData;
	}

	public void getActualRow1() 
	{
		Map<String, String> hMap = new HashMap<String, String>();
		String symptomsValue = driver.findElement(By.xpath("//table[@class = 'table'] /tbody/tr/td[1]")).getText();
		String diagnosisValue = driver.findElement(By.xpath("//table[@class = 'table'] /tbody/tr/td[2]")).getText();
		String solutionsValue = driver.findElement(By.xpath("//table[@class = 'table'] /tbody/tr/td[3]")).getText();
		System.out.println("symptomsValue" +symptomsValue);
		System.out.println("diagnosisValue" +diagnosisValue);
		System.out.println("solutionsValue" +solutionsValue);
		hMap.put("symptoms", symptomsValue);
		hMap.put("diagnosis", diagnosisValue);
		hMap.put("solutions", solutionsValue);
		System.out.println("hMap.get(\"symptoms\")"+'\t' +hMap.get("symptoms"));
		
		for (Entry<String, String> map : hMap.entrySet()) 
		{
			System.out.println("Key:" + map.getKey() + '\t' + "Value:" + map.getValue());

		}
	}

}
