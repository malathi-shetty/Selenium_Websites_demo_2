package ssl_Certificates;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_SSLCertificates_2 {

	public static void main(String[] args) throws InterruptedException {

		// Set up the ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		System.out.println("ChromeDriver set up successfully.");

		// Create ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // Accept insecure certificates // make (false) to check other conditions
		WebDriver driver = new ChromeDriver(options);

		System.out.println("ChromeDriver instance created.");

		// Launching the URL
		driver.get("https://expired.badssl.com/");
		Thread.sleep(3000);

		System.out.println("The page title is : " + driver.getTitle());
		driver.quit();

	}

}
