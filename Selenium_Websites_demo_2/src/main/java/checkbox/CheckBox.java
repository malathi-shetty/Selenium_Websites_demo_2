package checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		// WebElement data = (WebElement)js.executeScript("document.getElementById('checkBoxOption1');");

		// data.click();
	//	js.executeScript("arguments[0].click()", driver.findElement(By.id("checkBoxOption1")));
		
		clickUsingJs(driver,driver.findElement(By.id("checkBoxOption1")));
		
		driver.quit();

	}

	public static void clickUsingJs(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", element);

	}
	
/*	public static WebElement findtheWebElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		return (WebElement) js.executeScript("document.getElementByid(''));", element);
		 

	}
*/
}
