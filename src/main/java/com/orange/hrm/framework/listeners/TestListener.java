package com.orange.hrm.framework.listeners;
import org.testng.ITestResult;

import com.orange.hrm.framework.base.BasePage;
import com.orange.hrm.framework.reports.Reports;
import com.orange.hrm.framework.webcommons.WebCommons;

import java.io.IOException;

import org.testng.ITestListener;
//This class is used to listen to test events and generate reports based on the test results.
public class TestListener extends Reports implements ITestListener {
// This class implements the ITestListener interface to handle test events.
//This method is called when a test starts, and it initializes the reporting for that test.		
       public void onTestStart(ITestResult result) {
    	   
			// Code to execute when a test starts
    	   String testName = result.getMethod().getMethodName();
    	   startReporting(testName);
		}

//This method is called when a test is passed, and it logs the success of the test.
		public void onTestSuccess(ITestResult result) {
			 String testName = result.getMethod().getMethodName();
			 logger.pass("Test passed: " + testName);
			 stopReporting();
		}

//This method is called when a test fails, and it logs the failure along with a screenshot.		
		public void onTestFailure(ITestResult result) {
			 String testName = result.getMethod().getMethodName();
			 logger.fail("Test failed: " + testName);
			 logger.fail("Test failed due to: " + result.getThrowable());
			 try {
				logger.addScreenCaptureFromPath(WebCommons.takeScreenshot(BasePage.getDriver(), testName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 logger.info("Screenshot captured for failed test: " + testName);
			 stopReporting();
			
		}
//This method is called when a test is skipped, and it logs the skip event.
		public void onTestSkipped(ITestResult result) {
			
			System.out.println("Test skipped: " + result.getMethod().getMethodName());
		}

		

	}



