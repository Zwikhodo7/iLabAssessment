package com.ilabassessment.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.base.BaseClass;

public class CareerPage extends BaseClass{

	@FindBy(xpath="//a[.='South Africa']")
	private WebElement SouthAfrica;
	
	@FindBy(xpath="//a[.='Software Quality Assurance (SQA) Lead']")
	private WebElement SQALead;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstNameField;

	@FindBy(xpath="//input[@id='email-91269253-d0ea-4409-a821-873cda679554']")
	private WebElement EmailField;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement PhoneField;
	
	@FindBy(xpath="//label[@class='hs-error-msg']")
	private WebElement ErrorMessage;
	
	@FindBy(xpath="//input[@class='hs-button primary large']")
	private WebElement SubmitButton;
	
	public CareerPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void scrolldown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);",SouthAfrica);
		}
	
	public void clickSouthAfrica() {
		Action.scrollByVisibilityOfElement(getDriver(),SouthAfrica);
		Action.JSClick(getDriver(), SouthAfrica, "South Africa");  
	}
	
	public void clickSQALead(){
		
		Action.clickElement(SQALead, "SQALead");
	}
	
	public void inputName(String FirstNames)throws Throwable {
	//	Action.scrollByVisibilityOfElement(getDriver(), FirstNameField);
		Action.switchToFrameById(getDriver(),"hs-form-iframe-0");
		Action.type(FirstNameField,FirstNames);
		getDriver().switchTo().defaultContent();
		
	}
	
	public void inputEmailAddress(String EmailAddress)throws Throwable {
		Action.switchToFrameById(getDriver(),"hs-form-iframe-0");
		Action.type(EmailField, EmailAddress);
		getDriver().switchTo().defaultContent();
	}
	
	public void inputCellNumber()throws Throwable {
		
			double r = Math.random()*1000000000+1;
			int x = (int)r;
			Action.switchToFrameById(getDriver(),"hs-form-iframe-0");
			Action.type(PhoneField, "0"+x);
			test.log(Status.PASS, "0"+x+" was generated");
			System.out.print("0"+x +"was generated");
			getDriver().switchTo().defaultContent();
	}
	
	public void clickSubmitButton() {
		Action.switchToFrameById(getDriver(),"hs-form-iframe-0");
		Action.scrollByVisibilityOfElement(getDriver(),SubmitButton);
		Action.JSClick(getDriver(), SubmitButton,"Submit Button"); 
		getDriver().switchTo().defaultContent();

	}
	
	public boolean validateErrorMessage() {
		Action.switchToFrameById(getDriver(),"hs-form-iframe-0");
		Action.scrollByVisibilityOfElement(getDriver(),ErrorMessage);
		return Action.isDisplayed(getDriver(), ErrorMessage);

	}
}
