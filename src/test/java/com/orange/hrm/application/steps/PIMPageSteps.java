package com.orange.hrm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orange.hrm.application.elements.PIMPageElements;

public class PIMPageSteps extends PIMPageElements {

	public PIMPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickPIMMenuIcon() {
		waitForElementToBeVisible(PIMmenuIcon);
		clickElement(pimmenutext);
	}
	public void verifyPIMPageHeader() {
		waitForElementToBeVisible(PIMpageheader);
		PIMpageheader.isDisplayed();
	}
	public void verifyPIMPageTopMenus() {
		waitForElementToBeVisible(PIMpagetopmenus);
		PIMpagetopmenus.isDisplayed();
	}
	
	public void employeeinSearch() {
		waitForElementToBeVisible(employeeInformation);
		employyeinformationheader.isDisplayed();
		waitForElementToBeVisible(employeenametxtbx);
		employeenametxtbx.isDisplayed();
		employeenametxtbx.clear();
		employeenametxtbx.sendKeys("Virat Kohli");
		clickElement(SearchPIM);
		waitForElementToBeVisible(Recordfoundmsg);
		Assert.assertTrue(Recordfoundmsg.isDisplayed(), "Record found message is not displayed");
		
	}
	public void resetPIM() {
		employeeinSearch();
		waitForElementToBeVisible(ResetPIM);
		ResetPIM.isDisplayed();
		clickElement(ResetPIM);
		waitForElementToBeVisible(employeenametxtbx);
		Assert.assertTrue(employeenametxtbx.getText().isEmpty(), "Employee name textbox is not reset");
		
	}

}
