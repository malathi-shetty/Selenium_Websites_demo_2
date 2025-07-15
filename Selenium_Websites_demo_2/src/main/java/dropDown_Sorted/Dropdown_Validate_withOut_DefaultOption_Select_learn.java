package dropDown_Sorted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Validate_withOut_DefaultOption_Select_learn {

	public static void main(String[] args) {
	//	 String[] expectedOptions = {"Option1", "Option2", "Option3"}; - Select is not added

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

	            // Expected options
	            String[] expectedOptions = {"Option1", "Option2", "Option3"};

	            // Get all options from the dropdown
	            List<WebElement> options = dropdown.getOptions();

	            // Validate options
	            for (int i = 0; i < options.size(); i++) {
	                String optionText = options.get(i).getText();
	                if (i < expectedOptions.length) {
	                    if (optionText.equals(expectedOptions[i])) {
	                        System.out.println("Option validated: " + optionText);
	                    } else {
	                        System.out.println("Validation failed for option: " + optionText);
	                    }
	                } else {
	                    System.out.println("Unexpected option found: " + optionText);
	                }
	            }
	        } finally {
	            // Close the browser
	            driver.quit();
	        }

	}

}
