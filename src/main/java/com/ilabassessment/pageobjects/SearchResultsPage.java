package com.ilabassessment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class SearchResultsPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"center_column\"]//img") //Check how this xpath was made
	private WebElement productResult;
	
	public SearchResultsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		//ExtentTestManager.getTest().log(LogStatus.PASS, " displayed on " );
		return new AddToCartPage();
	}
}
