package ssl_Certificates;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeExample_1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        System.out.println("ChromeDriver set up successfully.");

        // Create ChromeOptions
        ChromeOptions options = new ChromeOptions();
      
        
        options.addArguments("--headless"); // Correct way to set headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1080,500"); // Set window size
        options.addArguments("--no-sandbox"); // Recommended for certain environments
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
        options.addArguments("--remote-debugging-port=9222");

        // Set page load strategy
     //   options.setPageLoadStrategy(PageLoadStrategy.EAGER); // or PageLoadStrategy.NORMAL
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        
        WebDriver driver = new ChromeDriver(options);
        
        System.out.println("ChromeDriver instance created.");

        try {
            // Initial screenshot before navigation
            File initialScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(initialScreenshot, new File("initial_screenshot.png"));
            System.out.println("Initial screenshot taken.");

          //  System.out.println("Navigating to: https://formy-project.herokuapp.com/form");
          //  driver.get("https://formy-project.herokuapp.com/form");
            
            System.out.println("Navigating to: https://rahulshettyacademy.com/AutomationPractice/");
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            // Wait for the heading to be visible
            System.out.println("Waiting for heading to be visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

            System.out.println("Page title is: " + driver.getTitle());
            System.out.println("Heading text: " + element.getText());

            // Post-load screenshot
            File postLoadScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(postLoadScreenshot, new File("post_load_screenshot.png"));
            System.out.println("Post-load screenshot taken.");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("ChromeDriver closed.");
        }
    }
}
