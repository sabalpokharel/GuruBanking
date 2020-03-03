package com.gurubanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	WebElement NewCustomer;
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement EditCustomer;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public NewCustomerPage newCustomer()
	{
		NewCustomer.click();
		return new NewCustomerPage();
	}
	
	public EditCustomerPage EditCustomer()
	{
		EditCustomer.click();
		return new EditCustomerPage();
	}

}
