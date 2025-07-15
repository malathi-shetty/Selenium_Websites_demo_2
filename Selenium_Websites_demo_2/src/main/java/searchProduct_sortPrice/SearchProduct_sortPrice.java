package searchProduct_sortPrice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchProduct_sortPrice {
	
	//PENDING

	// Search for products find common elements for all the prices then sort the
	// prices then click on highest price element or lowest price element or 3rd ,
	// 2nd largest or smallest price

	public static void main(String[] args) {
		// Setup WebDriver Manager for Chrome
		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		driver.manage().window().maximize();

		try {
			// Search on Amazon
			searchAndFindProduct(driver, wait, "https://www.amazon.in", "Apple iPhone 15 Pro",
					"Apple iPhone 15 Pro (128 GB) - Natural Titanium");

			// Search on Flipkart
			searchAndFindProduct(driver, wait, "https://www.flipkart.com", "Apple iPhone 15 Pro",
					"Apple iPhone 15 Pro (128 GB) - Natural Titanium");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Quit the driver
			driver.quit();
		}
	}

	private static void searchAndFindProduct(WebDriver driver, WebDriverWait wait, String baseUrl, String searchQuery,
			String targetProduct) {
		driver.get(baseUrl);

		WebElement searchBox;
		WebElement searchButton;

		if (baseUrl.contains("amazon")) {
			searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
			searchButton = driver.findElement(By.id("nav-search-submit-button"));
		} else {
			searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
			searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
		}

		searchBox.sendKeys(searchQuery);
		searchButton.click();

		// Wait for search results to load
		if (baseUrl.contains("amazon")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot")));
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1AtVbE")));
		}

		// Find and click the specific product
		WebElement product = findProductByKeywords(driver, targetProduct, baseUrl.contains("amazon"));
		if (product != null) {
			product.click();
			System.out.println("Product found and clicked: " + targetProduct);
		} else {
			System.out.println("Product not found: " + targetProduct);
		}
	}

	private static WebElement findProductByKeywords(WebDriver driver, String keywords, boolean isAmazon) {
		List<WebElement> productElements;

		if (isAmazon) {
			productElements = driver.findElements(By.xpath("//span[contains(text(), '" + keywords + "')]"));
		} else {
			productElements = driver.findElements(By.xpath("//a[contains(text(), '" + keywords + "')]"));
		}

		for (WebElement element : productElements) {
			String productName = normalizeProductName(element.getText());
			if (productName.contains(normalizeProductName(keywords))) {
				return element;
			}
		}
		return null;
	}

	public static String normalizeProductName(String name) {
		// Convert to lower case and remove extra spaces
		name = name.toLowerCase().trim();
		// Remove anything within parentheses and the parentheses themselves
		name = name.replaceAll("\\(.*?\\)", "").trim();
		// Remove multiple spaces
		name = name.replaceAll("\\s+", " ");
		return name;
	}
}
