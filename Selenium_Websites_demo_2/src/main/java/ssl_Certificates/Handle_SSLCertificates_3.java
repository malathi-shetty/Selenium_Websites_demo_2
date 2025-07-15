package ssl_Certificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_SSLCertificates_3 {

	public static void main(String[] args) {
		// Set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        System.out.println("ChromeDriver set up successfully.");

        // Create ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // Accept insecure certificates
        WebDriver driver = new ChromeDriver(options);

        System.out.println("ChromeDriver instance created.");

        // Test different SSL certificate scenarios
        String[] urls = {
            "https://expired.badssl.com/",    // Expired Certificate
            "https://self-signed.badssl.com/", // Self-Signed Certificate
            "https://revoked.badssl.com/",      // Revoked Certificate
            "https://wrong.host.badssl.com/",   // Invalid Hostname
            "https://insecure.badssl.com/",     // Insecure Content
            "https://www.example.com"            // Valid Certificate
        };

        for (String url : urls) {
            try {
                // Launch the URL
                driver.get(url);
                Thread.sleep(3000); // Wait for the page to load
                System.out.println("The page title for " + url + " is: " + driver.getTitle());
            } catch (Exception e) {
                System.out.println("An error occurred for " + url + ": " + e.getMessage());
            }
        }

        driver.quit(); // Close the browser

	}

}
