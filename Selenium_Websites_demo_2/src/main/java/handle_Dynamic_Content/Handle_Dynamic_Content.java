package handle_Dynamic_Content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Dynamic_Content {

	public static void main(String[] args) {

		WebDriver driver;

		// Setup WebDriver using WebDriverManager
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");

		int maxRetries = 30; // Set a maximum retry count
		boolean contentFound = false;

		for (int attempts = 1; attempts <= maxRetries; attempts++) {
			try {
				// Set wait time for the content to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

				// Wait for the element to be visible
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Inventore minima')]")));

				// If found, get the text and print it
				String text = driver.findElement(By.xpath("//div[contains(text(), 'Et molestiae')]")).getText();
				System.out.println("Text found: " + text);
				contentFound = true; // Mark that content is found
				break; // Exit the loop since content is found

			} catch (Exception e) {
				System.out.println("Attempt " + attempts + " out of " + maxRetries + " failed: " + e.getMessage());
			} finally {
				// Refresh the page
				driver.navigate().refresh();

				// Wait for the page to load completely
				try {
					Thread.sleep(2000); // Wait for 2 seconds after refreshing
				} catch (InterruptedException ie) {
					System.out.println("Sleep interrupted: " + ie.getMessage());
				}
			}
		}

		if (!contentFound) {
			System.out.println("Content not found after " + maxRetries + " attempts.");
		}

		// Close the driver
		driver.quit();
	}
}
