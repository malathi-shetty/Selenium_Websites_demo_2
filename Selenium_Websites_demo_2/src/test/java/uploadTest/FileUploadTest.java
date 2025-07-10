package uploadTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
		String filePath = "C://Users//malat//OneDrive//Desktop//New folder (2)//2.jpg";
		fileInput.sendKeys(filePath);

		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(5000);
		WebElement uploaded = driver.findElement(By.id("uploaded-files"));
		System.out.println("Uploaded: " + uploaded.getText());
		Thread.sleep(2000);
		driver.quit();

	}

}
