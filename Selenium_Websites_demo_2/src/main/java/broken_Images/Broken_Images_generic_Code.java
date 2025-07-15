package broken_Images;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_Images_generic_Code {

    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement img : images) {
            String imgSrc = img.getDomAttribute("src");
            if (imgSrc != null && !imgSrc.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imgSrc).openConnection());
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int respCode = connection.getResponseCode();
                    if (respCode >= 400) {
                        System.out.println(imgSrc + " is a broken image.");
                    } else {
                        System.out.println(imgSrc + " is a valid image.");
                    }
                } catch (Exception e) {
                    System.out.println("Error checking image: " + imgSrc); // Fixed here
                    e.printStackTrace();
                }
            }
        }
    }
}
