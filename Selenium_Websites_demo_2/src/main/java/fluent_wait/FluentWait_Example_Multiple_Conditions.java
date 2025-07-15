package fluent_wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait_Example_Multiple_Conditions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/checkboxes");
		driver.manage().window().maximize();
		
		 FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(5))
	                .ignoring(NoSuchElementException.class);

	        WebElement element = wait.until(d -> {
	            WebElement el = d.findElement(By.id("checkbox2"));
	            return (el.isDisplayed() && el.isEnabled()) ? el : null;
	        });

	        // Perform actions with the element
	        // Check if the element was found before attempting to click
	        if (element != null) {
	            element.click();
	            System.out.println("Checkbox clicked successfully.");
	        } else {
	            System.out.println("Checkbox was not found or not interactable.");
	        }
	        
	        driver.quit();

	}

}
