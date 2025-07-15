package dropDown_Sorted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandler_multiSelect_generic_Code {

	 WebDriver driver;
	    WebDriverWait wait;

	    public DropdownHandler_multiSelect_generic_Code(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
	    }

	    // Method to click on the dropdown to open it
	    public void openDropdown(By dropdownLocator) {
	        System.out.println("Opening the dropdown...");
	        try {
	            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	            dropdown.click();
	        } catch (Exception e) {
	            System.out.println("Error opening dropdown: " + e.getMessage());
	        }
	    }

	    // Method to select an option from the dropdown
	    public void selectOption(By optionLocator, String optionText) {
	        System.out.println("Selecting option: " + optionText);
	        List<WebElement> options = driver.findElements(optionLocator);
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
	    }

	    // Method to verify if an option is selected
	    public boolean isOptionSelected(By selectedOptionLocator, String optionText) {
	        List<WebElement> selectedOptions = driver.findElements(selectedOptionLocator);
	        for (WebElement option : selectedOptions) {
	            if (option.getText().contains(optionText)) {
	                System.out.println("Option '" + optionText + "' is selected.");
	                return true;
	            }
	        }
	        System.out.println("Option '" + optionText + "' is not selected.");
	        return false;
	    }

	    public static void main(String[] args) {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.mobiscroll.com/jquery/select/multiple-select#");

	        // Initialize the handler
	        DropdownHandler_multiSelect_generic_Code handler = new DropdownHandler_multiSelect_generic_Code(driver);

	        //document.querySelector('#multiple-select-context') // type in console
	        // Open the dropdown
	        By dropdownLocator = By.cssSelector("#multiple-select-context"); // Updated selector
	        handler.openDropdown(dropdownLocator);

	        // Select options
	     //   By optionLocator = By.xpath("//div[@role='listbox']//div[@role='option' and contains(text(), 'Toys, Kids & Baby')]");
	        By optionLocator =  By.xpath("//option[@value='6']");
	        handler.selectOption(optionLocator, "Toys, Kids & Baby");

	        // Verify if the option is selected
	        By selectedOptionLocator = By.xpath("//option[contains(text(), 'Toys, Kids & Baby')]");
	        handler.isOptionSelected(selectedOptionLocator, "Toys, Kids & Baby");

	        // Close the browser
	        System.out.println("Closing the browser...");
	        driver.quit();
	        System.out.println("Browser closed.");
	    }

	
	}
