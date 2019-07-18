import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gurubanking.testbase.TestBase;

public class testClass extends TestBase {
	
	@BeforeMethod
	public void beforetest()
	{
		setup("browser");
		Login();
		
		
	}
	@Test
	public void test() {
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
	WebElement date = driver.findElement(By.id("dob"));
	date.sendKeys("27-02-1993");
	
	}
	

}
