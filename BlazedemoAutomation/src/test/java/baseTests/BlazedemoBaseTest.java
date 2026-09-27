package baseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BlazedemoBaseTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void BrowserLaunch() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
			
	   }
	
	@Test
	public void BlazedemoTitle() {
		driver.get("https://blazedemo.com/");
		String title = driver.getTitle();
		System.out.println("Title of the page is " + title);
		Assert.assertEquals(title,  "BlazeDemo");
	}
	
	@AfterMethod
	public void end() {
		if (driver != null) {
 
			driver.close();
		}
		}
	}
	


