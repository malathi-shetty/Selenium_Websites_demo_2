package automate_Browser_navigations_and_window_properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_Browser_navigations_and_window_properties {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://rahulshettyacademy.com");	
	
		Thread.sleep(3000);
		driver.navigate().back();
		System.out.println("Title: " + driver.getTitle());
		System.out.println("Current Url: " + driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("Title: " + driver.getTitle());
		System.out.println("Current Url: " + driver.getCurrentUrl());
		
//driver.quit();
	}

}
