package webTableHandler;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_testautomationpractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement table = driver.findElement(By.xpath("//table[@name='BookTable']"));

		// Scroll to the table element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table);

		// Optional: Pause for a moment to ensure the scroll action has completed
		try {
			Thread.sleep(2000); // 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int rows = table.findElements(By.tagName("tr")).size();
		System.out.println("Number of rows: " + rows);
		int cols = table.findElements(By.tagName("th")).size();
		System.out.println("Number of columns: " + cols);
		System.out.println("");

		String Header = driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th[1]")).getText();
		System.out.println("Row-1 Col-1: " + Header);
		System.out.println();
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[1]")).getText();
		System.out.println("Row-2 Col-1: " + data);
		System.out.println();
		String data1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[2]")).getText();
		System.out.println("Row-5 Col-2: " + data1);
		System.out.println();
		System.out.println("BookName" + " | " + "Author" + " | " + "Subject" + " | " + "Price");

		/*
		 * // Header: instructor course price
		 * 
		 * for (int i = 1; i <= 1; i++) // rows { for (int j = 1; j <= cols; j++) //
		 * cols {
		 * 
		 * System.out.print(
		 * driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//th["
		 * + j + "]")).getText() + " | ");
		 * 
		 * } }
		 */

		// Get all Rows & Columns Data
		for (int i = 2; i <= rows; i++) // rows
		{
			for (int j = 1; j <= cols; j++) // cols
			{

				System.out
						.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]"))
								.getText() + " | ");

			}
			System.out.println();
		}

		driver.quit();

	}

}
