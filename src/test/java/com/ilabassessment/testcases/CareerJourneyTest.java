package com.ilabassessment.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ilabassessment.base.BaseClass;
import com.ilabassessment.dataprovider.DataProviders;
import com.ilabassessment.pageobjects.CareerPage;
import com.ilabassessment.pageobjects.IndexPage;
import com.ilabassessment.utility.Log;

public class CareerJourneyTest extends BaseClass{
	IndexPage indexPage;
	CareerPage careerPage;
	
	@Parameters("browser")
	@BeforeClass()
	public void setup(String browser) {
		//launchApp("IE");
		launchApp(browser);
	}
	
	@Test(priority=1)
	public void navigateToCareer() throws Throwable {
		Thread.sleep(10000);
		indexPage = new IndexPage();
		Log.info("Hovering on Get in Touch");
		indexPage.hoverOnGetInTouch();
		Log.info("Click on Career Opportunities");
		careerPage=indexPage.clickCareerOpportunities();
		Log.info("Click on reject cookies");
		indexPage.clickrejectCookies();

	}
	
	
	@Test(priority=2)
	public void navigateToJobPost() throws Throwable {
		Thread.sleep(5000);
		careerPage = new CareerPage();
		careerPage.clickSouthAfrica();
		careerPage.clickSQALead();
	}
	
	@Test(dataProvider="Sheet1", dataProviderClass = DataProviders.class,priority=3)
	public void CompleteForm(String Name, String Email) throws Throwable {
		//Thread.sleep(50000);
		careerPage = new CareerPage();
		Log.info("Insert name on a contact form");
		careerPage.inputName(Name);
		Log.info("Insert Email address on a contact form");
		careerPage.inputEmailAddress(Email);
		Log.info("Input random cell Numbers");
		careerPage.inputCellNumber();
		Log.info("Click submit button");
		careerPage.clickSubmitButton();
		Thread.sleep(10000);
		Log.info("Verify the text is the expected outcome");
		boolean result = careerPage.validateErrorMessage();
		Assert.assertTrue(result);
	}
	
	@AfterTest()
	public void tearDown() {
		getDriver().quit();
	}
	
	//Scroll
	//Extent rep Screenshots
	//Multiple browsers
	//Verify last text*
	//WAITS*
	//Clean*
	

}
