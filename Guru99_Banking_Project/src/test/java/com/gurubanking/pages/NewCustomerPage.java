package com.gurubanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class NewCustomerPage extends TestBase {
	

	@FindBy(name = "name")
	WebElement CustomerName;
	
	@FindBy(xpath = "//input[@type= 'radio' and @value='m']")
	WebElement Gender_male;
	
	@FindBy(xpath = "//input[@type= 'radio' and @value='f']")
	WebElement Gender_female;
	
	@FindBy(id = "dob")
	WebElement DOB;
	
	@FindBy(name = "addr")
	WebElement Address;
	
	@FindBy(name = "city")
	WebElement City;
	
	@FindBy(name = "state")
	WebElement State;
	
	@FindBy(name = "pinno")
	WebElement PinNumber;
	
	@FindBy(name = "telephoneno")
	WebElement TelNo;
	
	@FindBy(name = "emailid")
	WebElement Email;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(name = "sub")
	WebElement Submit;
	
	@FindBy(name = "res")
	WebElement Reset;
	
	@FindBy(xpath="//p[contains(text(),'Customer Registered Successfully!!!')]")
	WebElement registerSucessMsg;
	
	
	public NewCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean registerCustomer(String name,String Gender, String dob, String address, String city, String state,String pin, String mobile, String email, String password) {
		
		CustomerName.sendKeys(name);
		
		if(Gender.equals("Male")) {
			Gender_male.click();}
		
		else if(Gender.equals("Female")) {
			Gender_female.click();}
		
		DOB.sendKeys(dob);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		PinNumber.sendKeys(pin);
		TelNo.sendKeys(mobile);
		Email.sendKeys(email);
		Password.sendKeys(password);
		
		Submit.click();
		boolean result= registerSucessMsg.isDisplayed();
		return result;	
		
	}
	
	public String clickSubmitWithoutData()
	{
		Submit.click();
		String alertMessage=elements.switchToAlert(driver);
		return alertMessage;
	}

}
