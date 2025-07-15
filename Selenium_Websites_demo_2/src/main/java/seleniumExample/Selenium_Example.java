package seleniumExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Example {

	public static void main(String[] args) throws IOException, SQLException {
		
		 WebDriver driver;
		 // Set up WebDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        // Locate links by linkText() and partialLinkText()
        driver.findElement(By.linkText("Home")).click();
        driver.navigate().back(); // Go back to the previous page
        driver.findElement(By.partialLinkText("Pract")).click();

        // Selecting multiple items in a dropdown
        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByValue("option2"); // By Value
        select.selectByVisibleText("Option3"); // By Visible Text
        select.selectByIndex(1); // By Index

        // Submitting a form
        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("alertbtn")).click(); // Assuming there's an alert when clicking this button

        // Handling iframes
        driver.switchTo().frame("courses-iframe"); // Switch to iframe by ID
        // Perform operations inside the iframe here
        driver.switchTo().defaultContent(); // Switch back to the default content

        // Close and quit methods
        driver.close(); // Close the current window
        driver.quit(); // Close all windows

        // Exception Handling
        driver = new ChromeDriver(); // Reinitialize WebDriver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement saveButton = driver.findElement(By.id("name"));
        try {
            if (saveButton.isDisplayed()) {
                saveButton.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        // isEnabled()
        WebElement button = driver.findElement(By.id("alertbtn"));
        if (button.isEnabled()) {
            button.click();
        }

        // getText()
        WebElement textElement = driver.findElement(By.id("displayed-text"));
        String text = textElement.getText();
        System.out.println("Text: " + text);

        // findElements() and size()
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        boolean isPresent = !checkboxes.isEmpty();
        System.out.println("Checkboxes present: " + isPresent);

        // pageLoadTimeout and implicitlyWait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     // Create a WebDriverWait instance with Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayed-text")));

        // Handling alerts
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test Alert");
        alert.accept();

        // Handling multiple windows
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }

        // Database connection example (replace with actual details)
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");

        // Reading from Excel file (ensure the file path and extension are correct)
        FileInputStream file = new FileInputStream(new File("path/to/excel.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        // Read and process data from the sheet as needed

        // Screenshot
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/Screenshots/amazon.png");
		FileUtils.copyFile(source, dest);

        // Mouse hover and drag and drop
        Actions actions = new Actions(driver);
        WebElement hoverElement = driver.findElement(By.id("mousehover"));
        actions.moveToElement(hoverElement).perform();

        WebElement source1 = driver.findElement(By.id("source"));
        WebElement destination = driver.findElement(By.id("destination"));
        actions.dragAndDrop(source1, destination).perform();

        // Asserts
        Assert.assertEquals("expectedText", textElement.getText());
        Assert.assertNotEquals("unexpectedText", textElement.getText());
        Assert.assertTrue(checkboxes.size() > 0);
        Assert.assertFalse(checkboxes.isEmpty());

        // Close WebDriver
        driver.quit();

	}

}
