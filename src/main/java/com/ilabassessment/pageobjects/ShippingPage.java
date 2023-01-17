/**
 * 
 */
package com.ilabassessment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.base.BaseClass;

/**
 * @author znemadodzi
 *
 */
public class ShippingPage extends BaseClass {

	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() {
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut(){
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

	
}
