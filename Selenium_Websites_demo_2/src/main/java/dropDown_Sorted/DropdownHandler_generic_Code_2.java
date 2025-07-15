package dropDown_Sorted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandler_generic_Code_2 {
	
	public static void main(String[] args) {

	// Setup WebDriver
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	try
	{
		// Open the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Define the dropdown locator
		By dropdownLocator = By.id("dropdown-class-example");

		// Create Select object
		Select dropdown = new Select(driver.findElement(dropdownLocator));

		// Get all options
		List<WebElement> options = getAllOptions(driver, dropdownLocator);

		// Select options by index, value, and visible text
		selectAndPrintOption(dropdown, "index", 1); // Select by index
		selectAndPrintOption(dropdown, "value", "option2"); // Select by value
		selectAndPrintOption(dropdown, "text", "Option3"); // Select by visible text

		// Print out all options for verification
		printAllOptions(options);

	}finally
	{
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

// Method to select an option and print it
public static void selectAndPrintOption(Select dropdown, String selectionType, Object value) {
    switch (selectionType.toLowerCase()) {
        case "index":
            dropdown.selectByIndex((Integer) value);
            break;
        case "value":
            dropdown.selectByValue((String) value);
            break;
        case "text":
            dropdown.selectByVisibleText((String) value);
            break;
        default:
            throw new IllegalArgumentException("Invalid selection type: " + selectionType);
    }
    printSelectedOption(dropdown);
}

// Method to print the selected option
public static void printSelectedOption(Select dropdown) {
    WebElement selectedOption = dropdown.getFirstSelectedOption();
    System.out.println("Selected option: " + selectedOption.getText());
}

// Method to print all options
public static void printAllOptions(List<WebElement> options) {
    System.out.println("Printing All Options:");
    for (WebElement option : options) {
        System.out.println(option.getText());
    }
}
}
