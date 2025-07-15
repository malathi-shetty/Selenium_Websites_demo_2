package testNGExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Passing_Simple_Values_to_a_Test {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		// Setup WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@DataProvider()
	public Object[][] listOfLinks() {
	return new Object[][] {
	{"Mobile Device & Browser Lab", "Mobile Device & Browser Lab"},
	{"Live Cross Browser Testing", "Cross Browser Testing"},
	{"Automated Mobile Testing", "Mobile Test Automation!"},
	};
	}
	
	@Test(dataProvider = "listOfLinks")
	public void firstTestWithSimpleData(String linkname, String header) {
	driver.get("https://experitest.com/");
	WebElement searchBar = driver.findElement(By.linkText(linkname));
	searchBar.click();
	Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), header);
	}
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the browser after all tests
		}
	}

}
