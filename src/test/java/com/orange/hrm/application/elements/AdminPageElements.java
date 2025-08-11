package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orange.hrm.framework.webcommons.WebCommons;

public class AdminPageElements extends WebCommons {
	@FindBy(xpath="((//ul[@class='oxd-main-menu']//li)[1]/a/*)[1]")
	public WebElement adminmenuIcon;
	@FindBy(xpath="//ul[@class='oxd-main-menu']//li//span[text()='Admin']")
	public WebElement adminmenutext;
	@FindBy(xpath="//div[@class='oxd-topbar-header-title']/span")
	public WebElement adminpageheader;
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']")
	public WebElement adminpagetopmenus;
	@FindBy(xpath="//span[text()='User Management ']")
	public WebElement userManagement;
	@FindBy(xpath="//span[text()='Job ']")
	public WebElement job;
	@FindBy(xpath="//span[text()='Organization ']")
	public WebElement organization;
	@FindBy(xpath="//span[text()='Qualifications ']")
	public WebElement qualifications;
	@FindBy(xpath="//a[text()='Nationalities']")
	public WebElement notifications;
	@FindBy(xpath="//a[text()='Corporate Branding']")
	public WebElement corporatebonding;
	@FindBy(xpath="//span[text()='Configuration ']")
	public WebElement configuration;
	@FindBy(xpath="//div[@class='oxd-form-actions']/button[text()=' Search ']")
	public WebElement AdminSearchOption;
	@FindBy(xpath="//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
	public WebElement UsernameTextbox;
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	public WebElement Userroledropdown;
	@FindBy(xpath="(//span[text()='Admin'])[2]")
	public WebElement Adminoptionindrpdown;
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[2]")
	public WebElement statusdrpdown;
	@FindBy(xpath="(//span[text()='Enabled'])")
	public WebElement enabledstatus;
	@FindBy(xpath="//span[text()='Configuration ']")
	public WebElement employenametxbx;
	@FindBy(xpath="//div[@class='oxd-form-actions']/button[text()=' Reset ']")
	public WebElement resetbutton;
	@FindBy(xpath="//span[text()='Configuration ']")
	public WebElement recordfoundmsg;
}
