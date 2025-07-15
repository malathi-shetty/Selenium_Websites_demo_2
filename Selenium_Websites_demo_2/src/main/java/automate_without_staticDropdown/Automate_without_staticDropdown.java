package automate_without_staticDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_without_staticDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));
		
		for(int i=0; i<options.size();i++)
		{
			String text = options.get(i).getText();
			
			if(text.equalsIgnoreCase("Option3"))
			{
				options.get(i).click();
				break;
			}
		}
		
		driver.quit();

	}

}
