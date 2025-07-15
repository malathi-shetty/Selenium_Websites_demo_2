package concurrent_User_Simulation;

import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserTask implements Runnable {

//	public static final String URL ="https://www.flipkart.com/"; // Replace with your endpoint URL
	// static final String URL = "http://your-endpoint-url.com";
	// AtomicInteger to maintain a global count
	public static final AtomicInteger accessCount = new AtomicInteger(0);

	public final String URL;

	public UserTask(String url) {
		this.URL = url;
	}

	@Override
	public void run() {
		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--headless")); // Headless mode to reduce
		// resource usage

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless"); WebDriver driver = new
		 * ChromeDriver(options);
		 */

		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		try {
			// driver.get("https://www.flipkart.com");
			driver.get(URL);
			// Increment the access count and get the new count
			int count = accessCount.incrementAndGet();
			// Print the sequential count
			System.out.println("User-Count " + count + ": " + Thread.currentThread().getName() + " accessed " + URL);

		} catch (Exception e) {
			// handle exception
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
/*
 * Driver (setup WebDriver), Count (track accesses), Access (navigate to URL),
 * Cleanup (quit WebDriver).
 * 
 */