package browserStackTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackTest {

//https://<USERNAME>:<ACCESS_KEY>@hub-cloud.browserstack.com/wd/hub
//curl -u "YOUR_BROWSERSTACK_USERNAME:YOUR_BROWSERSTACK_ACCESS_KEY" https://hub-cloud.browserstack.com/wd/hub/status

	public static final String USERNAME = "YOUR_BROWSERSTACK_USERNAME";
	public static final String ACCESS_KEY = "YOUR_BROWSERSTACK_ACCESS_KEY";
	public static final String BASE_URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("platformName", "Windows");

		DesiredCapabilities bstackOptions = new DesiredCapabilities();
		bstackOptions.setCapability("name", "Cross Browser Test");
		bstackOptions.setCapability("build", "Java Sample Build");

		capabilities.setCapability("bstack:options", bstackOptions);

		WebDriver driver = null;
		try {
			URL url = new URI(BASE_URL).toURL();
			driver = new RemoteWebDriver(url, capabilities);
			driver.get("https://demoqa.com/automation-practice-form");
			System.out.println("Title: " + driver.getTitle());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

}
