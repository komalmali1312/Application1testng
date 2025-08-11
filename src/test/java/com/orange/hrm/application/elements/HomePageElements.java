package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orange.hrm.framework.webcommons.WebCommons;

public class HomePageElements extends WebCommons {
	@FindBy(xpath="//nav[@aria-label='Sidepanel']")
	public WebElement sidepanel;
	@FindBy(xpath="//div[@class='oxd-brand-banner']")
	public WebElement Homepagebrandlogo;
	@FindBy(xpath="//div[@class='oxd-main-menu-search']")
	public WebElement Searchoption;
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement Searchtextbox;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-main-menu-button']")
	public WebElement Sidebarclosebutton;
	@FindBy(xpath="//ul[@class='oxd-main-menu']")
	public WebElement menus;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-main-menu-button']")
	public WebElement menubutton;
	@FindBy(xpath="//*[text()=' Upgrade']")
	public WebElement upgradeOption;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	public WebElement profilepicture;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']//img")
	public WebElement profileLogo;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']//p")
	public WebElement profileName;
	@FindBy(xpath="//a[@class='oxd-main-menu-item']/span")
	public WebElement searchresult;
}
