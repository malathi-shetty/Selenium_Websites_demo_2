package switchTab_SwitchWindowExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindowExample {

	public static void main(String[] args) throws InterruptedException {
		// Set up the WebDriver (assuming ChromeDriver is used)
        WebDriver driver;

        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the URL
        System.out.println("Navigating to the URL...");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        // Store the window handle of the current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main window handle: " + mainWindowHandle);

        // Open a new window by clicking a link (this can vary)
        System.out.println("Clicking the link to open a new window...");
        driver.findElement(By.id("openwindow")).click();
        
        // Introduce a delay to see the result
        Thread.sleep(2000); // 2 seconds delay

      /*  // Switch to the new window
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
*/
        //or
        // Switch to the new window
        System.out.println("Switching to a new window...");
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Perform actions on the new window
        System.out.println("Performing actions in the new window...");
        driver.get("https://www.qaclickacademy.com/");
        
        // Introduce a delay to see the result in the new window
        Thread.sleep(3000); // 3 seconds delay

        // Switch back to the main window
        System.out.println("Switching back to the main window...");
        driver.switchTo().window(mainWindowHandle);

        // Introduce a delay before closing
        Thread.sleep(2000); // 2 seconds delay

        // Close the driver
        System.out.println("Closing the driver...");
        driver.quit();

	}

}
