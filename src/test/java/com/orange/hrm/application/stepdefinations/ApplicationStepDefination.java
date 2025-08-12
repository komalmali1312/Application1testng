package com.orange.hrm.application.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.orange.hrm.application.steps.AdminPageSteps;
import com.orange.hrm.application.steps.HomePageSteps;
import com.orange.hrm.application.steps.LeavePageSteps;
import com.orange.hrm.application.steps.LoginPageSteps;
import com.orange.hrm.application.steps.PIMPageSteps;
import com.orange.hrm.application.steps.TimePageSteps;
import com.orange.hrm.framework.base.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationStepDefination {

	public LoginPageSteps loginsteps;
	public HomePageSteps homesteps;
	public AdminPageSteps adminsteps;
	public PIMPageSteps pimsteps;
	public LeavePageSteps leavesteps;
	public TimePageSteps timesheetsteps;

	@Given("Initialize the browser")
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

	@Given("I am on the OrangeHRM login page")
	public void i_am_on_the_orange_hrm_login_page() {
		loginsteps.launchApplication();
	}

	@Then("the title should be {string}")
	public void the_title_should_be(String string) {
       loginsteps.verifyPageTitle(string);
	}

	@Then("I should see the logo")
	public void i_should_see_the_logo(){
loginsteps.verifyapplicationBrandLogo();
loginsteps.verifyApplicationLoginLogo();
	}

	@Then("I should see the LoginForm header")
	public void i_should_see_the_header() {
loginsteps.verifyLoginFormHeader();
	}

	@Then("I should see the username field")
	public void i_should_see_the_username_field() {
loginsteps.verifyUsernameHeader();
	}

	@Then("I should see the password field")
	public void i_should_see_the_password_field() {
loginsteps.verifyPasswordHeader();	
	}

	@Then("I should see the login button")
	public void i_should_see_the_login_button() {
		loginsteps.verifyLoginButton();
	}

	@Then("I should see the {string} link")
	public void i_should_see_the_link(String string) {
		loginsteps.verifyForgotPasswordLink();
	}

	@Then("I should see the copyright text")
	public void i_should_see_the_copyright_text() {
		loginsteps.verifyCopyrightText1();
		loginsteps.verifyCopyrightText2();
	}

	@Given("I enter {string} in the username field")
	public void i_enter_in_the_username_field(String username) {
loginsteps.entercreds1(username);
	}

	@Given("I enter {string} in the password field")
	public void i_enter_in_the_password_field(String password) {
		loginsteps.entercreds2(password);
	}

	

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
loginsteps.clickOnLoginButton();
	}

	@Then("I should be redirected to the dashboard page")
	public void i_should_be_redirected_to_the_dashboard_page() {
		loginsteps.enterValidCredentialsAndLogin();
		homesteps.verifypresenceofmenus();
			homesteps.verifybrandLogo();
	}

	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating_invalid_credentials(String errorMessage) {
		loginsteps.verifyInvalidLoginErrorMessage(errorMessage);
		
	}
	@When("user login with valid credentials")
	public void user_login_with_valid_credentials() {
		loginsteps.enterValidCredentialsAndLogin();
		
	}
	@Then("user should be able to see the home page")
	public void user_should_be_able_to_see_the_home_page() {
		homesteps.verifypresenceofmenus();
		homesteps.verifybrandLogo();
		homesteps.verifysidepanel();
		homesteps.verifypresenceofmenus();
		homesteps.verifySearchMenuOption("Admin");
	}

}
