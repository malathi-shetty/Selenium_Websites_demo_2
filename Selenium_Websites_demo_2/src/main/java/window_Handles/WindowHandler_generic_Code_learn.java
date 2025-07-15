package window_Handles;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler_generic_Code_learn {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Open the URL
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2017/");
		String parentid = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()=' Click here for Google ']")).click();
		System.out.println("Google Window");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' Click here for Facebook ']")).click();
		System.out.println("Facebook Window");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' Click here for Gmail ']")).click();
		System.out.println("Gmail Window");
		Thread.sleep(2000);
		Set<String> ids = driver.getWindowHandles();

		ArrayList newobj = new ArrayList(ids);
		if (switchtoRightWindow(newobj, "Facebook")) {
			System.out.println(driver.getTitle());
		}

		System.out.println("Switched to Parent Window");
		SwitchToparentWindow(parentid);
		
		CloseallwindowsExceptParent(newobj, parentid);

		//driver.quit();
	}

	public static void CloseallwindowsExceptParent(ArrayList<String> newobj, String parentid) {
		for (String window : newobj) {
			if (!parentid.equals(window)) {
				System.out.println("Child window is getting close");
				driver.switchTo().window(window).close();
			}
		}
	}

	public static void SwitchToparentWindow(String parentid) {
		System.out.println("Parent window");
		driver.switchTo().window(parentid);
	}

	public static boolean switchtoRightWindow(ArrayList<String> newobj, String title) {
		for (String window : newobj) {
			
			String titles = driver.switchTo().window(window).getTitle();

			if (titles.contains(title)) {
				System.out.println("Child window - You are on the right window");
				return true;
			}
		}
		return false;
	}

}
