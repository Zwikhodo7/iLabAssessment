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
public class AccountCreationPage extends BaseClass {


	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return Action.isDisplayed(getDriver(), formTitle);
	}
}
