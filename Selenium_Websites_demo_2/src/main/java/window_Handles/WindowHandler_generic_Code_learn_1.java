package window_Handles;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler_generic_Code_learn_1 {



	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Open the URL
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2017/");
		String parentid = driver.getWindowHandle();

		// Click on links to open new windows
		clickAndPrintWindowInfo("//a[text()=' Click here for Google ']", "Google");
		clickAndPrintWindowInfo("//a[text()=' Click here for Facebook ']", "Facebook");
		clickAndPrintWindowInfo("//a[text()=' Click here for Gmail ']", "Gmail");

		// Get all window handles
		Set<String> ids = driver.getWindowHandles();
		ArrayList<String> newobj = new ArrayList<>(ids);

		// Print information about each window
		printAllWindowInfo(newobj);

		// Switch to the desired window and print its title
		if (switchToRightWindow(newobj, "Facebook")) {
			System.out.println("Switched to Facebook Window: " + driver.getTitle());
		}

		// Switch back to parent window
		System.out.println("Switching to Parent Window");
		switchToParentWindow(parentid);

		// Print parent window title
		System.out.println("Parent Window Title: " + driver.getTitle());

		// Close all child windows except parent
		closeAllWindowsExceptParent(newobj, parentid);

		// Slow down before closing the parent window
        Thread.sleep(2000); // Wait for 2 seconds to observe the status
        System.out.println("Closing Parent Window");

        // Close the parent window and end the WebDriver session
        driver.quit(); // This will close all windows and end the WebDriver session

        // Note: No need for additional sleep or quit; driver.quit() handles all cleanup
    }
	

	public static void clickAndPrintWindowInfo(String xpath, String windowName) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		System.out.println(windowName + " Window Opened");
		Thread.sleep(2000); // Wait for 2 seconds to observe the action
	}

	public static void printAllWindowInfo(ArrayList<String> newobj) throws InterruptedException {
		for (String window : newobj) {
			driver.switchTo().window(window);
			System.out.println("Window Handle: " + window + " | Title: " + driver.getTitle());
			Thread.sleep(1000); // Wait for 1 second to observe each window's title
		}
	}

	public static void closeAllWindowsExceptParent(ArrayList<String> newobj, String parentid)
			throws InterruptedException {
		for (String window : newobj) {
			if (!parentid.equals(window)) {
				driver.switchTo().window(window);
				String windowTitle = driver.getTitle(); // Retrieve the title of the window
	           
				Thread.sleep(2000);
				System.out.println("Closing child window: " + window + " " + windowTitle);
				driver.close();
				Thread.sleep(2000); // Wait for 2 seconds after closing each child window
			}
		}
	}

	public static void switchToParentWindow(String parentid) {
		driver.switchTo().window(parentid);
	}

	public static boolean switchToRightWindow(ArrayList<String> newobj, String title) {
		for (String window : newobj) {
			driver.switchTo().window(window);
			String titles = driver.getTitle();
			if (titles.contains(title)) {
				System.out.println("Switched to the right window: " + titles);
				return true;
			}
		}
		return false;
	}

}
