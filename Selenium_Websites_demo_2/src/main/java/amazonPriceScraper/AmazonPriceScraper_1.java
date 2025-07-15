package amazonPriceScraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceScraper_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		  WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
          searchBox.sendKeys("mobile phone");
          searchBox.submit();

          // Wait for results to load and find the price using XPath
          Thread.sleep(3000); // Implicit wait (better to use WebDriverWait)
          
          WebElement TextElement = driver.findElement(By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]"));
          String Text = TextElement.getText();
          System.out.println("Mobile Name: " + Text);

          WebElement priceElement = driver.findElement(By.xpath("//span[contains(@class, 'a-price-whole')]"));
          String price = priceElement.getText();
          System.out.println("Mobile Price: " + price);
          
          // Close the driver
          driver.quit();
	}

}
