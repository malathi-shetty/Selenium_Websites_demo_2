package webTableHandler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Table_Handler_generic_Code_2 {

	

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

            // Create an instance of the current class
            Web_Table_Handler_generic_Code_2 handler = new Web_Table_Handler_generic_Code_2(driver);

            // Print entire table data
            handler.printTableData(tableLocator);
        } finally {
            // Clean up
            driver.quit();
        }
    }

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public Web_Table_Handler_generic_Code_2(WebDriver driver) {
        this.driver = driver;
    }

    // Get all rows in the table
    public List<WebElement> getRows(By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        return table.findElements(By.tagName("tr"));
    }

    // Get all cells in a row
    public List<WebElement> getCellsInRow(WebElement row) {
        return row.findElements(By.tagName("td"));
    }

    // Get cell data based on row index and column index
    public String getCellData(By tableLocator, int rowIndex, int colIndex) {
        List<WebElement> rows = getRows(tableLocator);
        if (rowIndex < rows.size()) {
            WebElement row = rows.get(rowIndex);
            List<WebElement> cells = getCellsInRow(row);
            if (colIndex < cells.size()) {
                return cells.get(colIndex).getText();
            }
        }
        return null;
    }

    // Print entire table data
    public void printTableData(By tableLocator) {
        List<WebElement> rows = getRows(tableLocator);
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = getCellsInRow(rows.get(i));
            for (WebElement cell : cells) {
            	
                System.out.print(cell.getText() + " | ");
               
            }
            System.out.println(" ");
            System.out.println();
        }
    }

}


/*
Table Handling Methods:

getRows(By locator): Finds and returns all rows in the table.

getCellsInRow(WebElement row): Finds and returns all cells in a given row.

getCellData(By tableLocator, int rowIndex, int colIndex): Retrieves cell data for a specific row and column index.

printTableData(By tableLocator): Prints the entire table data to the console.

Execution: The printTableData method is called to demonstrate how to use the table handling methods.

WebDriver and Locator: Adjust the tableLocator to match the specific table on your target web page.

Class-Level Methods: The methods getRows, getCellsInRow, getCellData, and printTableData are moved outside of the main method and defined at the class level.

Instance Variable: Added an instance variable driver to hold the WebDriver instance, which is initialized via the constructor.

Constructor: A constructor is provided to initialize the WebDriver instance.

Calling Methods: Created an instance of WebTableHandlerGenericCode in the main method to call the table handling methods.

*/