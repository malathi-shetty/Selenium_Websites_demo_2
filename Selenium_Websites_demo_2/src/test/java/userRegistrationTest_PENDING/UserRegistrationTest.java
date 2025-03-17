package userRegistrationTest_PENDING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistrationTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mailsac.com/");
		
		
	/*	// Step 2: Fill in the registration form
        String tempEmail = "uog604+7s0vtll1kdkxw@guerrillamail.info"; // Replace with your Guerrilla Mail address
        
        driver.findElement(By.id("username")).sendKeys("testuser123");
        driver.findElement(By.id("email")).sendKeys("testemail@example.com");
        driver.findElement(By.id("password")).sendKeys("SecurePassword123");
        driver.findElement(By.id("confirmPassword")).sendKeys("SecurePassword123");
        driver.findElement(By.id("registerButton")).click();
*/
		 driver.findElement(By.id("field_a1xtj")).sendKeys("testuser123");
	        driver.findElement(By.xpath("//button[text()='Check the mail!']")).click();
		
        // Capture and print confirmation message
     //   WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
      //  System.out.println("Registration Confirmation: " + confirmationMessage.getText());
	        
	        String pageTitle = driver.getTitle();

	        // Print the page title
	        System.out.println("Page Title: " + pageTitle);

	       
	        System.out.println("Email Inbox Confirmation: " + driver.findElement(By.xpath("//h2")).getText());

        driver.quit();

	}

}
