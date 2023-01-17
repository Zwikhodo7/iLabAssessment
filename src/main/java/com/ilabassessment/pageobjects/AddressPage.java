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
public class AddressPage extends BaseClass {


	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}
}
