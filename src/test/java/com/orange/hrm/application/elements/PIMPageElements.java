package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orange.hrm.framework.webcommons.WebCommons;

public class PIMPageElements extends WebCommons {
	@FindBy(xpath="((//ul[@class='oxd-main-menu']//li)[2]/a/*)[1]")
	public WebElement PIMmenuIcon;
	@FindBy(xpath="//ul[@class='oxd-main-menu']//li//span[text()='PIM']")
	public WebElement pimmenutext;
	@FindBy(xpath="//div[@class='oxd-topbar-header-title']/span")
	public WebElement PIMpageheader;
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']")
	public WebElement PIMpagetopmenus;
	@FindBy(xpath="//span[text()='Configuration ']")
	public WebElement configuration;
	@FindBy(xpath="//a[text()='Employee List']")
	public WebElement employeeList;
	@FindBy(xpath="//a[text()='Add Employee']")
	public WebElement addEmployee;
	@FindBy(xpath="//a[text()='Reports']")
	public WebElement reports;
	@FindBy(xpath="//h5[text()='Employee Information']")
	public WebElement employeeInformation;
	@FindBy(xpath="//nav[@aria-label='Pagination Navigation']")
	public WebElement pagination;
	@FindBy(xpath="//button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']")
	public WebElement paginationnextbutton;
	@FindBy(xpath="//button[@class=//h5[text()='Employee Information']")
	public WebElement employyeinformationheader;
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/following-sibling::div//div/input[@placeholder='Type for hints...']")
	public WebElement employeenametxtbx;
	@FindBy(xpath="//div[@class='oxd-form-actions']/button[text()=' Search ']")
	public WebElement SearchPIM;;
	@FindBy(xpath="//label[text()='//div[@class='oxd-form-actions']/button[text()=' Reset ']")
	public WebElement ResetPIM;
	@FindBy(xpath="//label[text()='//span[text()='(1) Record Found']")
	public WebElement Recordfoundmsg;
	//span[text()='(1) Record Found']
	
	
}
