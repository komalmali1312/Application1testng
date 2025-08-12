package com.orange.hrm.framework.base;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.orange.hrm.framework.utilities.PropUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage {
	private static WebDriver driver;
//This class have all basic methods and Configurations to begin the execution.(like browser setup, tear down,driver initialization, etc.)
Properties prope= PropUtil.readData("config.properties");
//Common method to get the WebDriver instance and launch the browser.	
	@Before
	public void setupBrowser() {
String BROWSER = prope.getProperty("Browser");
		switch (BROWSER.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(); // Assuming ChromeDriver is imported and set up
			System.out.println("Setting up Chrome browser");
			break;
		case "firefox":
			driver = new FirefoxDriver(); // Assuming FirefoxDriver is imported and set up
			System.out.println("Setting up Firefox browser");
			break;
		case "edge":
			driver = new EdgeDriver(); // Assuming EdgeDriver is imported and set up
			System.out.println("Setting up Edge browser");
			break;
		default:
			Assert.fail("Browser not supported: " + BROWSER);
			System.out.println("Browser not supported");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

//Common method to teardown the WebDriver instance after test execution.
	@After(order = 0)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed successfully");
		} else {
			System.out.println("No browser instance to close");
		}
	}
//common method to take screenshot after each test execution and attach it to the report.
	@After(order = 1)
	public void failedTestListener(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
	}
	}
	

	//Common method to verify the page title.
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected value");
		System.out.println("Page title verified successfully: " + actualTitle);
	}	
//Common methods to get the WebDriver instance and return it.
	public static WebDriver getDriver() {
		return driver;
	}
//Common methods to Set the WebDriver instance.
	public static void setDriver(WebDriver driver) {
		BasePage.driver = driver;
		System.out.println("WebDriver instance set successfully");
	}
}
