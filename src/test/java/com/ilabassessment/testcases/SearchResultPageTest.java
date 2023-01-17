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
import com.ilabassessment.pageobjects.IndexPage;
import com.ilabassessment.pageobjects.SearchResultsPage;

/**
 * @author znemadodzi
 *
 */
public class SearchResultPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultsPage searchResultPage;
	
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
	
	@Test(groups ="Smoke")
	public void productAvailabilityTest() throws Throwable {
		index = new IndexPage();
		searchResultPage= index.searchProduct("t-shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
	}
}
