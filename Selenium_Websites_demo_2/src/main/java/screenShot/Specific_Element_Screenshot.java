package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Specific_Element_Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		//Taking specific element screenshot - Example - RedBus Logo
		
		WebElement logo = driver.findElement(By.xpath("//header[@id='main_header_new']//descendant::img[@alt='redBus']"));
		TakesScreenshot ts = (TakesScreenshot)driver; // Typecasting TakeScreenshot interface with WebDriver
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshot//ElementLevel_redBusLogo.png");
		FileUtils.copyFile(src, dest);
		
		driver.quit();

	}

}
