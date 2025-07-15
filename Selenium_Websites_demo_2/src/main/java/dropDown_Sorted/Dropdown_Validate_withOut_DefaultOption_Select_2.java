package dropDown_Sorted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Dropdown_Validate_withOut_DefaultOption_Select_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();

		        try {
		            // Open the URL
		            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		            // Locate the dropdown element by its ID
		            Select select = new Select(driver.findElement(By.id("dropdown-class-example")));

		            // Get all options from the dropdown
		            List<WebElement> options = select.getOptions();
		            String[] expectedOptions = {"Option1", "Option2", "Option3"};

		            // Print all dropdown options for debugging
		            System.out.println("Dropdown options:");
		            for (WebElement option : options) {
		                System.out.println(option.getText());
		            }

		            // Validate options
		            for (int i = 0; i < options.size(); i++) {
		                String actualOption = options.get(i).getText();
		                Assert.assertEquals("Option mismatch at index " + i, expectedOptions[i], actualOption);
		            }
		        } finally {
		            // Close the browser
		            driver.quit();

	}

	}}
