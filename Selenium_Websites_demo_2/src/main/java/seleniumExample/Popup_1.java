package seleniumExample;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popup_1 {

	public static void main(String[] args) {
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();

	        // Initialize the WebDriver
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//url launch
		driver.get("https://secure.indeed.com/auth?hl=en");
		driver.findElement(By.id("login-google-button")).click();
		
		//Hold window Handles
		Set<String> s = driver.getWindowHandles();
		
		//iterate Handles
		Iterator<String> i = s.iterator();
		
		//child window handle id
		String c = i.next();
		
		//parent window handle id
		String p = i.next();
		
		// child window switch
		driver.switchTo().window(c);
		System.out.println("Page title of child window: " + driver.getTitle());
		
		
		//switch to parent window
		driver.switchTo().window(p);
		System.out.println("Page title of parent window: " + driver.getTitle());

		//browser quit
		driver.quit();

	}

}
