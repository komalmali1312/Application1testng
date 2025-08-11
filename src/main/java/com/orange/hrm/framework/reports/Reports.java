package com.orange.hrm.framework.reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
//This class having all reports related methods.
	public static ExtentSparkReporter html;
	public static ExtentReports extent;
	public static ExtentTest logger;
//This method is used to setup the report
	@BeforeSuite(alwaysRun = true)
	public static void setupReport() {
		html = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports/AutomationTestReports//ExtentReport.html");
	    extent = new ExtentReports();
		extent.attachReporter(html);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Tester", "KomalMali");
	}
//This method to print report of each test case separately not on single page	
	public static void startReporting(String testName) {
		logger = extent.createTest(testName);
	}
	
//This method is used to Stop the reporting
	public static void stopReporting() {
		
			extent.flush();
		}
	}
