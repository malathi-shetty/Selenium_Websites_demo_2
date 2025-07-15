package window_Handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handles_BasicConcept_learn {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		
		Set<String> ids = driver.getWindowHandles();
		
		Iterator its = ids.iterator();
		
		while(its.hasNext())
		{
			String parent = (String) its.next();
			String child = (String) its.next();
			
			System.out.println("Child Window title:" + driver.switchTo().window(child).getTitle());
			
			System.out.println("Parent Window title:" + driver.switchTo().window(parent).getTitle());
		}
		
		driver.quit();

	}

}
