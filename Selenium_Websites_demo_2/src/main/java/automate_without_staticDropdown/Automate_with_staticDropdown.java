package automate_without_staticDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_with_staticDropdown {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	        driver.manage().window().maximize();
	        
	        // Locate the dropdown element
	        WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
	        
	        // Create a Select object and pass the dropdown WebElement to it
	        Select dropdown = new Select(dropdownElement);
	        
	        // Loop through the options and select the one with the text "Option3"
	        for (WebElement option : dropdown.getOptions()) {
	            if (option.getText().equalsIgnoreCase("Option3")) {
	                dropdown.selectByVisibleText("Option3");
	                break;
	            }
	        }

	        // Optionally, you can verify the selected option
	        WebElement selectedOption = dropdown.getFirstSelectedOption();
	        System.out.println("Selected option: " + selectedOption.getText());

	        // Close the browser
	        driver.quit();

	}

}
