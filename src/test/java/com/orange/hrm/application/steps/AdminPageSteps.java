package com.orange.hrm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orange.hrm.application.elements.AdminPageElements;

public class AdminPageSteps extends AdminPageElements {

	public AdminPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public void clickAdminMenuIcon() {
		waitForElementToBeVisible(adminmenuIcon);
		clickElement(adminmenutext);
	}

	
	public void verifyAdminPageHeader1() {
		waitForElementToBeVisible(adminmenuIcon);
		adminpageheader.isDisplayed();
	}
	
	public void SearchfunctionalityofAdminnpage()
	{
		clickAdminMenuIcon();
		waitForElementToBeVisible(adminpagetopmenus);
		UsernameTextbox.isDisplayed();
		UsernameTextbox.clear();
		UsernameTextbox.sendKeys("Admin");
		Userroledropdown.isDisplayed();
		Userroledropdown.click();
		Adminoptionindrpdown.isDisplayed();
		Adminoptionindrpdown.click();
		statusdrpdown.isDisplayed();
		statusdrpdown.click();
		enabledstatus.isDisplayed();
		enabledstatus.click();
		AdminSearchOption.isDisplayed();
		AdminSearchOption.click();
		recordfoundmsg.isDisplayed();
		recordfoundmsg.getText().contains("Record Found");
	}
	public void ResetfunctionalityofAdminnpage()
	{
		clickAdminMenuIcon();
		waitForElementToBeVisible(adminpagetopmenus);
		UsernameTextbox.isDisplayed();
		UsernameTextbox.clear();
		Userroledropdown.isDisplayed();
		Userroledropdown.click();
		Adminoptionindrpdown.isDisplayed();
		Adminoptionindrpdown.click();
		AdminSearchOption.isDisplayed();
		AdminSearchOption.click();
		resetbutton.isDisplayed();
		resetbutton.click();
		
	}
	public void adduser()
	{
		
	}
	
}
