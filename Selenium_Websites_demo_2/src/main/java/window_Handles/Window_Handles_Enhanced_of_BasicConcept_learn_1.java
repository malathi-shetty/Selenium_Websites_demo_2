package window_Handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handles_Enhanced_of_BasicConcept_learn_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2017/");

		driver.findElement(By.xpath("//a[text()=' Click here for Google ']")).click();
		driver.findElement(By.xpath("//a[text()=' Click here for Facebook ']")).click();
		driver.findElement(By.xpath("//a[text()=' Click here for Gmail ']")).click();

		Set<String> ids = driver.getWindowHandles();
		Iterator its = ids.iterator();

		while (its.hasNext()) {
			String parent = (String) its.next();
			String child = (String) its.next();

			driver.switchTo().window(child);
			System.out.println(driver.getTitle());

			driver.switchTo().defaultContent();
			System.out.println(driver.getTitle());

		}

		driver.quit();
	}

}
