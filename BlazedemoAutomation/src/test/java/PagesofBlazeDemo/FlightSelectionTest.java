package PagesofBlazeDemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightSelectionTest {

	WebDriver driver;

	@BeforeMethod
	public void BrowserLauch() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testSelectFlight() {

		driver.get("https://blazedemo.com/reserve.php");
		WebElement chooseFlightButton = driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr[1]/td/input"));
		chooseFlightButton.click();

		String currentUrl = driver.getCurrentUrl();
		boolean checkUrl = currentUrl.contains("purchase.php");
		Assert.assertTrue(checkUrl);

	}

	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/
}
