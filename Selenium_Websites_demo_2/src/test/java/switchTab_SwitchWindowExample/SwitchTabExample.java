package switchTab_SwitchWindowExample;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTabExample {

	public static void main(String[] args) throws InterruptedException {
		// Set up the WebDriver (assuming ChromeDriver is used)
        WebDriver driver;

        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the URL
        System.out.println("Navigating to the first URL...");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        // Store the window handle of the first tab (current window)
        String originalWindow = driver.getWindowHandle();
        System.out.println("Original window handle: " + originalWindow);

        // Open a new tab (click a link that opens a new tab)
        System.out.println("Opening a new tab...");
        driver.findElement(By.id("opentab")).click();
        
        // Introduce a delay for visibility
        Thread.sleep(2000); // 2 seconds delay
/*
        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
*/
        // Create a new tab using newWindow
        System.out.println("Creating a new tab using switchTo().newWindow(WindowType.TAB)...");
        driver.switchTo().newWindow(WindowType.TAB);
        
        // Perform actions in the new tab (navigate to a new URL)
        System.out.println("Performing actions in the new tab...");
        driver.get("https://www.qaclickacademy.com/");
        
        Set<String> handles = driver.getWindowHandles();
        handles.iterator();
     //   System.out.println(handles);
        
        // Introduce a delay to see the result in the new tab
        Thread.sleep(3000); // 3 seconds delay
        
        // Switch back to the original tab (using the original window handle)
        System.out.println("Switching back to the original tab...");
        driver.switchTo().window(originalWindow);
        
        // Perform some action in the original tab (optional)
        System.out.println("Performing actions in the original tab...");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        // Introduce a delay before quitting
        Thread.sleep(2000); // 2 seconds delay

        // Close the driver
        System.out.println("Closing the driver...");
        driver.quit();
	}

}
