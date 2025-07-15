package cookie_Example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieExample {

	// how to use cookie using selenium in java

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		// Add a cookie
		Cookie cookie = new Cookie("myCookie", "cookie_value", "amazon.in", "/", null);
		driver.manage().addCookie(cookie);

		// Get the cookie by name
		Cookie retrievedCookie = driver.manage().getCookieNamed("myCookie");
		System.out.println("Cookie Name: " + retrievedCookie.getName());
		System.out.println("Cookie Value: " + retrievedCookie.getValue());

		// Delete the cookie
		driver.manage().deleteCookieNamed("myCookie");

		// Confirm that the cookie has been deleted
		Cookie deletedCookie = driver.manage().getCookieNamed("myCookie");
		if (deletedCookie == null) {
			System.out.println("Cookie 'myCookie' has been deleted.");
		}

		// Delete all cookies (if needed)
		// driver.manage().deleteAllCookies();

		// Close the browser
		driver.quit();

	}

}

/*
 * 
 * In Selenium with Java, you can interact with cookies using the WebDriver's
 * cookie-related methods. These methods allow you to add, delete, retrieve, and
 * manage cookies in the browser during the test session.
 * 
 * Steps to Use Cookies in Selenium (Java)
 * 
 * 1. Set Up Selenium in Java
 * 
 * To get started with Selenium in Java, make sure you have the following
 * dependencies in your project:
 * 
 * Selenium WebDriver: You can download the Selenium jar files or use a
 * dependency management tool like Maven or Gradle.
 * 
 * For Maven, you can add the following dependency to your pom.xml:
 * 
 * 
 * <dependency>
 * 
 * <groupId>org.seleniumhq.selenium</groupId>
 * 
 * <artifactId>selenium-java</artifactId>
 * 
 * <version>4.x.x</version> <!-- Replace with the latest version -->
 * 
 * </dependency>
 * 
 * You also need a WebDriver (e.g., ChromeDriver) for the browser you intend to
 * automate.
 * 
 * 2. Launching the Web Browser You can launch a browser using the WebDriver
 * class. Here's an example using Chrome:
 * 
 * 
 * 
 * import org.openqa.selenium.WebDriver;
 * 
 * import org.openqa.selenium.chrome.ChromeDriver;
 * 
 * import org.openqa.selenium.chrome.ChromeOptions;
 * 
 * public class SeleniumCookieExample {
 * 
 * public static void main(String[] args) {
 * 
 * // Set the path to your ChromeDriver if needed
 * 
 * System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
 * 
 * // Create ChromeOptions for headless mode (optional)
 * 
 * ChromeOptions options = new ChromeOptions();
 * 
 * options.addArguments("--headless");
 * 
 * // Initialize the WebDriver WebDriver driver = new ChromeDriver(options);
 * 
 * // Navigate to a website driver.get("https://www.example.com");
 * 
 * // Perform cookie operations here (add, get, delete)
 * 
 * driver.quit();
 * 
 * }
 * 
 * }
 * 
 * 3. Adding a Cookie To add a cookie, you use the manage().addCookie(Cookie
 * cookie) method. The Cookie object represents the cookie.
 * 
 * Here’s how to add a cookie:
 * 
 * 
 * 
 * import org.openqa.selenium.Cookie;
 * 
 * public class SeleniumCookieExample { public static void main(String[] args) {
 * 
 * WebDriver driver = new ChromeDriver();
 * 
 * driver.get("https://www.example.com");
 * 
 * // Create a new cookie Cookie cookie = new Cookie("myCookie", "cookie_value",
 * "example.com", "/", null); // null means no expiry
 * 
 * // Add the cookie to the browser driver.manage().addCookie(cookie);
 * 
 * // Optionally, refresh the page to see the effect
 * driver.navigate().refresh();
 * 
 * driver.quit(); } } 4. Getting Cookies To retrieve all cookies for the current
 * session or specific cookies, you can use getCookies() or getCookieNamed()
 * methods.
 * 
 * Get all cookies:
 * 
 * 
 * import org.openqa.selenium.Cookie;
 * 
 * import java.util.Set;
 * 
 * public class SeleniumCookieExample {
 * 
 * public static void main(String[] args) {
 * 
 * WebDriver driver = new ChromeDriver();
 * 
 * driver.get("https://www.example.com");
 * 
 * // Get all cookies Set<Cookie> cookies = driver.manage().getCookies();
 * 
 * for (Cookie cookie : cookies) {
 * 
 * System.out.println("Cookie Name: " + cookie.getName());
 * 
 * System.out.println("Cookie Value: " + cookie.getValue());
 * 
 * }
 * 
 * driver.quit(); }
 * 
 * }
 * 
 * Get a specific cookie by name:
 * 
 * 
 * Cookie cookie = driver.manage().getCookieNamed("myCookie");
 * 
 * System.out.println("Cookie Value: " + cookie.getValue());
 * 
 * 5. Deleting Cookies
 * 
 * You can delete cookies in two ways: delete a specific cookie or delete all
 * cookies.
 * 
 * Delete a specific cookie:
 * 
 * driver.manage().deleteCookieNamed("myCookie");
 * 
 * Delete all cookies:
 * 
 * 
 * driver.manage().deleteAllCookies();
 * 
 * 6. Example: Full Example of Adding, Retrieving, and Deleting Cookies
 * 
 * 
 * import org.openqa.selenium.WebDriver;
 * 
 * import org.openqa.selenium.chrome.ChromeDriver;
 * 
 * import org.openqa.selenium.Cookie;
 * 
 * public class SeleniumCookieExample {
 * 
 * public static void main(String[] args) {
 * 
 * // Set the path to ChromeDriver
 * 
 * System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
 * 
 * WebDriver driver = new ChromeDriver();
 * 
 * driver.get("https://www.example.com");
 * 
 * // Add a cookie Cookie cookie = new Cookie("myCookie", "cookie_value",
 * "example.com", "/", null); driver.manage().addCookie(cookie);
 * 
 * // Get the cookie by name Cookie retrievedCookie =
 * driver.manage().getCookieNamed("myCookie");
 * 
 * System.out.println("Cookie Name: " + retrievedCookie.getName());
 * 
 * System.out.println("Cookie Value: " + retrievedCookie.getValue());
 * 
 * // Delete the cookie driver.manage().deleteCookieNamed("myCookie");
 * 
 * // Confirm that the cookie has been deleted
 * 
 * Cookie deletedCookie = driver.manage().getCookieNamed("myCookie");
 * 
 * if (deletedCookie == null) {
 * 
 * System.out.println("Cookie 'myCookie' has been deleted.");
 * 
 * }
 * 
 * // Close the browser
 * 
 * driver.quit();
 * 
 * }
 * 
 * }
 * 
 * Key Notes:
 * 
 * Cookie Expiry: If you don't set an expiry date, the cookie will be a session
 * cookie and will be deleted once the browser is closed.
 * 
 * Domain: Ensure the domain specified in the cookie matches the current domain.
 * Otherwise, the cookie won't be added.
 * 
 * Secure Cookies: If the site uses secure cookies (set with the Secure flag),
 * you may need to use https to access the cookies.
 * 
 * Advanced: Using Cookies for Login
 * 
 * You can also use cookies to simulate logged-in sessions. After logging in
 * manually, you can extract cookies and use them in future tests. You can save
 * cookies to a file, load them, and add them back to the browser during the
 * test.
 * 
 * This method helps when you want to avoid repetitive login actions during
 * automation.
 * 
 * Advanced Use: Simulating Login Sessions with Cookies
 * 
 * Cookies are useful for simulating logged-in sessions. You can manually log in
 * to a site, grab the cookies, and then reuse those cookies in your Selenium
 * script to skip the login step.
 * 
 * 
 * To achieve this:
 * 
 * Manually Log In: Open the browser, log in to the site, and retrieve cookies
 * (using the browser’s Developer Tools).
 * 
 * Add Cookies: Programmatically add the cookies into Selenium.
 * 
 * Reuse the Cookies: Refresh the page or navigate to other pages to maintain
 * the session.
 * 
 * This is commonly used to speed up tests by skipping login steps.
 *******
 * 
 * 
 * Cookie Parameters in Selenium (Java)
 * 
 * When you add a cookie in Selenium, you can specify different attributes for
 * the cookie. Here's a breakdown of each attribute you can set:
 * 
 * 1. name
 * 
 * Description: The name of the cookie. This is a unique identifier for the
 * cookie within the browser session.
 * 
 * Example: "myCookie"
 * 
 * 2. value
 * 
 * Description: The value of the cookie. This is the data that the cookie
 * stores, which could be anything (e.g., a session ID, user preferences, etc.).
 * 
 * Example: "cookie_value"
 * 
 * 3. domain
 * 
 * Description: The domain to which the cookie belongs. This specifies the
 * domain for which the cookie is valid. If not set, it defaults to the domain
 * of the current page.
 * 
 * Note: The domain should match the domain of the site you're working with;
 * otherwise, the cookie will not be applied. Example: "example.com"
 * 
 * 4. path
 * 
 * Description: The path for which the cookie is valid. The path specifies the
 * URL path to which the cookie is accessible. If not set, the cookie will be
 * available to the entire domain.
 * 
 * Example: "/" (This means the cookie will be available throughout the entire
 * domain) 5. expiry
 * 
 * Description: The expiration time for the cookie. If set, the cookie will be
 * persistent and remain stored until the specified expiration time. If not set
 * (or set to null), the cookie will be a session cookie and will expire when
 * the browser is closed.
 * 
 * Example: null (or a specific timestamp if you want the cookie to persist
 * beyond the session)
 * 
 * Creating and Adding a Cookie in Selenium (Java)
 * 
 * To add a cookie in Selenium using the above attributes, we create a Cookie
 * object and pass the necessary parameters. Here's an example of how to create
 * and add a cookie:
 * 
 * 
 * 
 * import org.openqa.selenium.Cookie;
 * 
 * import org.openqa.selenium.WebDriver;
 * 
 * import org.openqa.selenium.chrome.ChromeDriver;
 * 
 * public class SeleniumCookieExample {
 * 
 * public static void main(String[] args) {
 * 
 * // Set the path to the chromedriver executable
 * 
 * System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
 * 
 * // Initialize the WebDriver (ChromeDriver in this case)
 * 
 * WebDriver driver = new ChromeDriver();
 * 
 * driver.get("https://www.example.com");
 * 
 * // Create a new cookie
 * 
 * Cookie cookie = new Cookie(
 * 
 * "myCookie", // name: The name of the cookie
 * 
 * "cookie_value", // value: The value of the cookie
 * 
 * "example.com", // domain: The domain to which the cookie belongs
 * 
 * "/", // path: The path for which the cookie is valid
 * 
 * null // expiry: null means the cookie is a session cookie (will expire when
 * the browser is closed)
 * 
 * );
 * 
 * // Add the cookie to the browser session
 * 
 * driver.manage().addCookie(cookie);
 * 
 * // Optionally, refresh the page to apply the cookie
 * 
 * driver.navigate().refresh();
 * 
 * // Close the browser
 * 
 * driver.quit();
 * 
 * }
 * 
 * }
 * 
 * Breakdown of the Cookie Creation in Java:
 * 
 * 
 * Cookie cookie = new Cookie(
 * 
 * "myCookie", // name: The name of the cookie
 * 
 * "cookie_value", // value: The value of the cookie
 * 
 * "example.com", // domain: The domain to which the cookie belongs
 * 
 * "/", // path: The path for which the cookie is valid ("/" means available
 * across the entire domain)
 * 
 * null // expiry: null means the cookie will expire when the browser is closed
 * (session cookie)
 * 
 * );
 * 
 * Explanation of Example Cookie in Java
 * 
 * "myCookie": This is the name of the cookie, and it's how you can refer to the
 * cookie later (e.g., when retrieving it).
 * 
 * "cookie_value": This is the value of the cookie. It can represent any data
 * you want to store, such as session IDs or user preferences.
 * 
 * "example.com": This is the domain of the cookie. The cookie will only be sent
 * to this domain (or subdomains if allowed).
 * 
 * "/": This is the path for which the cookie is valid. The cookie will be
 * available across the entire domain if you set it as "/".
 * 
 * null: This means the expiry is not set, making the cookie a session cookie.
 * Session cookies are deleted when the browser session ends.
 * 
 * Additional Notes:
 * 
 * Session Cookies: If you don’t set the expiry attribute, the cookie will be
 * treated as a session cookie, which will be deleted when the browser is
 * closed.
 * 
 * Persistent Cookies: If you want the cookie to persist, you can set an expiry
 * value. For example, you can create an expiration time like this:
 * 
 * 
 * import java.util.Date;
 * 
 * Cookie persistentCookie = new Cookie(
 * 
 * "persistentCookie",
 * 
 * "cookie_value",
 * 
 * "example.com",
 * 
 * "/",
 * 
 * new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24) // Expiry: 1 day
 * from now
 * 
 * );
 * 
 * This cookie will persist for 1 day after it is set.
 * 
 * This explanation covers the same points you mentioned and how they are
 * represented in the context of Selenium with Java. Let me know if you need any
 * further details or examples!
 * 
 * 
 * 
 * 
 * 
 * 
 */
