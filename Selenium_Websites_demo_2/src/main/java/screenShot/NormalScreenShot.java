package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		//Take Normal ScreenShot
		
		TakesScreenshot ts = (TakesScreenshot)driver; // Typecasting TakeScreenshot interface with WebDriver
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshot//NormalScreenShot.png");
		FileUtils.copyFile(src, dest);
		
		driver.quit();

	}

}


// Note: make a folder named Screenshot