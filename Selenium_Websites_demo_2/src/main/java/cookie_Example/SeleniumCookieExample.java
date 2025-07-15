package cookie_Example;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCookieExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set the path to the chromedriver executable
		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver (ChromeDriver in this case)
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.example.com");

		// **1. Create a Session Cookie**
		Cookie sessionCookie = new Cookie("sessionCookie", // name: "sessionCookie"
				"session_value", // value: "session_value"
				"example.com", // domain: "example.com"
				"/", // path: "/" (available for the entire domain)
				null // expiry: null (session cookie, expires when browser is closed)
		);

		// Add the session cookie to the browser
		driver.manage().addCookie(sessionCookie);

		// **2. Create a Persistent Cookie**
		// Create a persistent cookie that will expire 1 day from now
		Cookie persistentCookie = new Cookie("persistentCookie", // name: "persistentCookie"
				"persistent_value", // value: "persistent_value"
				"example.com", // domain: "example.com"
				"/", // path: "/" (available for the entire domain)
				new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24) // expiry: 1 day from now
		);

		// Add the persistent cookie to the browser
		driver.manage().addCookie(persistentCookie);

		// **3. Retrieve All Cookies**
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("All Cookies:");
		for (Cookie cookie : cookies) {
			System.out.println("Cookie Name: " + cookie.getName());
			System.out.println("Cookie Value: " + cookie.getValue());
			System.out.println("Cookie Domain: " + cookie.getDomain());
			System.out.println("Cookie Path: " + cookie.getPath());
			System.out.println("Cookie Expiry: " + cookie.getExpiry());
			System.out.println("----");
		}

		// **4. Retrieve a Specific Cookie by Name**
		Cookie retrievedCookie = driver.manage().getCookieNamed("sessionCookie");
		if (retrievedCookie != null) {
			System.out.println("Retrieved Cookie:");
			System.out.println("Name: " + retrievedCookie.getName());
			System.out.println("Value: " + retrievedCookie.getValue());
		} else {
			System.out.println("Cookie 'sessionCookie' not found.");
		}

		// **5. Delete a Specific Cookie by Name**
		driver.manage().deleteCookieNamed("sessionCookie");
		System.out.println("Session Cookie Deleted!");

		// **6. Delete All Cookies**
		driver.manage().deleteAllCookies();
		System.out.println("All cookies have been deleted.");

		// Close the browser
		driver.quit();
	}

}

/*
 * 
 * Explanation of the Code:
 * 
 * 1. Create and Add Session Cookie
 * 
 * 
 * Cookie sessionCookie = new Cookie(
 * 
 * "sessionCookie", // Cookie name
 * 
 * "session_value", // Cookie value
 * 
 * "example.com", // Domain
 * 
 * "/", // Path (accessible for the entire domain)
 * 
 * null // Expiry (null means session cookie, which expires when the browser is
 * closed)
 * 
 * );
 * 
 * driver.manage().addCookie(sessionCookie);
 * 
 * This creates a session cookie. It does not have an expiry date, meaning it
 * will expire when the browser session ends.
 * 
 * 2. Create and Add Persistent Cookie
 * 
 * 
 * Cookie persistentCookie = new Cookie(
 * 
 * "persistentCookie", // Cookie name
 * 
 * "persistent_value", // Cookie value
 * 
 * "example.com", // Domain
 * 
 * "/", // Path
 * 
 * new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24) // Expiry: 1 day
 * from now
 * 
 * );
 * 
 * driver.manage().addCookie(persistentCookie);
 * 
 * This creates a persistent cookie, which has an expiry date set to 1 day from
 * the current time. This cookie will be stored even after the browser is
 * closed, until it expires.
 * 
 * 3. Retrieve All Cookies
 * 
 * 
 * Set<Cookie> cookies = driver.manage().getCookies();
 * 
 * This retrieves all cookies for the current session and prints their details
 * (name, value, domain, path, and expiry).
 * 
 * 4. Retrieve a Specific Cookie by Name
 * 
 * 
 * 
 * Cookie retrievedCookie = driver.manage().getCookieNamed("sessionCookie");
 * 
 * This retrieves the cookie with the name sessionCookie. If the cookie is
 * found, it prints its details.
 * 
 * 5. Delete a Specific Cookie
 * 
 * 
 * 
 * driver.manage().deleteCookieNamed("sessionCookie");
 * 
 * This deletes the specific cookie with the name sessionCookie.
 * 
 * 6. Delete All Cookies
 * 
 * 
 * driver.manage().deleteAllCookies();
 * 
 * This deletes all cookies for the current session.
 * 
 * Closing the Browser
 * 
 * 
 * 
 * driver.quit();
 * 
 * This closes the browser once the operations are completed.
 * 
 * Notes:
 * 
 * Session Cookies: If you don't specify the expiry time (i.e., set it to null),
 * the cookie is a session cookie, which will be deleted when the browser is
 * closed.
 * 
 * Persistent Cookies: You can specify an expiry time for persistent cookies.
 * The cookie will stay until the specified expiration date (or until deleted
 * manually).
 * 
 * Retrieving Cookies: You can retrieve all cookies using getCookies(), or you
 * can retrieve a specific cookie by name using getCookieNamed().
 * 
 * Output:
 * 
 * When you run the code, you will see something like this:
 * 
 * 
 * All Cookies:
 * 
 * Cookie Name: sessionCookie
 * 
 * Cookie Value: session_value
 * 
 * Cookie Domain: example.com
 * 
 * Cookie Path: /
 * 
 * Cookie Expiry: null
 * 
 * ----
 * 
 * Cookie Name: persistentCookie
 * 
 * Cookie Value: persistent_value
 * 
 * Cookie Domain: example.com
 * 
 * Cookie Path: /
 * 
 * Cookie Expiry: Thu Nov 16 13:00:00 GMT 2024
 * 
 * ----
 * 
 * Retrieved Cookie:
 * 
 * Name: sessionCookie
 * 
 * Value: session_value
 * 
 * Session Cookie Deleted!
 * 
 * All cookies have been deleted.
 * 
 * This example provides a complete overview of how to create, add, retrieve,
 * and delete cookies (both session and persistent) in Selenium with Java.
 */