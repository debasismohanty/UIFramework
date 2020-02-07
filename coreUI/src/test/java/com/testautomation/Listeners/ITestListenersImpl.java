package com.testautomation.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenersImpl extends ExtentReporterListener  implements ITestListener {//extends ExtentReporterListener
	
	

	private static ExtentReports extent;
	public void onTestStart(ITestResult result) {
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS");
		
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
		
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Execution starts here..");
		extent = SetUp();
	}

	
	public void onFinish(ITestContext context) {
		
		System.out.println("Execution completed here..");
		extent.flush();
	}


	
	
}
