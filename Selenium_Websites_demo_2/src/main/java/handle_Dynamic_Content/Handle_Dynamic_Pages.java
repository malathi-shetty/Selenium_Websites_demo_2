package handle_Dynamic_Content;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Dynamic_Pages {

	public static void main(String[] args) throws TimeoutException {
		WebDriver driver;

		// Setup WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");

		try {
			Thread.sleep(5000); // Wait for 5 seconds
			// Wait for the first element to be present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.linkText("Example 1: Element on page that is hidden"))).click();
			System.out.println("Element 1 found");
			Thread.sleep(5000); // Wait for 5 seconds
			// Click the Start Button
			driver.findElement(By.xpath("//button")).click();
			Thread.sleep(10000); // Wait for 5 seconds

			driver.navigate().back();
			Thread.sleep(3000); // Wait for 5 seconds
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			// Wait for the second element to be clickable
			wait1.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Example 2"))).click();
			System.out.println("Element 2 found");
			Thread.sleep(5000); // Wait for 5 seconds
			// Click the Start Button
			driver.findElement(By.xpath("//button")).click();

			// Wait to see the output before closing
			Thread.sleep(10000); // Wait for 5 seconds

		} catch (NoSuchElementException e) {
			System.out.println("No such element found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the driver
			driver.quit();
		}
	}

}

//Thread.sleep(5000); // Wait for 5 seconds or 10 seconds to check the actual working in chrome browser