package openNewWindow;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class MultiTabTest {

    public static void main(String[] args) {
        openNewWindow();
    }

    public static void openNewWindow() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            System.out.println(" Step 1: Opening Swiggy...");
            driver.get("https://www.swiggy.com/restaurants");
            wait.until(ExpectedConditions.titleContains("Swiggy"));
            System.out.println(" Swiggy Page Title: " + driver.getTitle());
            Thread.sleep(2000);

            String swiggyWindow = driver.getWindowHandle();

            System.out.println(" Step 2: Opening Zomato in new tab...");
            ((JavascriptExecutor) driver).executeScript("window.open('https://www.zomato.com/', '_blank');");
            Thread.sleep(2000);

            String zomatoWindow = switchToNewTab(driver, Set.of(swiggyWindow));
            wait.until(ExpectedConditions.titleContains("Zomato"));
            System.out.println(" Zomato Page Title: " + driver.getTitle());
            Thread.sleep(2000);

            System.out.println(" Step 3: Searching and clicking District and Hyperpure links...");
            List<WebElement> links = driver.findElements(By.tagName("a"));
            String districtWindow = null, hyperpureWindow = null;

            for (WebElement link : links) {
                String href = link.getAttribute("href");
                if (href != null && href.contains("district.in") && districtWindow == null) {
                    System.out.println(" Found District URL: " + href);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
                    Thread.sleep(1000);
                    districtWindow = waitForNewTabAndReturnHandle(driver, Set.of(swiggyWindow, zomatoWindow));
                } else if (href != null && href.contains("hyperpure.com") && hyperpureWindow == null) {
                    System.out.println(" Found Hyperpure URL: " + href);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
                    Thread.sleep(1000);
                    hyperpureWindow = waitForNewTabAndReturnHandle(driver, Set.of(swiggyWindow, zomatoWindow, districtWindow));
                }
                if (districtWindow != null && hyperpureWindow != null) break;
            }

            System.out.println(" Step 4: Verifying each opened tab...");

            if (districtWindow != null) {
                driver.switchTo().window(districtWindow);
                System.out.println(" Waiting for District to load...");
                wait.until(ExpectedConditions.titleContains("District by Zomato"));
                System.out.println(" District Loaded — Title: " + driver.getTitle());
                Thread.sleep(2000);
            }

            if (hyperpureWindow != null) {
                driver.switchTo().window(hyperpureWindow);
                System.out.println(" Waiting for Hyperpure to load...");
                wait.until(ExpectedConditions.titleContains("Wholesale Suppliers"));
                System.out.println(" Hyperpure Loaded — Title: " + driver.getTitle());
                Thread.sleep(2000);
            }

            System.out.println(" Step 5: Closing tabs in reverse order...");

            if (hyperpureWindow != null) {
                driver.switchTo().window(hyperpureWindow);
                System.out.println(" Closing Hyperpure tab...");
                driver.close();
                Thread.sleep(1000);
            }

            if (districtWindow != null) {
                driver.switchTo().window(districtWindow);
                System.out.println(" Closing District tab...");
                driver.close();
                Thread.sleep(1000);
            }

            if (zomatoWindow != null) {
                driver.switchTo().window(zomatoWindow);
                System.out.println(" Closing Zomato tab...");
                driver.close();
                Thread.sleep(1000);
            }

            driver.switchTo().window(swiggyWindow);
            System.out.println(" Closing Swiggy (Parent) tab...");
            driver.close();

            System.out.println(" Test completed successfully.");

        } catch (Exception e) {
            System.err.println(" Unexpected error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static String waitForNewTabAndReturnHandle(WebDriver driver, Set<String> oldHandles) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getWindowHandles().size() > oldHandles.size());

        Set<String> currentHandles = driver.getWindowHandles();
        currentHandles.removeAll(oldHandles);
        return currentHandles.iterator().next();
    }

    public static String switchToNewTab(WebDriver driver, Set<String> oldHandles) throws InterruptedException {
        String newHandle = waitForNewTabAndReturnHandle(driver, oldHandles);
        driver.switchTo().window(newHandle);
        return newHandle;
    }
}
