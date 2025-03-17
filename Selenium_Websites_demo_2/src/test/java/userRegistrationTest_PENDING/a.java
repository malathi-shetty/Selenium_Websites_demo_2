package userRegistrationTest_PENDING;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class a {

	public static void main(String[] args) {
		  // Initialize WebDriver and navigate to Mailsac
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://mailsac.com/");
driver.get("https://mailsac.com/register");
        // Step 1: Simulate user entering an email address on Mailsac
      //  String testEmail = "testuser123"; // Use a valid test email for Mailsac
     //   driver.findElement(By.id("field_a1xtj")).sendKeys("testEmail");
     //   driver.findElement(By.xpath("//button[text()='Check the mail!']")).click();
//driver.findElement(By.linkText("Create account")).click();
WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15)); //Explicit Wait	
w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='_id']"))).sendKeys("testEmail");
w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys("automationtestingpractice8443@gmail.com");
driver.findElement(By.xpath("//button[text()='Agree and create my account']")).click();
System.out.println("Account Created Successfully");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.linkText("Sign in")).click();
/*
driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testEmail");
driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("SecurePassword123");
driver.findElement(By.xpath("//button[text()='Sign in']")).click();
*/
String pageTitle = driver.getTitle();
System.out.println("Page Title: " + pageTitle);

driver.get("https://mailsac.com/login");

driver.findElement(By.xpath("//a[@name='Forgot Password']")).sendKeys("testEmail");
driver.findElement(By.xpath("//button[text()='Send Confirmation Code']")).click();

/*
driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testEmail");
driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("SecurePassword123");
driver.findElement(By.xpath("//button[text()='Sign In']")).click();
*/
	}

}
