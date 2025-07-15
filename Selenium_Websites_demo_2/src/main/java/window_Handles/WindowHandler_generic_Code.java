package window_Handles;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler_generic_Code {

	public static void main(String[] args) throws InterruptedException {
		// switchToWindow

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Step 1: Open the parent window
        driver.get("https://www.google.co.in/");
        
        // Store the parent window handle
        String parentWindowHandle = driver.getWindowHandle();
        
        // Cast driver to JavascriptExecutor to use executeScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        // Open a new child window
        js.executeScript("window.open('https://rahulshettyacademy.com/seleniumPractise/#/', '_blank');");
        
        // Step 2: Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        
        // Step 3: Switch to the child window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Step 4: Perform actions in the child window
        System.out.println("Switched to child window with title: " + driver.getTitle());
        
        // Optionally perform some actions in the child window
        // driver.findElement(By...);

        Thread.sleep(2000);
        // Step 5: Close the child window
        System.out.println("Child window closed");
        driver.close();
        
        // Step 6: Switch back to the parent window
        driver.switchTo().window(parentWindowHandle);
        System.out.println("Switched back to parent window with title: " + driver.getTitle());
        System.out.println("Parent window closed");
        // Optionally perform some actions in the parent window
        // driver.findElement(By...);
        Thread.sleep(2000);
        // Step 7: Close the parent window
        driver.quit();
	}

}
