package webTableHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Web_Table_Handler_generic_Code_learn {

	public static void main(String[] args) {
		// public static void printTableData(WebDriver driver, By locator) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		// driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.get("https://cosmocode.io/automation-practice-webtable/");

		driver.manage().window().maximize();

		// Define the locator for the table & Find the table element
		// WebElement table = driver.findElement(By.id("product")); //for
		// rahulshettyacademy

		WebElement table = driver.findElement(By.id("content")); // for cosmocode

		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Iterate over each row
		for (WebElement row : rows) {

			// Find all columns in the row
			List<WebElement> cols = row.findElements(By.tagName("td"));

			// Print column data
			for (WebElement col : cols) {
				System.out.print(col.getText() + "  \t");
			}
			System.out.println();
		}
		driver.quit();
	}

}
