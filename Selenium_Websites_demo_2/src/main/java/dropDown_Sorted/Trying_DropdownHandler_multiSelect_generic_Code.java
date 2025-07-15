package dropDown_Sorted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Trying_DropdownHandler_multiSelect_generic_Code {

	 WebDriver driver;
	    WebDriverWait wait;

	    public Trying_DropdownHandler_multiSelect_generic_Code(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	    public void openDropdown(By dropdownLocator) {
	        System.out.println("Opening the dropdown...");
	        try {
	            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	            dropdown.click();
	        } catch (Exception e) {
	            System.out.println("Error opening dropdown: " + e.getMessage());
	        }
	    }

	    public void printAllOptions(By optionLocator) {
	        System.out.println("Printing all options...");
	        try {
	            List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(optionLocator));
	            if (options.isEmpty()) {
	                System.out.println("No options found.");
	            } else {
	                for (WebElement option : options) {
	                    System.out.println("Option: " + option.getText());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error printing options: " + e.getMessage());
	        }
	    }

	    public void selectOption(By optionLocator, String optionText) {
	        System.out.println("Selecting option: " + optionText);
	        try {
	            List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(optionLocator));
	            boolean found = false;
	            for (WebElement option : options) {
	                if (option.getText().contains(optionText)) {
	                    option.click();
	                    System.out.println("Option '" + optionText + "' selected.");
	                    found = true;
	                    break;
	                }
	            }
	            if (!found) {
	                System.out.println("Option '" + optionText + "' not found.");
	            }
	        } catch (Exception e) {
	            System.out.println("Error selecting option: " + e.getMessage());
	        }
	    }

	    public boolean isOptionSelected(By selectedOptionLocator, String optionText) {
	        System.out.println("Checking if option is selected: " + optionText);
	        try {
	            List<WebElement> selectedOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectedOptionLocator));
	            for (WebElement option : selectedOptions) {
	                if (option.getText().contains(optionText)) {
	                    System.out.println("Option '" + optionText + "' is selected.");
	                    return true;
	                }
	            }
	            System.out.println("Option '" + optionText + "' is not selected.");
	            return false;
	        } catch (Exception e) {
	            System.out.println("Error checking if option is selected: " + e.getMessage());
	            return false;
	        }
	    }

    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.mobiscroll.com/jquery/select/multiple-select#");

        // Initialize the handler
        Trying_DropdownHandler_multiSelect_generic_Code handler = new Trying_DropdownHandler_multiSelect_generic_Code(driver);

        // Open the dropdown
        By dropdownLocator = By.xpath("//div[contains(@class, 'mbsc-select')]");
        handler.openDropdown(dropdownLocator);

        // Print all options
        By optionLocator = By.xpath("//div[contains(@class, 'mbsc-select-opt')]");
        handler.printAllOptions(optionLocator);

        // Select options
        handler.selectOption(optionLocator, "Toys, Kids & Baby");

        // Verify if the option is selected
        By selectedOptionLocator = By.xpath("//div[contains(@class, 'mbsc-select-opt-selected')]");
        handler.isOptionSelected(selectedOptionLocator, "Toys, Kids & Baby");

        // Close the browser
        System.out.println("Closing the browser...");
        driver.quit();
        System.out.println("Browser closed.");
	    }
	}