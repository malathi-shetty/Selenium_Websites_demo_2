package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators_practice {

	public static void main(String[] args) {
		// implicit wait is gobal timeout i.e it will wait until the seconds given to find an element
		// max timeout it will wait is 5 sec
		
		
		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver (ChromeDriver in this case)
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("student");
		// driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("password")).sendKeys("Password");
		driver.findElement(By.className("btn")).click();
		System.out.println(driver.findElement(By.className("div.show")).getText());

		driver.quit();

	}

}
