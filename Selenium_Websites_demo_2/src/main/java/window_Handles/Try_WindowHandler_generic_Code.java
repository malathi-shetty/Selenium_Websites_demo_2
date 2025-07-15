package window_Handles;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Try_WindowHandler_generic_Code {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.google.co.in/");
		    String parentWindowHandle = driver.getWindowHandle();
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.open('https://rahulshettyacademy.com/seleniumPractise/#/', '_blank');");
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String handle : windowHandles) {
		      if (!handle.equals(parentWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		      }
		    }
		    System.out.println("Switched to child window with title: " + driver.getTitle());
		    System.out.println("Child window closed");
		    driver.close();
		    driver.switchTo().window(parentWindowHandle);
		    System.out.println("Switched back to parent window with title: " + driver.getTitle());
		    System.out.println("Parent window closed");
		    driver.quit();

	}

}
