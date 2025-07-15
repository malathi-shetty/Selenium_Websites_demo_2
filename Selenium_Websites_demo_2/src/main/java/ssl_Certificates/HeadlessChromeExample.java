package ssl_Certificates;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeExample {

	public static void main(String[] args) throws IOException {

		// Set up the ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		System.out.println("ChromeDriver set up successfully.");

		// Create ChromeOptions
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-infobars");
		options.addArguments("--remote-debugging-port=9222"); // Useful for debugging

		options.addArguments("--incognito");

		// Create a new instance of the Chrome driver with options
		WebDriver driver = new ChromeDriver(options);
		System.out.println("ChromeDriver instance created.");

		try {
			// Navigate to a website
			System.out.println("Navigating to: https://formy-project.herokuapp.com/form");
			driver.get("https://formy-project.herokuapp.com/form");

			// Print the title of the page
			// Wait for an element to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

			System.out.println("Page title is: " + driver.getTitle());
			System.out.println("Heading text: " + element.getText());

			TakesScreenshot ts = (TakesScreenshot) driver; // Typecasting TakeScreenshot interface with WebDriver
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(".//Screenshot//CaptureScreenShot_" + timeStamp() + ".png");
			FileUtils.copyFile(src, dest);

		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the driver
			driver.quit();
			System.out.println("ChromeDriver closed.");
		}

	}

	private static String timeStamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now).replace(" ", "_").replace("/", "_").replace(":", "_");
	}

}

/*
 * 
 * --headless: Runs Chrome in headless mode, meaning no UI will be displayed.
 * 
 * --no-sandbox: Bypasses the sandboxing security feature (useful in some CI/CD
 * environments).
 * 
 * --disable-dev-shm-usage: Prevents issues related to shared memory on some
 * systems (especially in Docker).
 * 
 * --window-size=1920,1080: Sets the initial window size, which can help with
 * responsive design testing.
 * 
 * --disable-gpu: Disables GPU hardware acceleration (often used in headless
 * mode).
 * 
 * --incognito: Launches Chrome in incognito mode.
 * 
 * 
 * Additional Options:
 * 
 * You can customize Chrome further with various arguments. For example:
 * 
 * --disable-gpu: Disables GPU hardware acceleration (often used in headless
 * mode).
 * 
 * --incognito: Launches Chrome in incognito mode.
 * 
 */
