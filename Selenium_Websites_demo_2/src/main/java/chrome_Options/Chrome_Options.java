package chrome_Options;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome_Options {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
	}

	private WebDriver initializeDriver(ChromeOptions options) {
		driver = new ChromeDriver(options);
		return driver;
	}

	@Test
	public void testHeadlessMode() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		initializeDriver(options);

		try {
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			boolean isElementPresent = driver.findElements(By.id("checkBoxOption1")).size() > 0;
			System.out.println("*****in Headless Mode**** ---> Is CheckBox Option 1 present: " + isElementPresent);
			System.out.println();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testDisableExtension() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		initializeDriver(options);

		try {
			driver.get("https://rahulshettyacademy.com/");
			String pageTitle = driver.getTitle();
			System.out.println("***With Extensions Disabled*** ==> Title: " + pageTitle);
			System.out.println();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testDisableInfobars() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		initializeDriver(options);

		try {
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			boolean isAlertPresent = driver.findElements(By.id("alertbtn")).size() > 0;
			System.out.println("*** DisableInfobars *** ==> Is Alert Button present: " + isAlertPresent);
			System.out.println();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testStartMaximized() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		initializeDriver(options);

		try {
			driver.get("https://rahulshettyacademy.com/contact-us/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
			System.out.println("***StartMaximized*** ==> Header on Contact Page: " + header);
			System.out.println();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testUserAgent() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=CustomUserAgentString");
		initializeDriver(options);

		try {
			driver.get("https://magento.softwaretestingboard.com/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-footer")))
					.getText();
			System.out.println("***SetUserAgent*** ==> Content in User Agent Test: " + content);
			System.out.println();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testSetWindowSize() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1366,768");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		initializeDriver(options);

		try {
			driver.get("https://tutorialsninja.com/demo/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String footerText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("OpenCart")))
					.getText();
			System.out.println("*** SetWindowSize*** ==> Footer Text: " + footerText);
			System.out.println();
		} finally {
			driver.quit();
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

/*
 * 
 * chrome_Options.Chrome_Options.testStartMaximized ==> This test ensures that
 * the browser opens maximized.
 * 
 * chrome_Options.Chrome_Options.testHeadlessMode ==> This test runs the browser
 * in headless mode, meaning it won’t display any GUI.
 * 
 * chrome_Options.Chrome_Options.testSetWindowSize ==> This test sets a specific
 * window size for the browser.
 * 
 * chrome_Options.Chrome_Options.testUserAgent ==> This test changes the user
 * agent string of the browser.
 * 
 * chrome_Options.Chrome_Options.testDisableInfobars ==> This test disables
 * infobars in the browser window.
 * 
 * chrome_Options.Chrome_Options.testDisableExtension ==> This test disables any
 * extensions that might be running in the browser.
 */
