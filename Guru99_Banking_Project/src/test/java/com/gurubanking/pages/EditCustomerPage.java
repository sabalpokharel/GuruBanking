package com.gurubanking.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
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
		boolean result = false;
		try {
		CustomerId.sendKeys(Id);
		SubmitBtn.click();
		}catch(UnhandledAlertException f)
		{
			try {
				
			elements.alert(true, "UnhandledAlertException", driver);
			}catch(NoAlertPresentException e)
			{
				e.printStackTrace();
			}
		}
		result= EditcustomerText.isDisplayed();
		return result;
	}
	
	
	
	
	
}
