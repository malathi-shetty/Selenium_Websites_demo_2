package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDataCapture {

	public static void main(String[] args) throws InterruptedException {
		
		 // Set up WebDriver with ChromeOptions to disable autofill
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");  // Disable all extensions
        options.addArguments("--disable-autofill");    // Disable autofill
        options.addArguments("--disable-translate");   // Disable translation
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
        options.addArguments("--incognito");  // Start browser in incognito mode
        
		 WebDriver driver;
	        
	        // Set up WebDriver
	      //  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Dynamic Data Variables
	        String title = "Mr.";  // This can be "Mr." or "Mrs."
	        String name = "Beth Edwards";
	        String email = "beth" + System.currentTimeMillis() + "@gmail.com"; // Generate unique email
	        String password = "augustine2014";
	        String day = "7"; // Day of birth
	        String month = "October"; // Month of birth
	        String year = "1997"; // Year of birth
	        String firstName = "Beth";
	        String lastName = "Edwards";
	        String company = "Dubiotech";
	        String address1 = "546 Water Street";
	        String address2 = "California";
	        String country = "United States";
	        String state = "CA";
	        String city = "Walnut Creek";
	        String zipcode = "94597";
	        String mobileNumber = "4088582285";
	        
	     
	        
	        // Navigate to the URL
	        driver.get("https://automationexercise.com/");
	        
	        driver.findElement(By.linkText("Signup / Login")).click();
	        
	        Thread.sleep(2000); // Wait for 2 seconds

	        System.out.println("**********");
	        
	        // Capture the current URL after account creation
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("Current URL after account creation: " + currentUrl);
	        
	        // Fill in dynamic data
	        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
	        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(email);
	        driver.findElement(By.xpath("//button[text()='Signup']")).click();

	        // Select Title (Gender)
	        if(title.equals("Mr.")){
	            driver.findElement(By.id("id_gender1")).click();  // Male
	        } else {
	            driver.findElement(By.id("id_gender2")).click();  // Female
	        }

	        WebElement passwordElement = driver.findElement(By.id("password"));
	        passwordElement.sendKeys(password);

	        // Select Date of Birth (Day, Month, Year)
	        Select dayDropdown = new Select(driver.findElement(By.id("days")));
	        dayDropdown.selectByValue(day);

	        Select monthDropdown = new Select(driver.findElement(By.id("months")));
	        monthDropdown.selectByVisibleText(month);

	        Select yearDropdown = new Select(driver.findElement(By.id("years")));
	        yearDropdown.selectByVisibleText(year);

	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	        // Select checkboxes for newsletter and special offers
	       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id*='newsletter']")))).click();
	       wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.cssSelector("input[id*='optin']")))).click();
	        
	        Thread.sleep(2000);
	        // Capture checkbox statuses
	        System.out.println("Is Newsletter selected: " + driver.findElement(By.cssSelector("input[id*='newsletter']")).isSelected());
	        System.out.println("Is Optin selected: " + driver.findElement(By.cssSelector("input[id*='optin']")).isSelected());
	        
	        // Address Information
	        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
	        driver.findElement(By.id("last_name")).sendKeys(lastName);
	        driver.findElement(By.id("company")).sendKeys(company);
	        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address1);
	        driver.findElement(By.id("address2")).sendKeys(address2);
	        
	        Thread.sleep(2000); 
	        Select countryDropdown = new Select(driver.findElement(By.id("country")));
	        countryDropdown.selectByVisibleText(country);

	        driver.findElement(By.id("state")).sendKeys(state);
	        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys(city);
	        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
	        driver.findElement(By.name("mobile_number")).sendKeys(mobileNumber);

	        Thread.sleep(2000); // Wait for 2 seconds
	        // Submit the form to create the account
	        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

 System.out.println("**********");
	        
 String actualTitle = driver.getTitle();
    System.out.println("Actual Title: " + actualTitle);

	        // Capture dynamic input data that was entered
	        System.out.println("Name entered: " + name);
	        System.out.println("Email entered: " + email);
	        System.out.println("Password entered: " + password);
	        System.out.println("Date of Birth entered: " + day + " " + month + " " + year);
	        System.out.println("First Name entered: " + firstName);
	        System.out.println("Last Name entered: " + lastName);
	        System.out.println("Company entered: " + company);
	        System.out.println("Address entered: " + address1 + ", " + address2);
	        System.out.println("Country selected: " + country);
	        System.out.println("State entered: " + state);
	        System.out.println("City entered: " + city);
	        System.out.println("Zipcode entered: " + zipcode);
	        System.out.println("Mobile Number entered: " + mobileNumber);
	        
	        System.out.println("**********");
	        
	        // Capture the current URL after account creation
	        String currentUrl2 = driver.getCurrentUrl();
	        System.out.println("Current URL after account creation: " + currentUrl2);

	        // Capture the text inside the <b> element ("Account Created!" message)
	        WebElement accountCreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']"));
	        String accountCreatedMessage = accountCreatedText.getText();
	        System.out.println("Account Created Message: " + accountCreatedMessage);

	       
	        // Close the browser
	        driver.quit();

	}

}
