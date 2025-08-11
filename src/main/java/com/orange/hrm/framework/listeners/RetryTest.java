package com.orange.hrm.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		
		return false;
	}
	

}
