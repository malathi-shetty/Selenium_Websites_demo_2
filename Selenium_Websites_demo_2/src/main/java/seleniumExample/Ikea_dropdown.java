package seleniumExample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Ikea_dropdown {

	//public static void main(String[] args) throws InterruptedException {

		 @Test
		 @Description("This is a description of the test.") 
		 @Step("Step one description")
		    public void testMethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ikea.com/in/en/new/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		WebElement datatext = driver.findElement(By.xpath("//span[text()='Hej! Log in']"));
		action.moveToElement(datatext).click().perform();

		Thread.sleep(5000);
		WebElement Signup = driver.findElement(By.xpath("//h3[text()='Join IKEA Family']"));
		Thread.sleep(5000);
		Signup.click();

		// Selecting multiple items in a dropdown
		Select select = new Select(driver.findElement(By.id("family-signup-form-genderCode")));
		Thread.sleep(1000);
		select.selectByValue("MALE"); // By Value
		Thread.sleep(1000);
		select.selectByVisibleText("Female"); // By Visible Text
		Thread.sleep(1000);
		select.selectByIndex(3); // By Index

		driver.quit();

	}

}
