/**
 * 
 */
package com.ilabassessment.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ilabassessment.base.BaseClass;
import com.ilabassessment.dataprovider.DataProviders;
import com.ilabassessment.pageobjects.AddToCartPage;
import com.ilabassessment.pageobjects.IndexPage;
import com.ilabassessment.pageobjects.SearchResultsPage;
import com.ilabassessment.utility.Log;

/**
 * @author znemadodzi
 *
 */
public class AddToCartPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		//launchApp("IE");
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = {"Regression", "Sanity"})
	public void addToCartTest() throws Throwable {
		index = new IndexPage();
		Log.startTestCase("loginTest");
		searchResultPage= index.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("Checking in");
		addToCartPage.enterQuantity("3");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		//boolean result = addToCartPage.validateAddtoCart();
		//Assert.assertTrue(result);
		 
	}
}
