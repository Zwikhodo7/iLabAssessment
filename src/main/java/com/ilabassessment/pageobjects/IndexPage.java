/**
 * 
 */
package com.ilabassessment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author znemadodzi
 *
 */
public class IndexPage extends BaseClass {
	

	@FindBy(xpath = "//ul[@id='top-menu']//a[.='Get in Touch']")
	WebElement GetInTouch;

	@FindBy(xpath = "//a[.='Career Opportunities']")
	WebElement CareerOpportunities;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void hoverOnGetInTouch() {
		Action.mouseOverElement(getDriver(), GetInTouch);
		//return new LoginPage();
	}
	
	public CareerPage clickCareerOpportunities() {
		Action.click(getDriver(), CareerOpportunities);
		return new CareerPage();
	}
}
