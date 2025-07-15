package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators_3 {
	
	//siblings - child - parent - xpath traverse
	//header/div/button[1]/following-sibling::button[1]
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		System.out.println( driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		
		System.out.println( driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
