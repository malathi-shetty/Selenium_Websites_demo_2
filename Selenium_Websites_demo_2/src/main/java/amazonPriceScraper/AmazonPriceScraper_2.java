package amazonPriceScraper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceScraper_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("mobile phone");
		searchBox.submit();

		// Wait for results to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]")));

		// Get all mobile names
		List<WebElement> mobileNames = driver
				.findElements(By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]"));
		// Get all prices
		List<WebElement> prices = driver.findElements(By.xpath("//span[contains(@class, 'a-price-whole')]"));

		// Print names and prices
		for (int i = 0; i < mobileNames.size(); i++) {
			if (i < prices.size()) {
				String mobileName = mobileNames.get(i).getText();
				String price = prices.get(i).getText();
				// System.out.println("Mobile Name: " + mobileName + " | Price: " + price);
				System.out.println("Mobile Name: " + mobileName);
				System.out.println("Price: " + price);
			}
		}
		// Close the driver
		driver.quit();
	}
}