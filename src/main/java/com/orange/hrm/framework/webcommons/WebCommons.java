package com.orange.hrm.framework.webcommons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orange.hrm.framework.base.BasePage;
import com.orange.hrm.framework.constants.Constant;
import com.orange.hrm.framework.reports.Reports;
import com.orange.hrm.framework.utilities.PropUtil;

public class WebCommons {
//This class will have all common methods for WebAutomation/webElements.
// For example, methods to interact with web elements, wait for elements, etc.
	public WebDriver driver=BasePage.getDriver();
public Properties properties=PropUtil.readData("Config.properties");
//Common method to Launch the application URL and Verify Title
	public void launchApplication() {
		String url = properties.getProperty("App_URL");
		String expectedTitle = properties.getProperty("App_Title");
		driver.get(url);
		String actualTitle = driver.getTitle();
		if (!actualTitle.equals(expectedTitle)) 
			Assert.fail("Title mismatch: Expected '" + expectedTitle + "', but got '" + actualTitle + "'");
	}
//Common method to scroll to an element using JavaScript Executor
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}	
//Common method to Click on an element
	public void clickElement(WebElement element) {
		scrollToElement(element); // Ensure the element is in view before clicking
		element.click();
	}
//Common method to Click on an hidden element using JavaScript Executor
	public void clickHiddenElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
//Common method to double click on an element using actions class
		public void doubleClickElement(WebElement element) {
	Actions actions = new Actions(driver);
		scrollToElement(element); // Ensure the element is in view before double-clicking
		actions.moveToElement(element).doubleClick().perform();
	}
//common method to right click on an element using actions class
	public void rightClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		scrollToElement(element); // Ensure the element is in view before right-clicking
		actions.contextClick(element).perform();
	}
//Common method to hover over an element using actions class
	public void hoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		scrollToElement(element); // Ensure the element is in view before hovering
		actions.moveToElement(element).perform();
	}
//Common method to select checkbox by checking its state
	public void selectCheckbox(WebElement checkbox) {
		scrollToElement(checkbox); // Ensure the element is in view before interacting
		if (!checkbox.isSelected()) {
			checkbox.click(); // Click to select the checkbox if it is not already selected
		}
	}	
//Common method to select option from dropdown using select class
	public void selectDropdownOption(WebElement dropdown, String option,String selectBy) {
		scrollToElement(dropdown); // Ensure the element is in view before selecting
		Select select = new Select(dropdown);
		if(selectBy.equalsIgnoreCase("visibleText")) {
			select.selectByVisibleText(option); // Select by visible text
		} else if(selectBy.equalsIgnoreCase("value")) {
			select.selectByValue(option); // Select by value
		} else if(selectBy.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(option);
			select.selectByIndex(index); // Select by index
		} else {
			Assert.fail("Invalid selection method: " + selectBy);
		}
	}	
//Common method to enter a text to an textbox
	public void enterText(WebElement element, String text) {
		scrollToElement(element); // Ensure the element is in view before entering text
		if(element.isDisplayed() && element.isEnabled()) {
			element.clear(); // Clear any existing text
			element.sendKeys(text); // Enter the new text
		}
			else
			{
			Assert.fail("Element is not enabled for text entry: " + element);
		}
		}	
	
//Common method to get the text of an element
	public String getElementText(WebElement element) {
		return element.getText();
	}
//Common method to get the attribute value of an element
	public String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	
	// Common method to get the current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
//common methods to refresh the current page
	public void refreshPage() {
		driver.navigate().refresh();
	}	
//Common method to navigate back to the previous page	
	public void navigateBack() {
		driver.navigate().back();
	}
//Common method to navigate forward to the next page
	public void navigateForward() {
		driver.navigate().forward();
	}
	
//Common method to wait using Java wait
	public void javawait() {
		try {
			Thread.sleep(Constant.TIMEOUT * 1000); // Simple wait, can be replaced with WebDriverWait for better handling
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Restore interrupted status
			Assert.fail("Thread was interrupted during wait: " + e.getMessage());
		}
		
	}
//Common method to wait using selenium wait(implicit wait)
	public void setimplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.TIMEOUT));
	}
//Common method to wait using selenium wait(explicit wait-Visibility of element)
	public void setExplicitWaitvisibilityelement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
//Common method to wait using wait(explicit wait-Locator element)
	public void setExplicitWaitLocator(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(locator), 0));
		}
//Common method to wait using selenium wait(explicit wait-Element to be clickable)
	public void setExplicitWaitClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
//Common method for an alert to be Present and accept it
	public void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	//Common method for an alert to be Present and reject it
		public void rejectAlert() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
		}

//Common method to switch to a frame by index
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
//Common method to switch to a frame by name or ID
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
//Common method to switch to a frame by WebElement
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
//Common method to switch back to the default content from a frame
		public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
//Common method to switch to a window by its handle
	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
//Common method to get the current window handle
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}
//Common method to get all window handles
	public Set<String> getAllWindowHandles() {
		return driver.getWindowHandles();
	}
//Common method to get screenshot of current page
	public static String takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
	String screenshotpath=System.getProperty("user.dir")+"//Screenshots//"+screenshotName+".png";
	File Screennshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Screennshotfile, new File(screenshotpath));
	return screenshotpath;
	}
//Common Method to take screenshot of webelement
	public String takeScreenshot(WebElement element,WebDriver driver,String screenshotName)throws IOException {
		String screenshotpath=System.getProperty("user.dir")+"//Screenshots//"+screenshotName+".png";
		File Screennshotfile=element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screennshotfile, new File(screenshotpath));
		return screenshotpath;
		}
//common method to wait for an element to be visible
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
//common method to print messages in reports
	public void log(String status,String message)
	{
		status=status.toUpperCase();
		switch(status) {
			case "PASS":
				Reports.logger.pass("PASS: " + message);
				break;
			case "FAIL":
				Reports.logger.fail("FAIL: " + message);
				Assert.fail(message);
				break;
			case "INFO":
				Reports.logger.info("INFO: " + message);
				break;
			case "WARNING":
				Reports.logger.warning("INFO: " + message);
				break;
			default:
				System.out.println("UNKNOWN STATUS: " + message);
		}
	}
//Common method to check element disappear
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT));
		wait.until(ExpectedConditions.invisibilityOf(element));
		log("INFO", "Element is no longer visible: " + element);
	}
//check element is enabled
	public void isElementEnabled(WebElement element) {
		if (element.isEnabled()) {
			log("INFO", "Element is enabled: " + element);
		} else {
			log("FAIL", "Element is not enabled: " + element);
			Assert.fail("Element is not enabled: " + element);
		}
		
	}
//common method to enter text in a textbox and verify the entered text
	public void enterTextAndVerify(WebElement element, String text) {
		enterText(element, text);
		
	}
//common method to click on webelement
	public void clickAndVerify(WebElement element) {
		clickElement(element);
		waitForElementToBeVisible(element); // Ensure the element is still visible after clicking
		log("INFO", "Clicked on element: " + element);
		try {
			Assert.assertTrue(element.isDisplayed(), "Element is not displayed after clicking: " + element);
		} catch (WebDriverException e) {
			log("FAIL", "Element is not displayed after clicking: " + element);
			Assert.fail("Element is not displayed after clicking: " + element);
		}
	}
}
