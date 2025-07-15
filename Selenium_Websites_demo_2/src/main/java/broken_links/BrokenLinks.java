package broken_links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<String> linkAddress = new ArrayList<>();

		for (WebElement totallinks : links) {
			linkAddress.add(totallinks.getAttribute("href"));
		}
		System.out.println("total links are: " + linkAddress.size());

		for (String link : linkAddress) {
			
			URL url = new URL(link);
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("GET");
			connect.setConnectTimeout(3000);
			System.out.println(link + " : " + connect.getResponseCode());
		
			driver.quit();

		}

	}

}
