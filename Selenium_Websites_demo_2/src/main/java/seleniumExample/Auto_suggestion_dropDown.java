package seleniumExample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auto_suggestion_dropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Open the target website
			driver.get("https://demo.automationtesting.in/AutoComplete.html");// Replace with the URL of your website

			// Wait for the search input field to be visible
			WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']//input[@id='searchbox']")));

			// Clear the input field (if needed)
			searchBox.clear();

			// Send a query to the search box
			searchBox.sendKeys("Can"); // Enter part of the text for auto-suggestions

			// Wait for the auto-suggestions to appear
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-menu-item")));

			// Locate the list of auto-suggestions
			List<WebElement> suggestions = driver.findElements(By.className("ui-menu-item")); // Correct class for
																								// suggestions

			// Print out all suggestions for debugging
			System.out.println("Suggestions:");
			for (WebElement suggestion : suggestions) {
				System.out.println(suggestion.getText());
			}
			System.out.println(" ");
			// Select a specific suggestion if it matches the expected text
			String desiredSuggestion = "India"; // Update to match the expected suggestion
			boolean suggestionFound = false;

			for (WebElement suggestion : suggestions) {
				String text = suggestion.getText();
				System.out.println("Checking suggestion: " + text); // Print each suggestion being checked
				if (text.equals(desiredSuggestion)) {
					suggestion.click();
					suggestionFound = true;
					break;
				}
			}
			System.out.println(" ");
			if (!suggestionFound) {
				System.out.println("Desired suggestion not found: " + desiredSuggestion);
			}

		} finally {
			// Close the browser
			driver.quit();
		}

	}

}
