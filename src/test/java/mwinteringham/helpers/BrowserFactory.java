package mwinteringham.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import mwinteringham.step_definitions.RunCukesTest;

public class BrowserFactory {


    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            return createBrowserInstance();
        } else
            return driver;
    }

    private static WebDriver createBrowserInstance() {

            if (RunCukesTest.browser.equalsIgnoreCase(BrowserNames.CHROME.toString())) {
                return new ChromeDriver();
            } else if (RunCukesTest.browser.equalsIgnoreCase(BrowserNames.FIREFOX.toString())) {
                return new FirefoxDriver();
            } else {
                return new ChromeDriver();
            }
    }
}
