package dropDown_Sorted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandler_generic_Code_learn {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	        
	        try {
	            // Open the URL
	            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	            driver.manage().window().maximize();
	            
	         // Define the dropdown locator
	            By dropdownLocator = By.id("dropdown-class-example"); // Change this to the actual dropdown locator
	            List<WebElement> options = getAllOptions(driver, dropdownLocator);
	            
	            // // Create Select object - Select options by index, value, and visible text
	            Select dropdown = new Select(driver.findElement(dropdownLocator));
	            
	         // Select option by index
	            dropdown.selectByIndex(1); // Selects the option at index 1
	            printSelectedOption(dropdown); // Print selected option
	            
	            // Select option by value
	            dropdown.selectByValue("option2"); // Replace with actual value
	            printSelectedOption(dropdown); // Print selected option
	            
	         // Select option by visible text
	            dropdown.selectByVisibleText("Option3"); // Replace with actual visible text
	            printSelectedOption(dropdown); // Print selected option
	            
	            // Print out all options for verification
	            for (WebElement option : options) {
	                System.out.println("Printing All Options: " + option.getText());
	            }
	        } finally {
	            // Ensure the browser is closed
	            driver.quit();
	        }

	        
}
	 // Method to get all options from a dropdown
    public static List<WebElement> getAllOptions(WebDriver driver, By locator) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        return select.getOptions();
    }
    
 // Method to print the selected option
    public static void printSelectedOption(Select dropdown) {
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());
    }
}
