package com.orange.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orange.hrm.framework.webcommons.WebCommons;

public class LoginPageElements extends WebCommons {
	@FindBy(xpath="//div[@class='orangehrm-login-branding']/img")
	public WebElement applicationbrandlogo;
	@FindBy(xpath="(//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title' and text()='Login'])")
	public WebElement loginformheader;
	@FindBy(xpath="(//p[@class='oxd-text oxd-text--p'])[1]")
	public WebElement logindemousername;
	@FindBy(xpath="(//p[@class='oxd-text oxd-text--p'])[2]")
	public WebElement logindemopassword;
	@FindBy(xpath="(//div[@class='orangehrm-login-logo'])")
	public WebElement applicationloginlogo;
	@FindBy(xpath="(//label[@class='oxd-label' and text()='Username'])")
	public WebElement usernameheader;
	@FindBy(xpath="(//input[@name='username' and @placeholder='Username'])")
	public WebElement usernametextbox;
	@FindBy(xpath="(//label[@class='oxd-label' and text()='Password'])")
	public WebElement passwordheader;
	@FindBy(xpath="(//input[@name='password' and @placeholder='Password'])")
	public WebElement passwordtextbox;
	@FindBy(xpath="(//div[@class='oxd-form-actions orangehrm-login-action'])/button[@type='submit']")
	public WebElement loginbutton;
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	public WebElement forgotpassword;
	@FindBy(xpath="//div[@class='orangehrm-forgot-password-button-container']/button[text()=' Cancel ']")
	public WebElement forgotpasswordcancelpopup;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	public WebElement invalidcredsmsg;
	//p[@class='oxd-text oxd-text--p oxd-alert-content-text']
	@FindBy(xpath="(//div[@class='orangehrm-copyright-wrapper']/p)[1]")
	public WebElement copyrighttext1;
	@FindBy(xpath="(//div[@class='orangehrm-copyright-wrapper']/p)[2]")
	public WebElement copyrighttext2;
}
