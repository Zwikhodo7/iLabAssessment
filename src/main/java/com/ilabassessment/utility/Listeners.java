/**
 * 
 */
package com.ilabassessment.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ilabassessment.base.BaseClass;

/**
 * @author znemadodzi
 *
 */
public class Listeners extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case:" +result.getMethod().getMethodName()+ "Is Passsed" );
	}


	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case:" +result.getMethod().getMethodName()+ "Is Failed" );
		test.log(Status.FAIL, result.getThrowable());

	}


	public void onTestSkipped(ITestResult result) {

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	public void onTestFailedWithTimeout(ITestResult result) {

	}


	public void onStart(ITestContext context) {
		extent = ExtentManager.setupExtentReport();
	}


	public void onFinish(ITestContext context) {
		extent.flush();
	}



	//	private static ExtentReports extent = ExtentManager.setExtent();
	//	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	//	
	//	 public void onTestStart(ITestResult result) {
	//		 ExtentTest test = extent.createTest(result.getTestClass().getName()+ "::" + result.getMethod().getMethodName());
	//		extentTest.set(test);
	//		 System.out.println("****Test started : "+result.getName());
	//		  }
	//	 
	//	 public void onTestSuccess(ITestResult result) {
	//		  System.out.println("****Test is successful : "+result.getName());
	//		  String logText = "<b>Test Method" + result.getMethod().getMethodName() + " Successful</b>";
	//		  Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
	//		  extentTest.get().log(Status.PASS, m);
	//		  }
	//	 
	//	 public void onTestFailure(ITestResult result) {
	//		  System.out.println("****Test failed : "+result.getName());
	//		  }
	//	 
	//	 public void onTestSkipped(ITestResult result) {
	//		  System.out.println("****Test skipped : "+result.getName());
	//		  String logText = "<b>Test Method" + result.getMethod().getMethodName() + " Skipped</b>";
	//		  Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
	//		  extentTest.get().log(Status.SKIP, m);
	//		  }
	//
	//	 public void onFinish(ITestResult context) {
	//		  System.out.println("****Tests completed : "+context.getName());
	//		  }
}
