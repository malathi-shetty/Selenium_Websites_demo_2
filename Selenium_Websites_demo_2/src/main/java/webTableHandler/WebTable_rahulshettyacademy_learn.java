package webTableHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_rahulshettyacademy_learn {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));

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
		System.out.println("rows: " + rows);
		int cols = table.findElements(By.tagName("th")).size();
		System.out.println("cols: " + cols);

		// Header: instructor course price

		for (int i = 1; i <= 1; i++) // rows
		{
			for (int j = 1; j <= cols; j++) // cols
			{

				System.out.print(
						driver.findElement(By.xpath("//table[@name='courses']//tr[" + i + "]//th[" + j + "]")).getText()
								+ " | ");

			}
		}

		System.out.println();
		// Get all Rows & Columns Data
		for (int i = 2; i <= rows; i++) // rows
		{
			for (int j = 1; j <= cols; j++) // cols
			{

				System.out.print(
						driver.findElement(By.xpath("//table[@name='courses']//tr[" + i + "]//td[" + j + "]")).getText()
								+ " | ");

			}
			System.out.println();
		}

		driver.quit();

	}

}
