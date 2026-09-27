package PagesofBlazeDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest {
	
	/*public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		Thread.sleep(5000);
		
		Select fromcity= new Select(driver.findElement(By.name("fromPort")));
		fromcity.selectByValue("Boston");
		
		Thread.sleep(5000);
		
	    Select ToCity = new Select(driver.findElement(By.name("toPort")));
	    ToCity.selectByContainsVisibleText("New");
	    
	    Thread.sleep(5000);
	    
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		Thread.sleep(5000);
	}*/
	
	
	    
	    WebDriver driver;

	    @BeforeMethod
	    public void BrowserLaunch() {
	    
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @Test
	    public void testGoToReservePage() {
	        // 2. Go directly to the 1st page (Home Page)
	        driver.get("https://blazedemo.com");
	        
	        // 3. Find the blue "Find Flights" button and click it
	        WebElement findFlightsButton = driver.findElement(By.cssSelector("input[type='submit']"));
	        findFlightsButton.click();
	        
	        // 4. Get the current web address to make sure we moved forward
	        String currentUrl = driver.getCurrentUrl();
	        
	        // 5. Check if the URL contains "reserve.php" (the 2nd page)
	        boolean checkUrl = currentUrl.contains("reserve.php");
	        Assert.assertTrue(checkUrl);
	    }

	    @AfterMethod
	    public void tearDown() {
	        // 6. Close the browser session completely
	        driver.quit();
	    }
	}



