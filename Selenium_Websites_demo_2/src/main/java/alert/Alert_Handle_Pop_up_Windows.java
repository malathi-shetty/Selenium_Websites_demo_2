package alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Handle_Pop_up_Windows {
	public static void main(String[] args) {
		
		WebDriver driver;

        // Setup WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Alerts.html");
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        // Wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to alert and retrieve the text
        Alert alert = driver.switchTo().alert();
        String textInAlert = alert.getText();
        System.out.println("The alert message is: " + textInAlert);

        alert.accept();

        // Brief wait before closing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Alert test is complete");

        driver.quit();
	}
}
