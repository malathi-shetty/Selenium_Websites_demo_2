package userRegistrationTest_PENDING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailConfirmationTest {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();

	        // Assume the extracted confirmation link
	        String confirmationLink = "https://example.com/confirm?token=abc123";
	        driver.get(confirmationLink);

	        // Verify account activation
	        System.out.println("Account activation page title: " + driver.getTitle());

	        driver.quit();

	}

}
