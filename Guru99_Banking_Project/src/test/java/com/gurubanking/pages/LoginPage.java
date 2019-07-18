package com.gurubanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.framework.testbase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="uid")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement Login;
	
	@FindBy(name="btnReset")
	WebElement Reset;
	
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String login(String uid,String pwd)
	{
		userid.sendKeys(uid);
		password.sendKeys(pwd);
		Login.click();
		
		String text = "Manger Id : "+uid;
		WebElement hometext = driver.findElement(By.xpath("//td[contains(text(),'"+ text +"')]"));
		String actual = hometext.getText();
		return actual;
	}

	
	public void reset(String uid,String pwd)
	{
		userid.sendKeys(uid);
		password.sendKeys(pwd);
		Reset.click();
		
		userid.sendKeys(uid);
		password.sendKeys(pwd);
		Login.click();
	}
}
