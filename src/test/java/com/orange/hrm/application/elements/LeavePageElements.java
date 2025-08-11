package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePageElements {
	@FindBy(xpath="((//ul[@class='oxd-main-menu']//li)[3]/a/*)[1]")
	WebElement LeavemenuIcon;
	@FindBy(xpath="//ul[@class='oxd-main-menu']//li//span[text()='Leave']")
	WebElement leavemenutext;
	@FindBy(xpath="//div[@class='oxd-topbar-header-title']/span")
	WebElement Leavepageheader;
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']")
	WebElement Leavepagetopmenus;
	@FindBy(xpath="//a[text()='Apply']")
	WebElement Apply;
	@FindBy(xpath="//a[text()='My Leave']")
	WebElement myleave;
	@FindBy(xpath="//span[text()='Entitlements ']")
	WebElement entitlements;
	@FindBy(xpath="//span[text()='Reports ']")
	WebElement reports;
	@FindBy(xpath="//span[text()='Configure ']")
	WebElement configure;
	@FindBy(xpath="//a[text()='Leave List']")
	WebElement leavelist;
	@FindBy(xpath="//a[text()='Assign Leave']")
	WebElement assignleave;
}
