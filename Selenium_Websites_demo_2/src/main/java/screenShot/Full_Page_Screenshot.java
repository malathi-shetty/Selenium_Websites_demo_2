package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Full_Page_Screenshot {

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationstepbystep.com/");
		driver.manage().window().maximize();
		
		//Take Full Page ScreenShot
		
		Shutterbug.shootPage(driver, Capture.FULL, true).save(".\\ScreenShot\\EntirePage.png");
		
		
		driver.quit();

	}

}

// NOte: selenium-shutterbug maven dependency is required
