package webTableHandler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Table_Handler_generic_Code_3 {

	

	// Method to get all rows in a table
	public static List<WebElement> getRows(WebDriver driver, By tableLocator) {
		WebElement table = driver.findElement(tableLocator);
		return table.findElements(By.tagName("tr"));
	}

	// Method to get all cells in a row
	public static List<WebElement> getCellsInRow(WebElement row) {
		return row.findElements(By.tagName("td"));
	}

	// Method to get cell data based on row index and column index
	public static String getCellData(WebDriver driver, By tableLocator, int rowIndex, int colIndex) {
		List<WebElement> rows = getRows(driver, tableLocator);
		if (rowIndex < rows.size()) {
			WebElement row = rows.get(rowIndex);
			List<WebElement> cells = getCellsInRow(row);
			if (colIndex < cells.size()) {
				return cells.get(colIndex).getText();
			}
		}
		return null;
	}

	// Method to print entire table data
	public static void printTableData(WebDriver driver, By tableLocator) {
		List<WebElement> rows = getRows(driver, tableLocator);
		for (WebElement row : rows) {
			List<WebElement> cells = getCellsInRow(row);
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Open the URL
			driver.manage().window().maximize();
			driver.get("https://cosmocode.io/automation-practice-webtable/");

			// Define the locator for the table
			By tableLocator = By.id("content");

			// Print the table data
			printTableData(driver, tableLocator);

			// Example of getting cell data (row 1, column 2)
			String cellData = getCellData(driver, tableLocator, 1, 2);
			System.out.println("Cell Data (Row 1, Column 2): " + cellData);

		} finally {
			// Clean up
			driver.quit();
		}

	}

}
