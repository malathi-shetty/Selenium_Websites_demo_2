package capture_the_dimensions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capture_Dimensions {

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
    
        // Introduce a delay to see the result
        Thread.sleep(2000); // 2 seconds delay

        // Capture the dimensions of the new window (second window)
        Dimension secondWindowSize = driver.manage().window().getSize();
        int WindowWidth = secondWindowSize.getWidth();
        int WindowHeight = secondWindowSize.getHeight();
        System.out.println("Window dimensions - Width: " + WindowWidth + ", Height: " + WindowHeight);

     // Close the driver
        System.out.println("Closing the driver...");
        driver.quit();

	}

}
