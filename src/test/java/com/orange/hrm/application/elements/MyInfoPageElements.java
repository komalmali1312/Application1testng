package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPageElements {
	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewMyDetails']")
	public WebElement myInfoMenu;
	@FindBy(xpath = "//span[text()='My Info']")
	public WebElement myInfoMenuText;
	@FindBy(xpath = "//label[text()='Employee Full Name']")
	public WebElement employeefullname;
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstnametxbx;
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	public WebElement middlenametxbx;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastnametxbx;
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[3]/preceding::label[text()='Employee Id']")
	public WebElement employeeidtxbx;
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])/preceding::label[text()='Nationality']")
	public WebElement nationalitydrpdiwn;
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])/preceding::label[text()='Marital Status']")
	public WebElement maritalstatusdrpdiwn;
	@FindBy(xpath = "(//div[@class='oxd-radio-wrapper'])[2]")
	public WebElement Genderradiobutton;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement personaldetailssavebtn;
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[3]")
	public WebElement customfieldsheader;
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[3]/preceding::label[text()='Blood Type']")
	public WebElement bloodtypedrpdiwn;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])/preceding::label[text()='Test_Field']")
	public WebElement testfieldtxtbx;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement customfieldsavebtn;
	@FindBy(xpath = "//span[text()='My Info']")
	public WebElement attachmentsheader;
	@FindBy(xpath = "//span[text()='My Info']")
	public WebElement addbutton;
	@FindBy(xpath = "//span[text()='My Info']")
	public WebElement uploadfilebtn;
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	public WebElement saveattachmentbtn;
}
