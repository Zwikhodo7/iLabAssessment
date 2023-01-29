/*
 * 
 */
package com.ilabassessment.utility;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;//1
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author znemadodzi
 *
 */
public class ExtentManager   {
	public static ExtentReports setupExtentReport() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate =format.format(date);
		
		String reportPath = System.getProperty("user.dir")+"/reports/ExecutionReport_"+actualDate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");
		
		return extent;
		
	}
	
}

