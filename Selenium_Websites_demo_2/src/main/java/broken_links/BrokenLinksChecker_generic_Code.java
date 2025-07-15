package broken_links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksChecker_generic_Code {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 List<String> linkAddress = new ArrayList<>();
		 for (WebElement totallinks : links) {
				linkAddress.add(totallinks.getAttribute("href"));
			}
		 System.out.println("total links are: " + linkAddress.size());
		 
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	        	
	            if (url != null && !url.isEmpty()) {
	                try {
	                    HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
	                    connection.setRequestMethod("HEAD");
	                    connection.connect();
	                    int respCode = connection.getResponseCode();
	                    if (respCode >= 400) {
	                        System.out.println(url +  " : " + connection.getResponseCode() + " is a broken link.");
	                    } else {
	                        System.out.println(url +  " : " + connection.getResponseCode() + " is a valid link.");
	                    }
	                } catch (Exception e) {
	                	  System.out.println("Error checking link: " + url);
	                
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        driver.quit();
	}
}

	


