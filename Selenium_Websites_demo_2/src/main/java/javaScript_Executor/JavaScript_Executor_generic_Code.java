package javaScript_Executor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScript_Executor_generic_Code {
	public static WebDriver driver = new ChromeDriver();
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public void openURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	// Execute JavaScript code
    public Object executeJavaScript(String script, Object... args) {
        return js.executeScript(script, args);
    }

	// scrollToBottom

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Scroll to element
	public void scrollToElement(WebElement element) {
		String script = "arguments[0].scrollIntoView(true);";
		js.executeScript(script, element);
	}

	// Scroll by pixels
	public void scrollBy(int x, int y) {
		String script = "window.scrollBy(arguments[0], arguments[1]);";
		js.executeScript(script, x, y);
	}

	// Get the title of the page
	public String getPageTitle() {
		return (String) js.executeScript("return document.title;");
	}

	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		JavaScript_Executor_generic_Code executor = new JavaScript_Executor_generic_Code();

		// Open the URL
		executor.openURL("https://www.saucedemo.com/");

		WebDriverWait wait = new WebDriverWait(executor.driver, Duration.ofSeconds(20)); // Increased timeout
		Actions actions = new Actions(executor.driver);

		try {
			// Wait for username field to be visible and clickable
			WebElement Username = executor.driver.findElement(By.id("user-name"));
			executor.scrollToElement(Username);
			System.out.println("Username TextBox is visible.");
			Username.sendKeys("standard_user");

			// Wait for password field to be visible and clickable
			WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			Actions action = new Actions(executor.driver);
			action.moveToElement(password).perform();
			System.out.println("password TextBox is visible.");
			password.sendKeys("secret_sauce");


            // Wait for login button to be visible and clickable
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            System.out.println("Login button is visible.");

            // Optionally, use JavaScript to click if regular click fails
            try {
                executor.scrollToElement(login);
                js.executeScript("arguments[0].click();", login); // JavaScript click
            } catch (Exception e) {
                System.out.println("Regular click failed, JavaScript click executed.");
                throw e; // Re-throw to handle in outer try-catch
            }

			// Get the title and print
			String title = executor.getPageTitle();
			System.out.println("Page Title: " + title);
			
			  // Example of executing custom JavaScript code
			 try {
	                // Ensure to wait for the element you want to query
	                //WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
	             
				 WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contents_wrapper")));
				 Object result = executor.executeJavaScript("return arguments[0].innerText;", header);
	                System.out.println("Header Text: " + result);
	            } catch (Exception e) {
	                System.out.println("An error occurred while executing custom JavaScript: " + e.getMessage());
	            }

		} catch (StaleElementReferenceException e) {
			System.out.println("Caught StaleElementReferenceException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the browser
			executor.quit();
		}

	}

}