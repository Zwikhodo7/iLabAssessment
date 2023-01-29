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

	@FindBy(xpath = "(//a[.='Career Opportunities'])[1]")
	WebElement CareerOpportunities;
	
	@FindBy(xpath = "//button[@class='cky-btn cky-btn-reject']")
	WebElement rejectCookies;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void hoverOnGetInTouch() {
		Action.mouseOverElement(getDriver(), GetInTouch,"Get In Touch");
	}
	
	public CareerPage clickCareerOpportunities() {
		Action.clickElement(CareerOpportunities,"CareerOpportunities" );
		return new CareerPage();
	}
	
	public void clickrejectCookies() {
		Action.clickElement(rejectCookies,"rejectCookies");  
	}
}
