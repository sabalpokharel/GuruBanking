package com.gurubanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gurubanking.pages.EditCustomerPage;
import com.gurubanking.pages.HomePage;

import selenium.framework.testbase.TestBase;
import selenium.framework.utilities.ReadConfigFile;

public class EditCustomerTest extends TestBase {

	HomePage homepage;
	EditCustomerPage editcustomer;
	ReadConfigFile readconfig = new ReadConfigFile();

	@Test
	public void verifyEditCustomerForm() {
		homepage = Login();
		editcustomer = homepage.EditCustomer();
		boolean actual = editcustomer.editCustomerFormText();
		Assert.assertEquals(actual, true);
	}

	@Test
	public void verifyEditCutomerSubmit() {
		homepage = Login();
		editcustomer = homepage.EditCustomer();
		boolean actualresult = editcustomer.enterCustomeridAndSubmit(readconfig.getCustomerId());
		Assert.assertEquals(true, actualresult);
		
	}

	// sabal pokharel

	// 10:07 commmit

	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			captureScreen(driver, result.getMethod().getMethodName());
			System.out.println(result.getMethod().getMethodName() + " Failed");

		}
		driver.quit();
	}

}
