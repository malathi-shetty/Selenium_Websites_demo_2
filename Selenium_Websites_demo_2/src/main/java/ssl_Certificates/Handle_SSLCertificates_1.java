package ssl_Certificates;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_SSLCertificates_1 {

	public static void main(String[] args) {
		// Set up the ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		System.out.println("ChromeDriver set up successfully.");

		// Create ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);

		System.out.println("ChromeDriver instance created.");

		driver.get("https://www.lambdatest.com/selenium-playground/table-data-download-demo");
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // Maximize the window

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']")));

		WebElement table = driver.findElement(By.xpath("//table[@id='example']"));
		int rows = table.findElements(By.tagName("tr")).size();
		int cols = table.findElements(By.xpath("//table[@id='example']//tr[1]/td")).size(); // Get the column count from
																							// the first row

		// Loop through each row and column to print table data
		for (int i = 1; i <= rows; i++) {
			// Check if the row contains any actual data
			if (table.findElements(By.xpath("//table[@id='example']//tr[" + i + "]/td")).size() > 0) { // comment this
																										// line & check
																										// difference -
																										// 1
				for (int j = 1; j <= cols; j++) {
					try {
						System.out.print(
								driver.findElement(By.xpath("//table[@id='example']//tr[" + i + "]/td[" + j + "]"))
										.getText() + " ");
					} catch (org.openqa.selenium.NoSuchElementException e) {
						System.out.print("N/A "); // Handle missing cells
					}
				}
				System.out.println(); // Print new line after each row
			}
		} // comment this line & check difference - 1
		driver.quit(); // Close the browser

	}
}

//By setting setAcceptInsecureCerts(true), you're instructing Selenium to bypass these warnings and proceed with the connection to the website, even if the certificate is deemed insecure.