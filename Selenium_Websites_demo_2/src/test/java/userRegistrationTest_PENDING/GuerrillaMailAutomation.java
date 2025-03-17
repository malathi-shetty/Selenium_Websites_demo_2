package userRegistrationTest_PENDING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GuerrillaMailAutomation {

	public static void main(String[] args) {
	

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode (optional)

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Guerrilla Mail's inbox
            driver.get("https://www.guerrillamail.com/inbox");

            // Wait for the page to load and retrieve the Guerrilla Mail email address
            Thread.sleep(2000); // Adjust the sleep time as needed
            WebElement emailAddressElement = driver.findElement(By.id("email_address_id")); // Replace with the actual ID
            String guerrillaEmailAddress = emailAddressElement.getText();
            System.out.println("Guerrilla Mail Address: " + guerrillaEmailAddress);

                    

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

}
}