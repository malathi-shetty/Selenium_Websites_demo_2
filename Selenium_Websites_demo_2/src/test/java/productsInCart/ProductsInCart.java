package productsInCart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductsInCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] itemsNeeded={"Cucumber","Brocolli","Beetroot","Carrot"};
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size();i++)
		{
		String[] name = products.get(i).getText().split("-"); //Brocolli - 1 Kg: name[0]: Brocolli, name[1]: 1 Kg
		String formattedName = name[0].trim();
		
		//format it to get actual vegetable name
		//convert array into arrayList for easy search
		//Check whether name you extracted is present in arrayList or not
		
		List itemsNeededlist = Arrays.asList(itemsNeeded);
		
		int j=0;
		if(itemsNeededlist.contains(formattedName))
		{
			j++;
			//click on Add to Cart
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			  System.out.println("Found and adding to cart: " + formattedName);
			if(j==itemsNeeded.length)
				break;
			
		}
		
		}

}}
