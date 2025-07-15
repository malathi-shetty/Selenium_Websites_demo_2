package autoHealing_Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoHealing_Test {
    private WebDriver driver;
    private final String URL = "https://www.lambdatest.com/selenium-playground/auto-healing";

    // Define arrays of locators and their names
    private final String[] locators_Username = {
            "username", 
            "lambdatest", 
            "//input[@id='username']", 
            "UserName", 
            "user"
    };

    private final String[] locators_Password = {
            "password", 
            "lambdatest", 
            "//input[@id='password']", 
            "Password", 
            "pass"
    };

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void autoHealingTest() {
        driver.get(URL);

        // Find and interact with elements using self-healing
        fillFieldWithSelfHealing(locators_Username, "QA_Automation");
        fillFieldWithSelfHealing(locators_Password, "password");

        // Simulate ID change by clicking the button
        WebElement changeIDButton = driver.findElement(By.xpath("//div[@class='flex items-center']//button[@type='submit']"));
        changeIDButton.click(); // This click changes the ID of username and password fields

        // Re-attempt locating elements using self-healing
        fillFieldWithSelfHealing(locators_Username, "QA_Automation");
        fillFieldWithSelfHealing(locators_Password, "password");
    }

    // Method to fill a field using self-healing
    private void fillFieldWithSelfHealing(String[] locators, String value) {
        WebElement element = findElementWithSelfHealing(locators);
        if (element != null) {
            element.sendKeys(value);
        } else {
            System.out.println("Element could not be found for input: " + value);
        }
    }

    // Self-healing method for locating web elements
    private WebElement findElementWithSelfHealing(String[] locators) {
        for (String locator : locators) {
            try {
                By by = getLocatorBy(locator);
                WebElement element = driver.findElement(by);
                System.out.println("Found element using: " + locator);
                return element; // Return as soon as the element is found
            } catch (Exception e) {
                System.out.println("Failed to find element using: " + locator);
            }
        }
        System.out.println("Element could not be found using any of the locators.");
        return null;
    }

    // Helper method to return the correct By locator based on input
    private By getLocatorBy(String locator) {
        if (locator.startsWith("//")) {
            return By.xpath(locator); // XPath locator
        } else if (locator.startsWith(".")) {
            return By.cssSelector(locator); // CSS Selector
        } else if (locator.matches("^[a-zA-Z0-9_-]+$")) {
            return By.id(locator); // ID
        } else {
            return By.name(locator); // Fallback to Name if not ID or XPath
        }
    }
}
