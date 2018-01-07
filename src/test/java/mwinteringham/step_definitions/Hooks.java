package mwinteringham.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import mwinteringham.helpers.WebDriverHelpers;
import mwinteringham.pageobjects.DashboardPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;

import static mwinteringham.helpers.BrowserFactory.getDriver;

public class Hooks{
    public static WebDriver driver;

    @Before
    /**
     * Delete webdriver.chrome.driverall cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	driver = getDriver();

    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    }

     
    @After
    public void closeBrowser() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        for (int i=1; i<AdminPanelSteps.noOfEntsriesExists;i++) {
            WebDriverHelpers.waitForSecs(5);
            dashboardPage.deleteEntry();
        }
        driver.quit();
        
    }
    
}