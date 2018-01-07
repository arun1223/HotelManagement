package mwinteringham.pageobjects;

import mwinteringham.helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminLoginPage extends BaseClass{

    public AdminLoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how=How.CSS, using="div.container-fluid > ul > li:nth-child(2) > a")
    public static WebElement loginLink;

   @FindBy(how=How.CSS, using="a#logout")
    public static WebElement logoutLink;

    @FindBy(how=How.CSS, using="#myModal > div > div")
    public static WebElement loginOverlay;

    @FindBy(how= How.CSS, using="#username")
    public static WebElement emailField;

    @FindBy(how=How.CSS, using="#password")
    public static WebElement passwordField;

    @FindBy(css="#doLogin")
    public static WebElement loginButton;


    public void login(String username,String password)
    {
        loginLink.click();
        WebDriverHelpers.waitForSecs(10);
        Assert.assertTrue(loginOverlay.isDisplayed());
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void login()
    {
        login("admin","password");
    }

    public boolean isUserLogged() {
            return WebDriverHelpers.isElementPresent(logoutLink);
    }


}
