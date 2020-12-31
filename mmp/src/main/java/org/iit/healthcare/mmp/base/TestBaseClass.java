package org.iit.healthcare.mmp.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	protected WebDriver driver;

	public void instantiateDriver()  {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void launchApplication(String url) {
		driver.get(url);
	}

	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/

}
