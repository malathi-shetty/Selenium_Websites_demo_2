package userRegistrationTest_PENDING;


import java.io.IOException;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoaktAutomation {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
     // Generate a random name using UUID
        String randomName = UUID.randomUUID().toString(); // This generates a unique random name


    //    try {
            // Navigate to Moakt's homepage
            driver.get("https://www.moakt.com/en");

            // Wait for the page to load and locate the "Get a Random Address" button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
            WebElement randomAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("mail_in"))); // Replace with the actual class or ID
            randomAddressButton.sendKeys(randomName);  // Enter a test email
            Thread.sleep(2000); // Adjust the sleep time as needed
            driver.findElement(By.xpath("//input[@class='mail_butt']")).click(); // Click the button to generate the random email address
            Thread.sleep(2000);
            
            // Wait for the email address to be generated and locate it
            WebElement emailAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-address"))); // Replace with actual ID
            String emailAddress = emailAddressElement.getText();
            System.out.println("Generated Email Address: " + emailAddress);

            // Perform additional actions as needed
  /*      } finally {
            // Close the browser
            driver.quit();
        }
*/
            Thread.sleep(5000);
         // Click on the "Compose" button to open the compose email window
            WebElement composeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Compose']"))); // Replace with the actual ID
            composeButton.click();

            // Wait for the compose window to appear
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Enter the Moakt-generated email address in the "To" field
            WebElement toField = driver.findElement(By.xpath("//input[@name='mail_to']")); // Replace with the actual ID
            toField.sendKeys("automationtestingpractice8443@gmail.com"); // Replace with the actual Moakt email address

            // Enter the subject in the "Subject" field
            WebElement subjectField = driver.findElement(By.xpath("//input[@name='mail_subject']")); // Replace with the actual ID
            subjectField.sendKeys("Test Subject");

            // Enter the body of the email in the "Body" field
            WebElement bodyField = driver.findElement(By.xpath("//textarea[@name='mail_text']")); // Replace with the actual ID
            bodyField.sendKeys("This is a test email sent using Selenium WebDriver.");

         /*
            
         // Wait for the CAPTCHA to appear (you may need to adjust the selector based on the page)
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); 
            WebElement captchaElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("recaptcha-anchor"))); // Replace with the actual ID

        //    captchaElement.isSelected();
         // Instructions to the user
            System.out.println("Please solve the CAPTCHA manually.");
             wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); 
            // Wait for user to solve CAPTCHA manually
            System.in.read();  // Wait for the user to press Enter after solving the CAPTCHA
            
            */
            
            // Wait for the iframe to be available and switch to it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebDriver captchaFrame = wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
           
            // Wait for the checkbox to be clickable and click it
            WebElement checkboxBorder = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border")));
            checkboxBorder.click();
            String captchaValue = checkboxBorder.getText();
            System.out.println("CAPTCHA Response: " + captchaValue);
            // Switch back to the main content
            driver.switchTo().defaultContent();
            // Instructions to the user
        //    System.out.println("Please solve the CAPTCHA manually.");
          
            // Wait for the user to solve the CAPTCHA manually
            try {
            	System.out.println("Waiting for user input...");
            	System.in.read();  // Wait for input
            	System.out.println("User input received!");

             //   System.in.read(); // Wait for the user to press Enter after solving the CAPTCHA
            } catch (IOException e) {
                e.printStackTrace();
            }
/*
            // Wait for the CAPTCHA input field to be populated (adjust the selector as needed)
            WebElement captchaInput = driver.findElement(By.id("captcha_input_field_id"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

            // Wait until the CAPTCHA input field is not empty
            while (captchaInput.getDomAttribute("value").isEmpty()) {
                try {
                    TimeUnit.SECONDS.sleep(1); // Check every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Waiting for the page to process the CAPTCHA...");
   
           Thread.sleep(5000); // Allow extra time for CAPTCHA processing, adjust as needed
          */   System.out.println("CAPTCHA solved successfully.");
            // Ensure that the "Send" button is clickable before proceeding
             wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sendButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Send']")));
            sendButton.click();

           
            
            // Click the "Send" button to send the email
        //    WebElement sendButton = driver.findElement(By.xpath("//input[@value='Send']")); // Replace with the actual ID
         //   sendButton.click();

            // Wait for the email to be sent
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Verify that the email appears in the sent items or inbox
            // Implement verification steps as needed
       
            WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessageElement = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("msg_success")));

         // Locate the div element with class 'msg_success'
        //    WebElement successMessageElement = driver.findElement(By.className("msg_success"));

            // Extract the text content
            String successMessage = successMessageElement.getText();

            // Print the success message
            System.out.println("Success Message: " + successMessage);

            
            
            //
            driver.quit();
	}

}


/*

try {
System.out.println("Waiting for user input...");
System.in.read();  // Wait for input
System.out.println("User input received!");

Once you are done verifying captcha you can press enter in ***CONSOLE*** to continue the execution

*/