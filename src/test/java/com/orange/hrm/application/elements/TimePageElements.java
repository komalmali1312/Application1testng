package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePageElements {
	@FindBy(xpath="((//ul[@class='oxd-main-menu']//li)[4]/a/*)[1]")
	WebElement timemenuIcon;
	@FindBy(xpath="//ul[@class='oxd-main-menu']//li//span[text()='Time']")
	WebElement timemenutext;
	@FindBy(xpath="//div[@class='oxd-topbar-header-title']/span")
	WebElement timepageheader;
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']")
	WebElement timepagetopmenus;
	@FindBy(xpath="//span[text()='Timesheets ']")
	WebElement timesheet;
	@FindBy(xpath="//span[text()='Attendance ']")
	WebElement attendence;
	@FindBy(xpath="//span[text()='Reports ']")
	WebElement reports;
	@FindBy(xpath="//span[text()='Project Info ']")
	WebElement projectinfo;
	
}
