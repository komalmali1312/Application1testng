package com.orange.hrm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.orange.hrm.application.steps.AdminPageSteps;
import com.orange.hrm.application.steps.HomePageSteps;
import com.orange.hrm.application.steps.LeavePageSteps;
import com.orange.hrm.application.steps.LoginPageSteps;
import com.orange.hrm.application.steps.PIMPageSteps;
import com.orange.hrm.application.steps.TimePageSteps;
import com.orange.hrm.framework.base.BasePage;
import com.orange.hrm.framework.utilities.ExcelUtils;

public class BaseTest extends BasePage {
	public LoginPageSteps loginsteps;
	public HomePageSteps homesteps;
	public AdminPageSteps adminsteps;
	public PIMPageSteps pimsteps;
	public LeavePageSteps leavesteps;
	public TimePageSteps timesheetsteps;
@BeforeMethod(alwaysRun = true, dependsOnMethods = "setupBrowser")	
	public void initializePageClasses() {
		// Initialize the steps for each page
		WebDriver driver = BasePage.getDriver();
		loginsteps = new LoginPageSteps(driver);
		homesteps = new HomePageSteps(driver);
		adminsteps = new AdminPageSteps(driver);
		pimsteps = new PIMPageSteps(driver);
		leavesteps = new LeavePageSteps();
		timesheetsteps = new TimePageSteps();
	}
@DataProvider(name = "TestData")
public String[][] getTestData(Method method) {
	String[][] data=ExcelUtils.ReadExcelDatausing2DArray("TestData.xlsx", method.getName());
		return data;
}
			
}


