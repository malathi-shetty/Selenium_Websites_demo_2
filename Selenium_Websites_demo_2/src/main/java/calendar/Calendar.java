package calendar;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.get("https://www.spicejet.com/");
		
		  // Set up WebDriverWait for explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input[@value='Delhi (DEL)']")));
        element.click();
        // Define the XPath
   //     String xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(., 'Bengaluru')]";

        // Wait until the element is clickable
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(., 'Bengaluru')]")));

        // Once the element is clickable, perform the click action
        element1.click();
        
	//	driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(., 'Bengaluru')]")).click();
	//	driver.findElement(By.xpath("//a[@value='BLR']")).click();
	
		
		Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(., 'Chennai')]")).click();
		
	
	// Get today's date dynamically
    int today = LocalDate.now().getDayOfMonth();

    // Build the XPath with today's date dynamically
    String depart_date = "//div[contains(@class, 'css-1dbjc4n') and contains(@class, 'r-6koalj')]//div[normalize-space(text()) = '" + today + "']";

    // Find the element using the dynamic XPath
    WebElement dayElement = driver.findElement(By.xpath(depart_date));

    // Click on the element (or any other action you'd like to perform)
    dayElement.click();
	//
	}

}
