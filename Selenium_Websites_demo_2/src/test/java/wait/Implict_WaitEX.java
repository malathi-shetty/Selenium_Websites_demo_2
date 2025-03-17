package wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implict_WaitEX {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implict Wait
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		Thread.sleep(3000);

		addItems(driver, itemsNeeded);
		// Implict_WaitEX i = new Implict_WaitEX(); // if dont want to make method addItems static
		// i.addItems(driver, itemsNeeded)

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
	//	Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		driver.quit();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-"); // Brocolli - 1 Kg: name[0]: Brocolli, name[1]: 1 Kg
			String formattedName = name[0].trim();

			// format it to get actual vegetable name
			// convert array into arrayList for easy search
			// Check whether name you extracted is present in arrayList or not

			List itemsNeededlist = Arrays.asList(itemsNeeded);

			if (itemsNeededlist.contains(formattedName)) {
				j++;
				// click on Add to Cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println("Found and adding to cart: " + formattedName);
				if (j == itemsNeeded.length)
					break;

			}
		}
	}

}
