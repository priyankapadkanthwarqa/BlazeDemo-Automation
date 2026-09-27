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


public class PurchaseFlightPageTest {
	
	WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        
	        driver = new EdgeDriver();
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        
	        driver.get("https://blazedemo.com/purchase.php");
	    }

	    @Test
	    public void testFlightPurchase() {
	       
	        WebElement header = driver.findElement(By.tagName("h2"));
	        Assert.assertTrue(header.getText().contains("Your flight from TLV to SFO has been reserved."));

	        // 2. Fill out the passenger details form
	        driver.findElement(By.id("inputName")).sendKeys("Padkanthwar Priyanka");
	        driver.findElement(By.id("address")).sendKeys("Shyam Nagar, Ambejogai road");
	        driver.findElement(By.id("city")).sendKeys("Latur");
	        driver.findElement(By.id("state")).sendKeys("Maharashtra");
	        driver.findElement(By.id("zipCode")).sendKeys("413531");

	        // 3. Handle Card Type Dropdown
	        WebElement cardTypeDropdown = driver.findElement(By.id("cardType"));
	        Select selectCard = new Select(cardTypeDropdown);
	        selectCard.selectByVisibleText("Visa"); 

	        // 4. Fill payment data
	        driver.findElement(By.id("creditCardNumber")).sendKeys("1234567890123456");
	        
	        WebElement monthField = driver.findElement(By.id("creditCardMonth"));
	        monthField.clear();
	        monthField.sendKeys("11");
	        
	        WebElement year = driver.findElement(By.id("creditCardYear"));
	        year.clear();
	        year.sendKeys("2027");
	        
	        driver.findElement(By.id("nameOnCard")).sendKeys("Padkanthwar Priyanka");

	        // 5. Check "Remember me" checkbox
	        WebElement rememberMeCheckbox = driver.findElement(By.id("rememberMe"));
	        if (!rememberMeCheckbox.isSelected()) {
	            rememberMeCheckbox.click();
	        }

	        // 6. Submit the form
	        WebElement purchaseButton = driver.findElement(By.cssSelector("input[type='submit']"));
	        purchaseButton.click();

	        // 7. Simple verification of navigation to confirmation page
	        String expectedUrlSnippet = "confirmation.php";
	        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlSnippet), "Form submission did not redirect to confirmation page.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser session
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


