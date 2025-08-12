package com.orange.hrm.application.testrunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = "Features",
		glue = {"com.orange.hrm.application.stepdefinations","com.orange.hrm.framework.base"},
		plugin = {"pretty", "html:Reports/Automation-cucumber-reports.html"},
		monochrome = true,
		//tags = "@SmokeTest",
		publish = true
		
		)
public class ApplicationRunner extends AbstractTestNGCucumberTests {
	// This class is used to run the Cucumber tests with TestNG.
	// It extends AbstractTestNGCucumberTests to integrate Cucumber with TestNG.
	// The @CucumberOptions annotation is used to specify the features, glue code, plugins, and other configurations for the Cucumber tests.
@Test()
public void runCucumberTests() {
	// This method is used to trigger the execution of Cucumber tests.
	// It can be empty as the Cucumber runner will automatically pick up the configuration from the @CucumberOptions annotation.
	System.out.println("Running Application Test");// The tests will be executed based on the specified features and glue code.
}
}
