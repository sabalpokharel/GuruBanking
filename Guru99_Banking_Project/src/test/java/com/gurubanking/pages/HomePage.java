package com.gurubanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gurubanking.testbase.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	WebElement NewCustomer;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public NewCustomerPage newCustomer()
	{
		NewCustomer.click();
		return new NewCustomerPage();
	}

}
