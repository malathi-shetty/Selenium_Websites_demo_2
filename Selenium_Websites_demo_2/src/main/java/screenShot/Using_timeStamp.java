package screenShot;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Using_timeStamp {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		//Capture ScreenShot with Timestamp
		
		TakesScreenshot ts = (TakesScreenshot)driver; // Typecasting TakeScreenshot interface with WebDriver
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshot//CaptureScreenShot_" + timeStamp()+".png");
		FileUtils.copyFile(src, dest);
		
		driver.quit();

	}

	private static String timeStamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now).replace(" " , "_").replace("/",  "_").replace(":",  "_");
	}

	

}
