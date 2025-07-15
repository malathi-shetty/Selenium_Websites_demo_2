package openNewWindow;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.*;

public class TwoTabTest {
	public static void main(String[] args) throws InterruptedException {
		openNewWindow();
	}

	public static void openNewWindow() throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        try {
	            // Open first website (Swiggy)
	            driver.get("https://www.swiggy.com/restaurants");
	            wait.until(ExpectedConditions.titleContains("Order") // or "Swiggy"
	            );

	            // Validate Swiggy page loaded
	            String swiggyTitle = driver.getTitle();
	            System.out.println("Swiggy page title: " + swiggyTitle);
	            if (!swiggyTitle.toLowerCase().contains("swiggy")) {
	                throw new AssertionError("Swiggy page did not load correctly.");
	            }

	            // Store original tab
	            String originalTab = driver.getWindowHandle();

	            // Open new tab and go to Zomato
	            ((JavascriptExecutor) driver).executeScript("window.open('https://www.zomato.com/', '_blank');");

	            // Switch to new tab
	            Set<String> handles = driver.getWindowHandles();
	            for (String handle : handles) {
	                if (!handle.equals(originalTab)) {
	                    driver.switchTo().window(handle);
	                    System.out.println("Switched to Zomato tab: " + handle);

	                    // Wait for Zomato to load
	                    wait.until(ExpectedConditions.titleContains("Zomato"));

	                    // Validate Zomato page loaded
	                    String zomatoTitle = driver.getTitle();
	                    System.out.println("Zomato page title: " + zomatoTitle);
	                    if (!zomatoTitle.toLowerCase().contains("zomato")) {
	                        throw new AssertionError("Zomato page did not load correctly.");
	                    }
	                    break;
	                }
	            }

	        } catch (TimeoutException e) {
	            System.err.println("Timeout while loading page: " + e.getMessage());
	        } catch (AssertionError ae) {
	            System.err.println("Assertion failed: " + ae.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }

}
