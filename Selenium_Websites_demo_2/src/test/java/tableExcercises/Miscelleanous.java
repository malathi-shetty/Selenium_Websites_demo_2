package tableExcercises;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Miscelleanous {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize window and open the URL
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Delete specific cookie (if exists)
        driver.manage().deleteCookieNamed("sessionKey");

        // Navigate to URL
        driver.get("http://google.com");

        // Ensure the screenshot directory exists
        File screenshotDir = new File(".//Screenshot");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        // Take a screenshot and save it
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(".//Screenshot/1.png"));
            System.out.println("Screenshot taken and saved as 1.png");
        } catch (Exception e) {
            System.out.println("Error while taking the screenshot: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }

	}

//driver.manage().deleteAllCookies(): Clears all cookies stored in the browser. This might be useful when you want a fresh session without any cookies influencing the tests.

// deleteCookieNamed("sessionKey") deletes a cookie named sessionKey from the browser. This can be useful if you want to log out or clear session-related cookies.
