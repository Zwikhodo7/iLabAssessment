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
import com.ilabassessment.pageobjects.AccountCreationPage;
import com.ilabassessment.pageobjects.HomePage;
import com.ilabassessment.pageobjects.IndexPage;
import com.ilabassessment.pageobjects.LoginPage;

/**
 * @author znemadodzi
 *
 */
public class AccountCreationPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;
    
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
	
	@Test(groups ="Sanity")
	public void verifyCreateAccountPageTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("zwikhodoi@gmail.com");
		boolean result = accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		Thread.sleep(10000);

	}
}
