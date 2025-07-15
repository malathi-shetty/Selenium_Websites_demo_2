package fluent_wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait_Example_With_Lambda_Expression {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();
		
		  FluentWait<WebDriver> wait = new FluentWait<>(driver)
                  .withTimeout(Duration.ofSeconds(30))
                  .pollingEvery(Duration.ofSeconds(5))
                  .ignoring(NoSuchElementException.class);

          // Wait for the dropdown element
          WebElement dropdownElement = wait.until(d -> {
              WebElement el = d.findElement(By.id("dropdown"));
              return (el.isDisplayed() && el.isEnabled()) ? el : null;
          });

          // Interact with the dropdown
          Select dropdown = new Select(dropdownElement);
          dropdown.selectByVisibleText("Option 1"); // Replace with the actual option you want to select

          System.out.println("Dropdown option selected successfully.");
        driver.quit();

	}

}
