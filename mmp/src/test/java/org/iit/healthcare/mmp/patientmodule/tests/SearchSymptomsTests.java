package org.iit.healthcare.mmp.patientmodule.tests;

import java.io.IOException;
import java.util.Arrays;

import org.iit.healthcare.base.TestBase;
import org.iit.healthcare.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.patientmodule.pages.SearchSymptomsPage;
import org.iit.healthcare.utility.AppLibrary;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchSymptomsTests extends TestBase 
{
	//private String patientUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
	private String symptom = "pain";
	private PatientLoginPage patientLoginPage;
	//private String patUName = "laya1";
	//private String patPword = "Laya12345";
	private String tabName = "Search Symptoms";
	private PatientHomePage patientHomePage;
	private SearchSymptomsPage searchSymptomsPage;
	private String actualSymptomsRow = null;
	private String expectedSymptomsRow = null;

	@Test(priority = 1, dataProvider = "symptomsData", enabled = true)
	public void validateSearchSymptomsRows(String symptom) 
	{
		launchApplication(prop.getProperty("URL"));
		patientLoginPage = new PatientLoginPage(driver);
		patientLoginPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
		
		patientHomePage = new PatientHomePage(driver);
		patientHomePage.navigationMenuItem(tabName);
		
		
		searchSymptomsPage = new SearchSymptomsPage(driver);
		searchSymptomsPage.searchSymptoms(symptom);
		
		int symptomsTableRowCount = searchSymptomsPage.getSymptomsTableRowCount();

		Assert.assertTrue(symptomsTableRowCount > 0);
		System.out.println("This assertion 1 has been passed");
		System.out.println("The number of rows are:" + symptomsTableRowCount);

	}

	@Test(priority = 2, dataProvider = "tableData", enabled = true)

	public void validateSearchSymptomsData(String symptoms, String diagnosis, String solutions) 
	{
		launchApplication(prop.getProperty("URL"));
		patientLoginPage = new PatientLoginPage(driver);
		patientLoginPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
		
		patientHomePage = new PatientHomePage(driver);
		patientHomePage.navigationMenuItem(tabName);
		
		
		searchSymptomsPage = new SearchSymptomsPage(driver);
		searchSymptomsPage.searchSymptoms(symptom);

		actualSymptomsRow = searchSymptomsPage.getActualRow();
		expectedSymptomsRow = "pain muscle pull ibuprofen";

		System.out.println("actualSymptomsRow:" + '\t' + actualSymptomsRow);
		System.out.println("expectedSymptomsRow:" + '\t' + expectedSymptomsRow);

		Assert.assertEquals(actualSymptomsRow, expectedSymptomsRow);
		System.out.println("The assertion 2 has been passed");

	}
	@Test(priority = 3)
	public void mapTest() 
	{
		launchApplication(prop.getProperty("URL"));
		
		patientLoginPage = new PatientLoginPage(driver);
		patientLoginPage.login(prop.getProperty("patientUser"), prop.getProperty("patientPassword"));
		
		patientHomePage = new PatientHomePage(driver);
		patientHomePage.navigationMenuItem(tabName);
		
		searchSymptomsPage = new SearchSymptomsPage(driver);
		searchSymptomsPage.searchSymptoms(symptom);
		
		searchSymptomsPage.getActualRow1();
	}

	@DataProvider(name = "symptomsData")
	public Object[][] passSymptomsData() throws IOException 
	{

		Object[][] xlRowData = AppLibrary.readXLSX(System.getProperty("user.dir") + "\\mmpTestData\\symptoms.xlsx",
				"ExpectedSymptoms");

		System.out.println("Array format from DP:" + '\t' + Arrays.deepToString(xlRowData));

		return xlRowData;
	}

	@DataProvider(name = "tableData")
	public Object[][] passSympTableData() throws IOException 
	{

		Object[][] xlRowData = AppLibrary.readXLSX(System.getProperty("user.dir") + "\\mmpTestData\\symptoms.xlsx",
				"TableData");

		System.out.println("Array format from DP:" + '\t' + Arrays.deepToString(xlRowData));

		return xlRowData;
	}
}
