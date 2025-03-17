package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	// TestNG is one of the testing framework
	// Assertion help us to validate if result watever selenium returns is expected
	// or not, if not it will fail

	public static void main(String[] args) throws InterruptedException {
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

		// count the number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());// top-left it will
																									// scan all elements
																									// so findelements
																									// i.e 6 checkbox

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for (int i = 1; i < 5; i++) // print here 4 in i<4 instead of i<5 u can see assertion error
		{
			driver.findElement(By.id("hrefIncAdt")).click(); // 4 times click

		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		// Assert.assertEquals(actual, expected); // comparison
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); // expected [5 Adult] but
																							// found [4 Adult]
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
