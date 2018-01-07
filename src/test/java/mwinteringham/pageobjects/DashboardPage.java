package mwinteringham.pageobjects;

import mwinteringham.helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DashboardPage extends BaseClass {
    @FindBy(how= How.CSS, using="#hotelName")
    public static WebElement hotelField;

    @FindBy(how= How.CSS, using="#address")
    public static WebElement addressField;

    @FindBy(how= How.CSS, using="#owner")
    public static WebElement ownerNameField;

    @FindBy(how= How.CSS, using="#phone")
    public static WebElement phoneNumberField;

    @FindBy(how= How.CSS, using="#email")
    public static WebElement userEmailField;

    @FindBy(how= How.CSS, using="#createHotel")
    public static WebElement createHotelButton;

    @FindBy(how= How.CSS, using="body > div > div.row.detail")
    public static List<WebElement> entries;


    @FindBy(how= How.CSS, using=".glyphicon-remove.hotelDelete")
    public static WebElement deleteHotelButton;

    // Test Data
    String hotel_name = "TestHotel";
    String address = "TestAddress";
    String owner_name = "TestOwner";
    String phone_number = "234324324";
    String email = "test@testmail.com";


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void createHotel(int number) {
    for (int i=1;i<=number;i++) {
        WebDriverHelpers.waitForSecs(5);
    hotelField.sendKeys(hotel_name);
    addressField.sendKeys(address);
    ownerNameField.sendKeys(owner_name);
    phoneNumberField.sendKeys(phone_number);
    userEmailField.sendKeys(email);
    createHotelButton.click();
    }
    }

    public void verifyEntries(int number) {
        Assert.assertTrue(entries.size() == number);
    }

    public int getNoOfEntriesExists() {
        WebDriverHelpers.waitForSecs(5);
        System.out.println("getEntries: "+entries.size());
        return entries.size();
    }

    public void deleteEntry() {
        deleteHotelButton.click();
    }
}
