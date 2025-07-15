package fluent_wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait_Example_Ignoring_Specific_Exceptions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		driver.manage().window().maximize();
		
		 // Set up FluentWait with specific exceptions to ignore
		 FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(5))
	                .ignoring(NoSuchElementException.class)
	                .ignoring(ElementNotInteractableException.class);

	        WebElement elementA = wait.until(d -> d.findElement(By.id("column-a")));
	        
	        WebElement elementB = wait.until(d -> d.findElement(By.id("column-b")));

	        // Perform actions with the element
	        // Perform drag-and-drop
	        Actions ac = new Actions(driver);
	        ac.dragAndDrop(elementA, elementB).perform();

	        System.out.println("Drag-and-drop action performed successfully.");
	        
	        driver.quit();

	}

}
