/**
 * 
 */
package com.ilabassessment.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ilabassessment.base.BaseClass;
import com.ilabassessment.dataprovider.DataProviders;
import com.ilabassessment.pageobjects.AddToCartPage;
import com.ilabassessment.pageobjects.AddressPage;
import com.ilabassessment.pageobjects.HomePage;
import com.ilabassessment.pageobjects.IndexPage;
import com.ilabassessment.pageobjects.LoginPage;
import com.ilabassessment.pageobjects.OderPage;
import com.ilabassessment.pageobjects.OrderConfirmationPage;
import com.ilabassessment.pageobjects.OrderSummaryPage;
import com.ilabassessment.pageobjects.PaymentPage;
import com.ilabassessment.pageobjects.SearchResultsPage;
import com.ilabassessment.pageobjects.ShippingPage;

/**
 * @author znemadodzi
 *
 */
public class PurchaseEndToEndTest extends BaseClass {

	private IndexPage index;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	private LoginPage loginPage;
	private OderPage orderPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummaryPage orderSummaryPage;
	private OrderConfirmationPage orderConfirmationPage;
	private HomePage homePage;

	
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
	
	@Test(groups = "Regression")
	public void endToEndTest(String username, String password) throws Throwable {
		index = new IndexPage();
		searchResultPage= index.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("3");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage= addToCartPage.clickOnCheckOut();
		loginPage = orderPage.clickOnCheckOut();
		homePage = loginPage.login(username,password);
		//addressPage = loginPage.login1("admin@xyz.com", "admin@123");
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickOnconfirmOrderBtn();
		String actualMsg =orderConfirmationPage.validateConfirmMessage();
		String expectedMsg = "Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);	
	}

}
