package com.ilabassessment.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ilabassessment.base.BaseClass;
import com.ilabassessment.dataprovider.DataProviders;
import com.ilabassessment.pageobjects.CareerPage;
import com.ilabassessment.pageobjects.IndexPage;

public class CareerJourneyTest extends BaseClass{
	IndexPage indexPage;
	CareerPage careerPage;
	
	@Parameters("browser")
	@BeforeClass(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		//launchApp("IE");
		launchApp(browser);
	}
	
	@Test(priority=1)
	public void navigateToCareer() throws Throwable {
		Thread.sleep(10000);
		indexPage = new IndexPage();
		indexPage.hoverOnGetInTouch();
		careerPage=indexPage.clickCareerOpportunities();
		
	}
	
	@Test(priority=2)
	public void completeForm() throws Throwable {
		Thread.sleep(5000);
		careerPage = new CareerPage();
		careerPage.clickSouthAfrica();
		careerPage.clickSQALead();
		careerPage.inputName(null);
		careerPage.inputEmailAddress(null);
		careerPage.inputCellNumber(null);
		careerPage.clickSubmitButton();
		boolean result = careerPage.validateErrorMessage();
		Assert.assertTrue(result);
		
	}
	
	@AfterTest()
	public void tearDown() {
		getDriver().quit();
	}
	
	//Randomize
	//Input from table data
	//Loggings
	//Extent rep Loggings
	//Multiple browsers
	
	//Repo sharing
}
