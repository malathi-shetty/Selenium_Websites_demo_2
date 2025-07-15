package fluent_wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait_Example_Basic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/");
		driver.manage().window().maximize();

		// Set up FluentWait
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		// Wait for the search input to be present
		WebElement searchInput = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("search-input"));
			}
		});

		// Now interact with the element
		searchInput.sendKeys("Hi");

		// Optionally wait for another element to click (example)
		WebElement searchButton = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("search-button")); // Adjust according to the actual ID
			}
		});

		searchButton.click();
		System.out.println("Button CLicked successfully");

		driver.quit();
	}
}
