package org.iit.healthcare.mmp.patientmodule.tests;

import java.io.IOException;
import java.util.Arrays;
import org.iit.healthcare.mmp.base.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientLoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.SearchSymptomsPage;
import org.iit.healthcare.mmp.utility.AppLibrary;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchSymptomsTests extends TestBaseClass {
	private String patientUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
	private String symptom = "pain";
	private PatientLoginPage patientLoginPage;
	private String patUName = "laya1";
	private String patPword = "Laya12345";
	private String tabName = "Search Symptoms";
	private PatientHomePage patientHomePage;
	private SearchSymptomsPage searchSymptomsPage;
	private String actualSymptomsRow = null;
	private String expectedSymptomsRow = null;

	@Test(priority = 1, dataProvider = "symptomsData", enabled = false)
	public void validateSearchSymptomsRows(String symptom) {

		searchSymptomsPage.searchSymptoms(symptom);

		int symptomsTableRowCount = searchSymptomsPage.getSymptomsTableRowCount();

		Assert.assertTrue(symptomsTableRowCount > 0);

	}

	@Test(priority = 2, dataProvider = "tableData", enabled = false)

	public void validateSearchSymptomsData(String symptoms, String diagnosis, String solutions) {
		launchApplication(patientUrl);
		patientLoginPage = new PatientLoginPage(driver);
		patientLoginPage.login(patUName, patPword);
		patientHomePage = new PatientHomePage(driver);
		patientHomePage.navigationMenuItem(tabName);
		searchSymptomsPage = new SearchSymptomsPage(driver);
		searchSymptomsPage.searchSymptoms(symptom);

		actualSymptomsRow = searchSymptomsPage.getActualRow();
		expectedSymptomsRow = "pain muscle pull ibuprofen";

		System.out.println("actualSymptomsRow:" + '\t' + actualSymptomsRow);
		System.out.println("expectedSymptomsRow:" + '\t' + expectedSymptomsRow);

		Assert.assertEquals(actualSymptomsRow, expectedSymptomsRow);

	}
	@Test(priority = 3)
	public void mapTest() {
		launchApplication(patientUrl);
		patientLoginPage = new PatientLoginPage(driver);
		patientLoginPage.login(patUName, patPword);
		patientHomePage = new PatientHomePage(driver);
		patientHomePage.navigationMenuItem(tabName);
		searchSymptomsPage = new SearchSymptomsPage(driver);
		searchSymptomsPage.searchSymptoms(symptom);
		
		searchSymptomsPage.getActualRow1();
	}

	@DataProvider(name = "symptomsData")
	public Object[][] passSymptomsData() throws IOException {

		Object[][] xlRowData = AppLibrary.readXLSX(System.getProperty("user.dir") + "\\mmpTestData\\symptoms.xlsx",
				"ExpectedSymptoms");

		System.out.println("Array format from DP:" + '\t' + Arrays.deepToString(xlRowData));

		return xlRowData;
	}

	@DataProvider(name = "tableData")
	public Object[][] passSympTableData() throws IOException {

		Object[][] xlRowData = AppLibrary.readXLSX(System.getProperty("user.dir") + "\\mmpTestData\\symptoms.xlsx",
				"TableData");

		System.out.println("Array format from DP:" + '\t' + Arrays.deepToString(xlRowData));

		return xlRowData;
	}
}
