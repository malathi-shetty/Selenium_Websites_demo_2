package webTableHandler;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_cosmocode_io_1_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");

		// Locate the table and get rows
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		// Print the table header
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%-10s %-15s %-15s %-15s\n", "ID", "Name", "Country", "Email");
		System.out.println("--------------------------------------------------------------------------------");

		// Print each row in the table
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			if (columns.size() > 0) {
				System.out.printf("%-10s %-15s %-15s %-15s\n", columns.get(0).getText(), // ID
						columns.get(1).getText(), // Name
						columns.get(2).getText(), // Country
						columns.get(3).getText() // Email
				);
			}
		}

		System.out.println("--------------------------------------------------------------------------------");

		driver.quit();

	}

}

/*
 * Table Header: The header line is printed before looping through the rows to
 * create a visually organized table header. Formatting: System.out.printf is
 * used for formatted output. The %-10s syntax left-aligns strings within a
 * width of 10 characters. Adjust the widths (10, 15, etc.) as necessary to
 * match your table's column widths. Loop Through Rows and Columns: Inside the
 * loop, the script fetches all <td> elements of the current row and prints
 * their text in a formatted way. Footer Line: A footer line is printed after
 * all rows to close off the table visually. By using these formatting
 * techniques, your output will appear in a more organized and readable table
 * format. Adjust the column widths (%-10s, %-15s, etc.) based on the actual
 * content length to ensure the table's columns align correctly.
 */