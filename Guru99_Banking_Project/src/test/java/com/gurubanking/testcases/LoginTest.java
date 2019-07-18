package com.gurubanking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gurubanking.pages.LoginPage;
import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;

public class LoginTest extends TestBase {
	
	LoginPage login;
	ReadConfigFile readconfig=new ReadConfigFile();
	
	/*@BeforeMethod
	public void beforetest()
	{
		setup("browser");
	}*/
	
	@Test
	public void validLoginTest()
	{
		
		login = new LoginPage();
		String actual=login.login(readconfig.getUsername(),readconfig.getPassword());
		
		String username= readconfig.getUsername();
		String expecetd = "Manger I : "+username;
		
		Assert.assertEquals(actual, expecetd);
		}
	
	
	@Test
	public void resetCredentialsTest()
	{
		login = new LoginPage();
		login.reset(readconfig.getUsername(),readconfig.getPassword());
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			captureScreen(driver, result.getMethod().getMethodName());
			System.out.println(result.getMethod().getMethodName()+" Failed");
			
		}
		driver.quit();
	}

}
