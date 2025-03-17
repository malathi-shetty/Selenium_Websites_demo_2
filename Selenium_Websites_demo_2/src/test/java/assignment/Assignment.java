package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://rahulshettyacademy.com/angularpractice/");
	        
	        driver.findElement(By.name("name")).sendKeys("abc");
	        driver.findElement(By.name("email")).sendKeys("hello@practice.com");
	        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
	        
	     // Extract and print values entered in the input fields
	        String nameValue = driver.findElement(By.name("name")).getAttribute("value");
	        String emailValue = driver.findElement(By.name("email")).getAttribute("value");
	        String passwordValue = driver.findElement(By.id("exampleInputPassword1")).getAttribute("value");

	        System.out.println("Entered name: " + nameValue);
	        System.out.println("Entered email: " + emailValue);
	        System.out.println("Entered password: " + passwordValue);

	        Assert.assertFalse(driver.findElement(By.id("exampleCheck1")).isSelected());
	        driver.findElement(By.id("exampleCheck1")).click();
	        System.out.println(driver.findElement(By.id("exampleCheck1")).isSelected());

	        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
	        Select xyz = new Select(dropdown);
	        xyz.selectByVisibleText("Female");
	        System.out.println("Selected Dropdown Text: " + xyz.getFirstSelectedOption().getText());

	        Thread.sleep(2000);

	        WebElement employedRadioButton = driver.findElement(By.id("inlineRadio2"));
	        employedRadioButton.click();
	        WebElement label = driver.findElement(By.xpath("//label[@for='inlineRadio2']"));
	        String radioButtonText = label.getText();
	        System.out.println("Selected Radio Button Text: " + radioButtonText);

	        driver.findElement(By.name("bday")).sendKeys("02/02/1992");
	        String dateValue  = driver.findElement(By.name("bday")).getAttribute("value");
	        System.out.println("Entered date is: " + dateValue);

	        // Wait for the submit button to be clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement submitButton = driver.findElement(By.cssSelector(".btn-success"));
	        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

	        // Scroll the submit button into view
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
	        
	        // Click the submit button
	        submitButton.click();
	        System.out.println("Submit button is clicked");

	        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

	        // Close the driver after a delay if you want to see the result
	        Thread.sleep(2000);
	        driver.quit();


	}

}
