package com.ilabassessment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.base.BaseClass;

public class OrderSummaryPage extends BaseClass {


	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
