package elements_disabled_enabled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements_disabled_enabled {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		// Assert.assertTrue - (In Assert.assertTrue condition - true condition is
		// expected) i am giving false condition so it will not execute further
		// or
		// Assert.assertFalse(false);
		// or
		// Assert.assertFalse(true);//if true is written code will stop executing
		// further
		// or
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // false
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); // selects checkbox
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // true

		// Assert.assertTrue(true);
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

	

		//	System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute(("style")));
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			System.out.println(driver.findElement(By.id("Div1")).getDomAttribute(("style")));
			if( driver.findElement(By.id("Div1")).getDomAttribute(("style")).contains("1")) // check with 0.5
			{
				System.out.println("Enabled");
				Assert.assertTrue(true); //.contains("1")
			}
			else {
				Assert.assertTrue(false); //.contains("0.5")
			}
		//	System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

			
	}

}
