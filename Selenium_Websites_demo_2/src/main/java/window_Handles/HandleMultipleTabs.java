package window_Handles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class HandleMultipleTabs {

//	public static void main(String[] args) throws InterruptedException {

	@Test
	 @Description("This is a description of the test.") 
	 @Step("Step one description")
	public void testMethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		try {
			// Open the initial page
			driver.get("https://www.google.co.in/");

			// Perform actions on the first tab
			System.out.println("Title of the first tab: " + driver.getTitle());
			Thread.sleep(5000);
			// Open a new tab using JavaScript
			((JavascriptExecutor) driver).executeScript("window.open('https://www.restapitutorial.com', '_blank');");

			// Get window handles
			List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

			// Switch to the new tab (second tab)
			driver.switchTo().window(windowHandles.get(1));
			System.out.println("Title of the second tab: " + driver.getTitle());
			Thread.sleep(5000);
			// Perform actions on the second tab
			WebElement someElement = driver.findElement(By.id("R-topics"));
			someElement.click();

			// Switch back to the original tab (first tab)
			driver.switchTo().window(windowHandles.get(0));
			System.out.println("Title of the first tab after switching back: " + driver.getTitle());
			Thread.sleep(5000);
			// Close the current tab (second tab) and switch back to the first tab
			driver.switchTo().window(windowHandles.get(1)).close();
			Thread.sleep(5000);
			driver.switchTo().window(windowHandles.get(0));
			System.out.println("Title of the remaining tab: " + driver.getTitle());

		} finally {
			// Close all tabs and quit the browser
			driver.quit();
		}

	}

}
