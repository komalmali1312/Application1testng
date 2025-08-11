package com.orange.hrm.application.tests;

import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {
//This class looks like manual Test cases for OrangeHRM application
	@Test(priority = 1)
	public void verifyLogoisDisplayed() {
		loginsteps.launchApplication();
		loginsteps.verifyapplicationBrandLogo();
		loginsteps.verifyApplicationLoginLogo();
	}
	@Test(priority = 2)
	public void verifyapplicationHeader()
	{
		loginsteps.launchApplication();
		loginsteps.verifyLoginFormHeader();
	}
	@Test(priority=3)
	public void verifyLoginDemoCredentials() {
		loginsteps.launchApplication();
		loginsteps.verifyLoginDemocredentials();
	}
	@Test(priority = 4)
	public void verifyloginform() {
		loginsteps.launchApplication();
		loginsteps.verifyUsernameHeader();
		loginsteps.verifyPasswordHeader();
		loginsteps.verifyLoginButton();
		loginsteps.verifyCopyrightText1();
	    loginsteps.verifyCopyrightText2();
	    loginsteps.verifyForgotPasswordLink();
	}
	//Login using hard-coded username and password
	@Test(priority = 5)
	public void loginToApplication() {
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		
	}
	//Login using property file username and password
	@Test(priority = 6)
	public void loginUsingPropertyFile() {
		loginsteps.launchApplication();
		loginsteps.loginusingpropertyfile();
		
	}
	//Login using Excel file username and password(dataprovider)
	@Test(priority = 7,dataProvider="TestData")
	public void loginUsingExcelFile(String username, String password) {
		loginsteps.launchApplication();
		loginsteps.loginusingexcelfile(username, password);
	}
	//Verify login process with Invalid Credentials
	@Test(priority=8)
	public void verifyLoginWithInvalidCredentials() {
		loginsteps.launchApplication();
		loginsteps.verifyLoginWithInvalidCredentials();
	}
	//Verify home page menus in left side bar
	@Test(priority = 9)
	public void verifyHomePageMenus() {
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		homesteps.verifybrandLogo();
		homesteps.verifysidepanel();
		homesteps.verifypresenceofmenus();
		
	}
	@Test(priority = 10)
	public void searchEmployee()
	{
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		homesteps.verifySearchMenuOption("Recruitment");
	}
	@Test(priority = 11)
	public void verifyAdminpageSearchFunctionality() {
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		adminsteps.clickAdminMenuIcon();
		adminsteps.verifyAdminPageHeader1();
		adminsteps.SearchfunctionalityofAdminnpage();
	}
	@Test(priority = 12)
	public void verifyAdminpageResetFunctionality() {
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		adminsteps.clickAdminMenuIcon();
		adminsteps.verifyAdminPageHeader1();
		adminsteps.ResetfunctionalityofAdminnpage();
	}
	@Test(priority = 13)
	public void verifyPIMPageSearchFunctionality() {
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		pimsteps.clickPIMMenuIcon();
		pimsteps.verifyPIMPageHeader();
		pimsteps.verifyPIMPageTopMenus();
		pimsteps.employeeinSearch();
		
	}
	@Test(priority = 14)
	public void verifyPIMPageResetFunctionality() {
		loginsteps.launchApplication();
		loginsteps.enterValidCredentialsAndLogin();
		pimsteps.clickPIMMenuIcon();
		pimsteps.verifyPIMPageHeader();
		pimsteps.verifyPIMPageTopMenus();
		pimsteps.resetPIM();
	}
	
}
