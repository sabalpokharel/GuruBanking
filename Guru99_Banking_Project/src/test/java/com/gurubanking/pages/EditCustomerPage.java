package com.gurubanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class EditCustomerPage extends TestBase{

	@FindBy(xpath="//p[contains(text(),'Edit Customer Form')]")
	WebElement EditcustomerFormText;
	
	@FindBy(name="cusid")
	WebElement CustomerId;
	
	@FindBy(name="AccSubmit")
	WebElement SubmitBtn;
	
	@FindBy(name="res")
	WebElement ResetBtn;
	
	@FindBy(xpath="//p[contains(text(),'Edit Customer')]")
	WebElement EditcustomerText;
	
	
	public EditCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean editCustomerFormText()
	{
		boolean result= EditcustomerFormText.isDisplayed();
		return result;
	}
	
	public boolean enterCustomeridAndSubmit(String Id)
	{
		CustomerId.sendKeys(Id);
		SubmitBtn.click();
		
		boolean result= EditcustomerText.isDisplayed();
		return result;
	}
	
	
	
	
	
}
