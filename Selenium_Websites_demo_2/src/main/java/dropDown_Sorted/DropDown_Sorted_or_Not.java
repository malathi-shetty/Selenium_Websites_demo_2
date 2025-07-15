package dropDown_Sorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_Sorted_or_Not {

	public static void main(String[] args) {
		
		//How to Check Elements are Sorted

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		
		List<WebElement> options = s.getOptions();
		
	//	List OriginalList = new ArrayList();
	//	List TempList = new ArrayList();
		
		ArrayList OriginalList = new ArrayList();
		ArrayList TempList = new ArrayList();
		
		for(WebElement k: s.getOptions())
		{
			if(!k.getText().equals("Select"))
			{
				OriginalList.add(k.getText());
				TempList.add(k.getText());
			}
		}
		System.out.println("Before Sorting: " + OriginalList);
		System.out.println("Before Sorting: " + TempList);
		
		Collections.sort(TempList); //Sorted
	//	Collections.sort(TempList, Collections.reverseOrder()); // NotSorted
		
	
		System.out.println("After Sorting: " + TempList);
		if(OriginalList.equals(TempList))
		{
			System.out.println("Sorted");
		}else{
			System.out.println("It is NOT Sorted");
		}

		driver.quit();
	}

}
