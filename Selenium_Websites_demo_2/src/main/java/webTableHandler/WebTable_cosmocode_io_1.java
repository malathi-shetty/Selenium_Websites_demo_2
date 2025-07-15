package webTableHandler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_cosmocode_io_1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

		driver.quit();
	}

}
