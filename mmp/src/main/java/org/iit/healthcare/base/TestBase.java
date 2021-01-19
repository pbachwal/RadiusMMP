package org.iit.healthcare.base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.iit.healthcare.config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	protected WebDriver driver;
	protected Properties prop;
			
	@BeforeTest
	public void instantiateDriver() throws IOException 
	{
		PropertiesFile pFile = new PropertiesFile();
		prop = pFile.loadProperties();
		String browser = prop.getProperty("browser");	
		if(browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		
		else 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void launchApplication(String url) 
	{
		//launch the application
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
}
