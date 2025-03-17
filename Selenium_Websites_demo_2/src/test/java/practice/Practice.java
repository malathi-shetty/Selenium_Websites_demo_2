package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {
		
		 WebDriver driver;
		 // Set up WebDriver
	//	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://automationexercise.com/");
        
        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Test User");
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("abcd.efgh@practice.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        
        driver.findElement(By.id("id_gender2")).click();
        
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abcdefgh123"); 
        

		 Select Daydropdown = new Select(driver.findElement(By.id("days")));
		 Daydropdown.selectByValue("5"); // By Value
		 
		 Select Monthdropdown = new Select(driver.findElement(By.id("months")));
		 
		 Monthdropdown.selectByVisibleText("September"); // By Visible Text
		 
		 Select Yeardropdown = new Select(driver.findElement(By.id("years")));
		 Yeardropdown.selectByIndex(1); // By Index
        
		 
			driver.findElement(By.cssSelector("input[id*='newsletter']")).click(); // selects checkbox
			System.out.println(driver.findElement(By.cssSelector("input[id*='newsletter']")).isSelected()); 
			
			driver.findElement(By.cssSelector("input[id*='optin']")).click(); // selects checkbox
			System.out.println(driver.findElement(By.cssSelector("input[id*='optin']")).isSelected()); 
        
			
			 driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Kathleen M");
			 
			 driver.findElement(By.id("last_name")).sendKeys("Mitchell");
			 
			 driver.findElement(By.id("company")).sendKeys("teie_mann");
			 
			 driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("4779 Prudence Street");
			 
			 driver.findElement(By.id("address2")).sendKeys("Michigan");
			 
			 Select country = new Select(driver.findElement(By.id("country")));
			 country.selectByValue("United States"); // By Value
			  
			 driver.findElement(By.id("state")).sendKeys("MI");
			 
			 driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Detroit");
			 
			 driver.findElement(By.id("zipcode")).sendKeys("48205");
			 
			 driver.findElement(By.name("mobile_number")).sendKeys("3138125644");
			 
			 driver.findElement(By.xpath("//button[text()='Create Account']")).click();
			 
			// Capture the current URL
	            String currentUrl = driver.getCurrentUrl();
	            System.out.println("Current URL: " + currentUrl);

	            // Capture the text inside the <b> element
	            WebElement accountCreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']"));
	            String text = accountCreatedText.getText();
	            System.out.println("Text found: " + text);
	        
	            // Close the browser
	            driver.quit();
	        
			
			/*
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("abcd.efgh@practice.com");
        
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("abcdefgh123"); 

        
        // Locate links by linkText() and partialLinkText()
        driver.findElement(By.linkText("Home")).click();
        driver.navigate().back(); // Go back to the previous page
        driver.findElement(By.partialLinkText("Pract")).click();
		*/
		

	}

}
