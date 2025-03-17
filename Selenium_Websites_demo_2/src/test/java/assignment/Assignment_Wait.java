package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_Wait {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	        
	        driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
	        driver.findElement(By.id("password")).sendKeys("learning");
	        

	        WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
	        Select xyz = new Select(dropdown);
	        xyz.selectByVisibleText("Consultant");
	        
	        driver.findElement(By.id("terms")).click();
	        
	        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit Wait	
	        
	        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='customradio']//span[text()=' User']/following-sibling::span[@class='checkmark']"))).click();
	    	    
	        driver.findElement(By.cssSelector("div.modal-content")).getText();
	        
	        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']"))).click();
	        
	        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.signInBtn"))).click();
	        
	        driver.quit();
	}

}

