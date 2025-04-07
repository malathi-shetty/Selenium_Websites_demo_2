package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3_Synchronization_with_Explicit_wait {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverWait wait;
		// Initialize ChromeDriver
		driver = new ChromeDriver();
driver.manage().window().maximize();
		// Navigate to the login page
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println("Navigated to the login page.");
		// Thread.sleep(2000); // Delay for 2 seconds to observe the navigation
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Enter username and password
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		System.out.println("Entered username and password.");
		// Thread.sleep(1000); // Delay for 1 second to observe input
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Select the radio button
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		System.out.println("Selected radio button.");
		// Thread.sleep(1000); // Delay for 1 second to observe the selection
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		// Explicit wait for the "Okay" button to be visible and click it
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		System.out.println("Clicked on the 'Okay' button.");
		// Thread.sleep(2000); // Delay for 2 seconds to observe the button click
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Select an option from the dropdown
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(options);
		dropdown.selectByValue("consult");
		System.out.println("Selected 'Consult' from dropdown.");
		// Thread.sleep(1000); // Delay for 1 second to observe the dropdown action
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Click the Sign In button
		driver.findElement(By.id("signInBtn")).click();
		System.out.println("Clicked on the 'Sign In' button.");
		// Thread.sleep(2000); // Delay for 2 seconds to observe the login process
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Wait for the Checkout link to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		System.out.println("Checkout link is visible.");
		// Thread.sleep(1000); // Delay for 1 second to observe the checkout link
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		// Find and click on all products to add them to the cart
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		System.out.println("Found " + products.size() + " products.");
		// Thread.sleep(1000); // Delay for 1 second to observe the products found
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		

		for (int i = 0; i < products.size(); i++) {
			products.get(i).click();
			System.out.println("Clicked on product " + (i + 1) + " to add to cart.");
			// Thread.sleep(1500); // Delay for 1.5 seconds to observe adding each product
			// to the cart
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		}

		// Click on Checkout link to go to the checkout page
		driver.findElement(By.partialLinkText("Checkout")).click();
		System.out.println("Clicked on 'Checkout' to proceed.");
		// Thread.sleep(2000); // Delay for 2 seconds to observe the checkout page
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Close the browser
		driver.quit();
		System.out.println("Browser closed.");
	}
}
