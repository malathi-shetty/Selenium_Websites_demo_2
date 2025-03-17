package userRegistrationTest_PENDING;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailVerification_mailsac {

	public static void main(String[] args) {
		  // Initialize WebDriver and navigate to Mailsac
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://mailsac.com/");
driver.get("https://playground.mailslurp.com/");
        // Step 1: Simulate user entering an email address on Mailsac
      //  String testEmail = "testuser123"; // Use a valid test email for Mailsac
     //   driver.findElement(By.id("field_a1xtj")).sendKeys("testEmail");
     //   driver.findElement(By.xpath("//button[text()='Check the mail!']")).click();
driver.findElement(By.linkText("Create account")).click();
WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15)); //Explicit Wait	
w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys("automationtestingpractice8443@gmail.com");
w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("SecurePassword123");
driver.findElement(By.xpath("//button[text()='Create Account']")).click();
System.out.println("Account Created Successfully");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.linkText("Sign in")).click();

driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testEmail");
driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("SecurePassword123");
driver.findElement(By.xpath("//button[text()='Sign in']")).click();

String pageTitle = driver.getTitle();
System.out.println("Page Title: " + pageTitle);


        // Step 2: Wait for the page to load and for the email to be visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 3: Get the page title and print it (just to verify the page has loaded correctly)
        

        // Step 4: Locate and print the email confirmation message
        WebElement emailSubject = driver.findElement(By.xpath("//h2"));
        System.out.println("Email Inbox Confirmation: " + emailSubject.getText());

        // Step 5: Check if the email subject contains "Welcome" (or another confirmation keyword)
        if (emailSubject.getText().contains("Welcome")) {
            // Step 6: Click on the email to open it
            driver.findElement(By.xpath("//span[contains(text(),'Welcome')]")).click();

            // Step 7: Wait for the email content to load
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Step 8: Extract the email content
            WebElement emailContent = driver.findElement(By.xpath("//div[@class='message-content']"));
            String content = emailContent.getText();
            System.out.println("Email Content: " + content);

            // Step 9: Extract the confirmation link from the email content
            String confirmationLink = extractConfirmationLink(content);
            System.out.println("Confirmation Link: " + confirmationLink);
        } else {
            System.out.println("No confirmation email found.");
        }

        // Step 10: Close the browser after test completion
        driver.quit();
    }

    // Function to extract the confirmation link from the email content
    private static String extractConfirmationLink(String emailContent) {
        String keyword = "http";
        int startIndex = emailContent.indexOf(keyword);
        if (startIndex != -1) {
            int endIndex = emailContent.indexOf(" ", startIndex);
            return (endIndex == -1) ? emailContent.substring(startIndex) : emailContent.substring(startIndex, endIndex);
        }
        return "No link found";
    }

	}
