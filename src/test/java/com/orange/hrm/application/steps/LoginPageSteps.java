package com.orange.hrm.application.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orange.hrm.application.elements.LoginPageElements;
import com.orange.hrm.framework.utilities.PropUtil;

public class LoginPageSteps extends LoginPageElements {
	//Method to initialize the page elements
	public LoginPageSteps(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	public void verifyapplicationBrandLogo() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		waitForElementToBeVisible(applicationbrandlogo);
		
	}
	public void verifyLoginFormHeader() {
		waitForElementToBeVisible(loginformheader);
		String headerText = loginformheader.getText();
		Assert.assertEquals(headerText, "Login", "Login form header text does not match expected value");
		
	}
	public void verifyLoginDemocredentials() {
		waitForElementToBeVisible(logindemousername);
		String usernameText = logindemousername.getText();
		Assert.assertEquals(usernameText, "Username : Admin", "Login demo username does not match expected value");
		

		waitForElementToBeVisible(logindemopassword);
		String passwordText = logindemopassword.getText();
		Assert.assertEquals(passwordText, "Password : admin123", "Login demo password does not match expected value");
		
	}
	public void verifyApplicationLoginLogo() {
		waitForElementToBeVisible(applicationloginlogo);
		
	}
	public void verifyUsernameHeader() {
		waitForElementToBeVisible(usernameheader);
		String headerText = usernameheader.getText();
		Assert.assertEquals(headerText, "Username", "Username header text does not match expected value");
		
	}
	public void verifyUsernameTextbox() {
		waitForElementToBeVisible(usernametextbox);
		Assert.assertTrue(usernametextbox.isDisplayed(), "Username textbox is not displayed");
		
		isElementEnabled(usernametextbox);
		Assert.assertTrue(usernametextbox.isEnabled(), "Username textbox is not enabled");
		enterText(usernametextbox, "Admin");
		
	}
	public void entercreds1(String username) {
		waitForElementToBeVisible(usernametextbox);
		Assert.assertTrue(usernametextbox.isDisplayed(), "Username textbox is not displayed");
		
		isElementEnabled(usernametextbox);
		Assert.assertTrue(usernametextbox.isEnabled(), "Username textbox is not enabled");
		enterText(usernametextbox, username);
		
	}
	public void entercreds2(String password)
	{
		waitForElementToBeVisible(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isDisplayed(), "passwordtextbox  is not displayed");
		isElementEnabled(passwordtextbox);
		enterText(passwordtextbox, "password");
	}
	public void verifyPasswordHeader() {
		waitForElementToBeVisible(passwordheader);
		String headerText = passwordheader.getText();
		Assert.assertEquals(headerText, "Password", "Password header text does not match expected value");
		
	}
	public void verifyPasswordTextbox() {
		waitForElementToBeVisible(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isDisplayed(), "Password textbox is not displayed");
		
		isElementEnabled(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isEnabled(), "Password textbox is not enabled");
		enterText(passwordtextbox, "admin123");
		
		Assert.assertTrue(passwordtextbox.getAttribute("value").equals("admin123"), "Password textbox value does not match expected value");
		
	}
	public void verifyLoginButton() {
		waitForElementToBeVisible(loginbutton);
		Assert.assertTrue(loginbutton.isDisplayed(), "Login button is not displayed");
	
		
		
	}
	public void verifyForgotPasswordLink() {
		waitForElementToBeVisible(forgotpassword);
		Assert.assertTrue(forgotpassword.isDisplayed(), "Forgot password link is not displayed");
		
		clickElement(forgotpassword);
		waitForElementToBeVisible(forgotpasswordcancelpopup);
		Assert.assertTrue(forgotpasswordcancelpopup.isDisplayed(), "Forgot password cancel popup is not displayed");
		clickHiddenElement(forgotpasswordcancelpopup);
	}
	public void verifyCopyrightText1() {
		waitForElementToBeVisible(copyrighttext1);
		String text1 = copyrighttext1.getText();
		Assert.assertEquals(text1, "OrangeHRM OS 5.7");
		
	}
	public void verifyCopyrightText2() {
		waitForElementToBeVisible(copyrighttext2);
		String text2 = copyrighttext2.getText();
		//Assert.assertEquals(text2, "OrangeHRM, Inc. All rights reserved.", "Copyright text 2 does not match expected value");
		
	}
	public void enterValidCredentialsAndLogin() {
		verifyUsernameTextbox();
		verifyPasswordTextbox();
		clickElement(loginbutton);
		
		
		// Verify successful login by checking if the dashboard is displayed
		Properties prop = PropUtil.readData("Config.properties");
		String expectedDashboardTitle = prop.getProperty("expectedDashboardTitle");
		Assert.assertEquals(driver.getTitle(), expectedDashboardTitle, "Dashboard title does not match expected value after login");
		
	}
//method to login using property file	
	public void loginusingpropertyfile() {
		waitForElementToBeVisible(usernametextbox);
		Assert.assertTrue(usernametextbox.isDisplayed(), "Username textbox is not displayed");
		
		isElementEnabled(usernametextbox);
		Assert.assertTrue(usernametextbox.isEnabled(), "Username textbox is not enabled");
		Properties prop = PropUtil.readData("Config.properties");
		String username = prop.getProperty("App_Username");
		enterText(usernametextbox, username);
		waitForElementToBeVisible(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isDisplayed(), "Password textbox is not displayed");
		
		isElementEnabled(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isEnabled(), "Password textbox is not enabled");
		String password = prop.getProperty("App_Password");
		enterText(passwordtextbox, password);
		
		clickElement(loginbutton);
	}
//method to login using excel file and DataProvider	
	public void loginusingexcelfile(String Email,String Password) {
		waitForElementToBeVisible(usernametextbox);
		Assert.assertTrue(usernametextbox.isDisplayed(), "Username textbox is not displayed");
		
		isElementEnabled(usernametextbox);
		Assert.assertTrue(usernametextbox.isEnabled(), "Username textbox is not enabled");
		enterText(usernametextbox, Email);
		waitForElementToBeVisible(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isDisplayed(), "Password textbox is not displayed");
		
		isElementEnabled(passwordtextbox);
		Assert.assertTrue(passwordtextbox.isEnabled(), "Password textbox is not enabled");
		enterText(passwordtextbox, Password);
		
		clickElement(loginbutton);
		
	}
	public void verifyLoginWithInvalidCredentials() {
		waitForElementToBeVisible(usernametextbox);
		waitForElementToBeVisible(passwordtextbox);
		enterText(usernametextbox, "komal");
		enterText(passwordtextbox, "komal@123");
		clickElement(loginbutton);
		waitForElementToBeVisible(invalidcredsmsg);
		String errorMessage = invalidcredsmsg.getText();
		Assert.assertEquals(errorMessage, "Invalid credentials", "Error message does not match expected value");
		
	}
	//method to verify the title of the page
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected value");
		
	}
	//simple method to click on login button
	public void clickOnLoginButton() {
		clickElement(loginbutton);
		
		
	}
	public void verifyInvalidLoginErrorMessage(String errorMessage) {
		// TODO Auto-generated method stub
		waitForElementToBeVisible(invalidcredsmsg);
	}
}

