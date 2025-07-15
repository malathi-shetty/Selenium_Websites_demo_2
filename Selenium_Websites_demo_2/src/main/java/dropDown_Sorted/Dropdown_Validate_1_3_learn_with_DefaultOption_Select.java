package dropDown_Sorted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Validate_1_3_learn_with_DefaultOption_Select {
	// Tried Assert.assertEquals

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			// Open the URL
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");

			// Locate the dropdown element by its ID
			WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));

			// Create a Select object to interact with the dropdown
			Select dropdown = new Select(dropdownElement);

			// Expected options including the placeholder
			 String[] expectedOptions = { "Select", "Option1", "Option2", "Option3" };
		//	String[] expectedOptions = { "Select", "Option2", "Option3" };

			// Get all options from the dropdown
			List<WebElement> options = dropdown.getOptions();

			// Print the number of options retrieved
			System.out.println("Number of options retrieved: " + options.size());
			System.out.println("Number of expected options: " + expectedOptions.length);
			System.out.println("");

			 // Assert the size of options
            Assert.assertEquals(options.size(), expectedOptions.length, "Dropdown option count mismatch");

			// Validate options
			for (int i = 0; i < options.size(); i++) {
				String actualOptionText = options.get(i).getText().trim();

				String expectedOptionText = expectedOptions[i];

				// Print actual and expected values
				System.out.println("Validating option at index " + i + ":");
				System.out.println("Actual option text: " + actualOptionText);
				System.out.println("Expected option text: " + expectedOptionText);
				System.out.println(" ");

				// Assert that the actual option matches the expected option
				Assert.assertEquals(actualOptionText, expectedOptionText, "Dropdown option mismatch at index " + i);
			}

			// Print success message
			System.out.println("All dropdown options are validated successfully.");
		} finally {
			// Close the browser
			driver.quit();
		}

	}

}

/*
 * Setup: Initialize WebDriver and open the browser.
 * 
 * Navigate: Load the webpage with the dropdown.
 * 
 * Locate: Find the dropdown element.
 * 
 * Interact: Use the Select class to manage the dropdown.
 * 
 * Define Expectations: List the expected options.
 * 
 * Retrieve: Get actual options from the dropdown.
 * 
 * Assert Count: Verify the number of options matches the expectation.
 * 
 * Validate: Check that each option matches the expected value.
 * 
 * Feedback: Print success message if validation is correct.
 * 
 * Cleanup: Close the browser
 * 
 */