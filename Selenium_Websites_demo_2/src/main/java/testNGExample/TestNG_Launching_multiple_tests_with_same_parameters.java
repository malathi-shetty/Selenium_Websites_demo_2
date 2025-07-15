package testNGExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Launching_multiple_tests_with_same_parameters {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		// Setup WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Parameters({ "firstSampleParameter" })
	@Test(enabled = true)
	public void firstTestForOneParameter(String firstSampleParameter) {
		driver.get(firstSampleParameter);
		WebElement searchBar = driver.findElement(By.linkText("Mobile Device & Browser Lab"));
		searchBar.click();
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Mobile Device & Browser Lab");
	}

	@Parameters({ "firstSampleParameter" })
	@Test
	public void secondTestForOneParameter(String firstSampleParameter) {
		driver.get(firstSampleParameter);
		WebElement searchBar = driver.findElement(By.linkText("Live Cross Browser Testing"));
		searchBar.click();
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Cross Browser Testing");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the browser after all tests
		}
	}

}
