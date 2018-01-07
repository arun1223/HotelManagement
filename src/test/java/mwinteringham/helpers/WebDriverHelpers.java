package mwinteringham.helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelpers {

    static WebDriver driver;

    static String baseURL = "http://localhost:3003";
    private static String bodyElementText()
    {
        return driver.findElement(By.tagName("body")).getText();
    }


    public static void openAdminPanel(WebDriver driver) {
        WebDriverHelpers.driver = driver;
        driver.get(baseURL);
        Log.info("I am at admin panel page");
        Assert.assertTrue(driver.findElement(By.cssSelector(".navbar.navbar-default")).isDisplayed());
        }

    public static boolean textExists(String text) {
        return bodyElementText().contains(text);
    }

    public static void openButton(String buttonText) {
        driver.findElement(By.xpath("//button[text()='"+buttonText+"']")).click();
    }

    public static void waitForSecs(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

}
