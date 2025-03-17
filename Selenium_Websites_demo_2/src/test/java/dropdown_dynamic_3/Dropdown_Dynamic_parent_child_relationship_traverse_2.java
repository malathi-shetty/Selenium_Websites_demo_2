package dropdown_dynamic_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Dynamic_parent_child_relationship_traverse_2 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//a[@value='BLR'] - xpath for bangalore
		//a[@value='MAA'] - xpath for chennai
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//  //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR'] --> parent + space + child
		// --> entire div gets selected(i.e parent) + space + & then the selected value (child)
		
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//a[@value='Mgdgshdghs']")).click();//NoSuchElementException: no such element: Unable to locate element
		
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // instead of using index will use parent-child as below
		// //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		

	}

}


