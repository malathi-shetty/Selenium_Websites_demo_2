package end_to_end_UI;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End_to_end_UI {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");

		System.out.println("Title of the Page: " + driver.getTitle());

		// Select Source station (DEL)
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();

		Thread.sleep(3000);

		// Select Destination station (Mumbai)
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath(
				"//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(text(), 'Mumbai (BOM)')]"))
				.click();

		Thread.sleep(5000);

		// Fetch and print the selected source and destination station names

		String sourceStation = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"))
				.getDomAttribute("value");
		String destinationStation = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"))
				.getDomAttribute("value");

		System.out.println("Selected Source Station: " + sourceStation);
		System.out.println("Selected Destination Station: " + destinationStation);

//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		System.out
				.println("Check Opacity for one way: " + driver.findElement(By.id("Div1")).getDomAttribute(("style")));
		if (driver.findElement(By.id("Div1")).getDomAttribute(("style")).contains("0.5")) // check with 0.5
		{
			System.out.println("Date is Disabled for Return as One Way Route is Selected");
			Assert.assertTrue(true); // .contains("0.5")
		} else {
			Assert.assertTrue(false);
		}
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

		// Find the element using the dynamic XPath
		// WebElement departdate =
		// driver.findElement(By.id("ctl00_mainContent_view_date1"));

		// Click on the element (or any other action you'd like to perform)
		// departdate.click();
		// driver.findElement(By.name("ctl00$mainContent$view_date1")).sendKeys("09/02/2025");
		String dateValue = driver.findElement(By.name("ctl00$mainContent$view_date1")).getAttribute("value");
		System.out.println("Entered date is: " + dateValue);

		Assert.assertFalse(
				driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

		System.out.println("Is Check box Selected for friendsandfamily Initially?: " + driver
				.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected()); // false
		driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).click(); // selects
																											// checkbox
		System.out.println("Check box Selected for friendsandfamily: " + driver
				.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected()); // true

		// Assert.assertTrue(true);
		Assert.assertTrue(
				driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

		Thread.sleep(3000);

		driver.findElement(By.id("divpaxinfo")).click();

		System.out.println("Default Text in Box: " + driver.findElement(By.id("divpaxinfo")).getText());
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 1; i < 3; i++) {
			WebElement Add = driver.findElement(By.id("hrefIncAdt")); // 4 times click
			wait1.until(ExpectedConditions.elementToBeClickable(Add)).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		System.out.println("Adult Selected: " + driver.findElement(By.id("divpaxinfo")).getText());

		// Wait for the submit button to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement submitButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights"));
		// driver.findElement(By.cssSelector("input[@value='Search']"));
		// driver.findElement(By.xpath("//input[@value='Search']"));
		// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights"));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		// Close Browser
		// driver.quit();

	}

}
