package mwinteringham.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mwinteringham.helpers.WebDriverHelpers;
import mwinteringham.pageobjects.AdminLoginPage;
import mwinteringham.pageobjects.DashboardPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AdminPanelSteps {
    public WebDriver driver;
    public AdminLoginPage adminLoginPage;
    public DashboardPage dashboardPage;
    public static int noOfEntriesExists;

    public AdminPanelSteps() {
        driver = Hooks.driver;
    }

    @Given("^admin logged into the admin panel$")
    public void adminLoggedIntoTheAdminPanel() {
        WebDriverHelpers.openAdminPanel(driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.login();
        Assert.assertTrue(adminLoginPage.isUserLogged());
        dashboardPage = new DashboardPage(driver);
        noOfEntriesExists = dashboardPage.getNoOfEntriesExists();

    }

    @When("^admin creates (\\d+) hotel$")
    public void createHotel(int number) {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.createHotel(number);
    }

    @Then("^admin should see (\\d+) entries created successfully$")
    public void verifyCreatedEntry(int number) {
        int totalCurrentEntries = noOfEntriesExists + number;
        WebDriverHelpers.waitForSecs(5);
        System.out.println(dashboardPage.entries.size());
        Assert.assertTrue(dashboardPage.entries.size() == totalCurrentEntries);
    }

    @When("^I delete an entry$")
    public void deleteEntry() {
        dashboardPage.deleteEntry();
    }

    @Then("^an entry should be deleted successfully$")
    public void verifyEntryIsDeleted() {
        int totalCurrentEntries = noOfEntriesExists - 1;
        dashboardPage.verifyEntries(totalCurrentEntries);
    }

}