package com.ilabassessment.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.base.BaseClass;

public class CareerPage extends BaseClass{

	@FindBy(xpath="//a[.='South Africa']")
	private WebElement SouthAfrica;
	
	@FindBy(xpath="//a[.='Software Quality Assurance (SQA) Lead']")
	private WebElement SQALead;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstNameField;

	@FindBy(name="//input[@name='email']")
	private WebElement EmailField;
	
	@FindBy(name="//input[@name='phone']")
	private WebElement PhoneField;
	
	@FindBy(name="//label[@class='hs-error-msg']")
	private WebElement ErrorMessage;
	
	@FindBy(name="//input[@class='hs-button primary large']")
	private WebElement SubmitButton;
	
	public CareerPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickSouthAfrica() throws InterruptedException {
		//Action.scrollByVisibilityOfElement(getDriver(),SouthAfrica);
		Thread.sleep(10000);
		Action.click(getDriver(), SouthAfrica);
	}
	
	public void inputName(String FirstName)throws Throwable {
		Action.type(FirstNameField, FirstName);
	}
	
	public void inputEmailAddress(String EmailAddress)throws Throwable {
		Action.type(EmailField, EmailAddress);
	}
	
	public void inputCellNumber(String EmailAddress)throws Throwable {
		//Action.type(EmailField, EmailAddress);
		//You need to randomize
	}
	
	public void clickSubmitButton() {
		Action.click(getDriver(), SubmitButton);
	}
	
	public boolean validateErrorMessage() {
		return Action.isDisplayed(getDriver(), ErrorMessage);
	}
}
