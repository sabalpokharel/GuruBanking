package com.gurubanking.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gurubanking.pages.HomePage;
import com.gurubanking.pages.NewCustomerPage;
import com.gurubanking.testbase.TestBase;
import com.gurubanking.utilities.ReadExcel;

public class NewCustomerTest extends TestBase {
	
	HomePage homepage;
	NewCustomerPage newcustomer;
	
	@Test(dataProvider="Testdata")
	public void verifyNewCustomer(String CustomerName,String Gender, String DOB, String Address, String City, String State,String Pin, String Mobile, String email, String Password)
	{
		homepage=Login();
		homepage.newCustomer();
		newcustomer.registerCustomer(CustomerName, Gender, DOB, Address, City, State, Pin, Mobile, email, Password);
		
		
			
	}
	
	@DataProvider(name="Testdata")
	public String[][] getData() throws IOException
	{
		
		String ExcelPath= (System.getProperty("user.dir"))+"/src/main/java/com/gurubanking/testdata/TestData.xlsx";
		int rowcount=ReadExcel.getRowCount(ExcelPath, "Sheet1");
		int colcount=ReadExcel.getCellCount(ExcelPath, "Sheet1", 1);
		String data[][]= new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=ReadExcel.getCellData(ExcelPath,"Sheet1", i, j);
					
			}
		}
		return data;
		
		
		
		
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
