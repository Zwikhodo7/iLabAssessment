package com.ilabassessment.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ilabassessment.base.BaseClass;
import com.ilabassessment.dataprovider.DataProviders;
import com.ilabassessment.pageobjects.CareerPage;
import com.ilabassessment.pageobjects.HomePage;
import com.ilabassessment.pageobjects.IndexPage;
import com.ilabassessment.pageobjects.LoginPage;

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
		indexPage = new IndexPage();
		Thread.sleep(10000);
		indexPage.hoverOnGetInTouch();
		careerPage=indexPage.clickCareerOpportunities();
		
	}
	
	@Test(priority=2)
	public void completeForm() throws Throwable {
		Thread.sleep(10000);
		careerPage.clickSouthAfrica();
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
	//Repo sharing
	//Loggings
	//Extent rep Loggings
}
