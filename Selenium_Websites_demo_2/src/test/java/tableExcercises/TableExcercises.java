package tableExcercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableExcercises {

	public static void main(String[] args) {

		
		   int sum = 0;

	        // Set up WebDriver for Chrome
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

	        // Maximize window and open the URL
	        driver.manage().window().maximize();
	        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/87878/rsa-vs-ind-final-icc-mens-t20-world-cup-2024");

	        // Find the table
	        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

	        // Find all rows containing player scores
	        int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
	        System.out.println("Row Count: " + rowCount);
	        
	        // Iterate over each row, skipping headers, and sum the values
	        for (int i = 0; i < rowCount; i++) {
	            WebElement row = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).get(i);
	           
	            // Find the score for each player (usually in the 5th column, adjust index as needed)
	            try {
	                String value = row.findElements(By.cssSelector("div")).get(4).getText(); // Adjust index (4) based on the table's structure
	               System.out.println("Value: " + value);
	                if (!value.isEmpty()) {
	                    int valueInteger = Integer.parseInt(value);
	                    sum += valueInteger; // Add to the sum
	                }
	            } catch (Exception e) {
	                // In case of error or no value (such as non-numeric cells), skip
	                continue;
	            }
	        }

	        System.out.println("Sum of Player 4s Scores: " + sum);

	        // Extract "Extras" and calculate total score
	        try {
	            String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
	            System.out.println("extras:" + extras);
	            int extrasValue = Integer.parseInt(extras);
	            int totalSumValue = sum + extrasValue;
	            System.out.println("Calculated Total Score (with Extras): " + totalSumValue);

	            // Extract "Total" value from the table
	            String actualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
	            int actualTotalValue = Integer.parseInt(actualTotal);
	            System.out.println("Actual Total Score: " + actualTotalValue);

	            // Compare and verify if the calculated total matches the actual total
	            if (actualTotalValue == totalSumValue) {
	                System.out.println("Count Matches");
	            } else {
	                System.out.println("Count Fails");
	            }
	        } catch (Exception e) {
	            System.out.println("Error extracting Extras or Total: " + e.getMessage());
	        }

	        // Close the driver
	        driver.quit();
	}

}
