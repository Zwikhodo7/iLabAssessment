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
	/*
	@Test(priority=1)
	public void navigateToCareer() throws Throwable {
		Thread.sleep(10000);
		indexPage = new IndexPage();
		indexPage.hoverOnGetInTouch();
		careerPage=indexPage.clickCareerOpportunities();
		indexPage.clickrejectCookies();
		
	}
	
	
	@Test(priority=2)
	public void navigateToJobPost() throws Throwable {
		Thread.sleep(5000);
		careerPage = new CareerPage();
		careerPage.clickSouthAfrica();
		careerPage.clickSQALead();
		careerPage.inputName("Zwikhodo");
		Thread.sleep(10000);
		//careerPage.inputEmailAddress(null);
		//careerPage.inputCellNumber(null);
		//careerPage.clickSubmitButton();
		//boolean result = careerPage.validateErrorMessage();
		//Assert.assertTrue(result);
		
	}
	*/
	@Test(dataProvider="Sheet1", dataProviderClass = DataProviders.class,priority=3)
	public void CompleteForm(String Name, String Email) throws Throwable {
		Thread.sleep(50000);
		careerPage = new CareerPage();
		careerPage.inputName(Name);
		careerPage.inputEmailAddress(Email);
		//careerPage.inputCellNumber(null);
		//careerPage.clickSubmitButton();
		Thread.sleep(10000);
		//boolean result = careerPage.validateErrorMessage();
		//Assert.assertTrue(result);
		
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
