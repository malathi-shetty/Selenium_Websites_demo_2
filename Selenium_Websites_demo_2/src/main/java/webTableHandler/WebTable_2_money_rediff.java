package webTableHandler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_2_money_rediff {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/index.html");
		
		WebElement table = driver.findElement(By.cssSelector(".hmbseindicestable show")); // class name
		
		int rows = table.findElements(By.tagName("ul")).size();
		System.out.println(rows);

		// Locate the table and get rows
		List<WebElement> cols = table.findElements(By.tagName("ul")).get(0).findElements(By.tagName("li"));
		cols.size();
		System.out.println(cols.size());
		
		for(int i =1; i<=rows; i++)
		{
			for(int j =1; i<=cols.size(); j++)
			{
				System.out.println(driver.findElement(By.xpath("//div[@class='hmnseindicestable']//ul["+i+"]/li["+j+"]")).getText() + " ");
			}
			System.out.println();
		}
		
		

	}

}
