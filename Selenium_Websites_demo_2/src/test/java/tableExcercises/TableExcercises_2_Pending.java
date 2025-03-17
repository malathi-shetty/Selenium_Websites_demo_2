package tableExcercises;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TableExcercises_2_Pending {

	public static void main(String[] args) {
		int team1Sum = 0;
        int team2Sum = 0;

        // Set up WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize window and open the URL
        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/87878/rsa-vs-ind-final-icc-mens-t20-world-cup-2024");

        // Find both team's score sections (adjust selectors based on the actual page)
        WebElement team1Table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        WebElement team2Table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
     
        // Find total score for Team 1
        String team1Total = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int team1TotalValue = Integer.parseInt(team1Total);
        
        // Find total score for Team 2
        String team2Total = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int team2TotalValue = Integer.parseInt(team2Total);
        
        // Extract "Extras" and calculate total score for Team 1
        try {
            String team1Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
            int team1ExtrasValue = Integer.parseInt(team1Extras);
            team1Sum = team1TotalValue + team1ExtrasValue;
            System.out.println("Calculated Total Score for Team 1 (with Extras): " + team1Sum);
        } catch (Exception e) {
            System.out.println("Error extracting Team 1 Extras: " + e.getMessage());
        }

        // Extract "Extras" and calculate total score for Team 2
        try {
            String team2Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
            int team2ExtrasValue = Integer.parseInt(team2Extras);
            team2Sum = team2TotalValue + team2ExtrasValue;
            System.out.println("Calculated Total Score for Team 2 (with Extras): " + team2Sum);
        } catch (Exception e) {
            System.out.println("Error extracting Team 2 Extras: " + e.getMessage());
        }

        // Compare Team 1 and Team 2 total scores
        System.out.println("Actual Total Score for Team 1: " + team1TotalValue);
        System.out.println("Actual Total Score for Team 2: " + team2TotalValue);
        
        if (team1TotalValue == team1Sum && team2TotalValue == team2Sum) {
            System.out.println("Team 1 and Team 2 totals match their calculated scores (with Extras).");
        } else {
            System.out.println("Team 1 or Team 2 totals don't match their calculated scores.");
        }

        // Close the driver
        driver.quit();

	}

}
