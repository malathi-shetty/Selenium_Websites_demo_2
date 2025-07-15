package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar_2 {

	public static void main(String[] args) throws InterruptedException {
	      WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.spicejet.com/");

	        // Set up WebDriverWait for explicit wait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input[@value='Delhi (DEL)']")));
	        element.click();

	        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(., 'Bengaluru')]")));
	        element1.click();

	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(., 'Chennai')]")).click();

	        // The specific date you want to select: 14th February 2025
	        String targetDay = "14"; // Desired day
	        String targetMonth = "February"; // Desired month
	        String targetYear = "2025"; // Desired year

	        // Find the current month and year displayed on the calendar
	        String currentMonthYear = driver.findElement(By.xpath("//div[contains(@class, 'css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088') and contains(., 'February 2025')]")).getText();
	        
	        // Check if the displayed month and year match the target month and year
	        while (!currentMonthYear.equals(targetMonth + " " + targetYear)) {
	            // If not, click on the "next" button to go to the next month
	            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep']//div[@aria-label='Next month']")).click();
	            
	            // Wait for the calendar to update and find the current month and year again
	            Thread.sleep(1000);  // Optional: you may want to use an explicit wait here
	            currentMonthYear = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(text(), 'February 2025')]")).getText();
	        }
	        
	        // Build the XPath with the target day dynamically
	        String departDateXpath = "//div[contains(@class, 'css-1dbjc4n') and contains(@class, 'r-6koalj')]//div[normalize-space(text()) = '" + targetDay + "']";
	        
	        // Find and click the target day element
	        WebElement dayElement = driver.findElement(By.xpath(departDateXpath));
	        dayElement.click();
	    }
	

	}


