package seleniumExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ColorVerification {

	public static void verifyButtonColor(WebDriver driver, String buttonId, String expectedColor) {
		// Locate the button element
		WebElement button = driver.findElement(By.xpath("(//button[@class='button success'])[1]"));

		// Get the background color CSS property value
		String actualColor = button.getCssValue("background-color");

		// Compare the expected and actual color values
		if (actualColor.equals(expectedColor)) {
			System.out.println("Color verification passed. The button color is: " + actualColor);
		} else {
			System.out.println("Color verification failed. Expected: " + expectedColor + ", but found: " + actualColor);
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://turretcss.com/element/button-colors/");
		verifyButtonColor(driver, "button", "rgb(0, 179, 0)"); // Replace with actual expected color in RGB format
	}

}
