package dropdown_LoopingUI_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Looping_UI {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	//	driver.findElement(By.id("hrefDecAdt")).click(); //2 adults
//		driver.findElement(By.id("hrefDecAdt")).click(); //3 adults
//		driver.findElement(By.id("hrefDecAdt")).click(); //4 adults
//		driver.findElement(By.id("hrefDecAdt")).click(); //5 adults
		
		// writing like above statemet 4 times doesnt look good
		// so to optimize we need to write it either in while or for loop
		
		// or
		/*int i =1;
		while(i<5) // set true condition until this condition gets false
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //4 times click
			i++;
		}
	*/
	// or 	
	for(int i=1; i<5; i++)	
	{
		driver.findElement(By.id("hrefIncAdt")).click(); //4 times click
		
	}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}

}
