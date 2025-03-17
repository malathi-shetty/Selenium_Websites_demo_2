package checkbox_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Assignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected()); // false
	
		driver.findElement(By.id("checkBoxOption1")).click(); // selects checkbox
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected()); // true
    	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).click(); // selects checkbox
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		
		
		// count the number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


	}

}
