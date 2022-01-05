package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HeaderPage;
import pages.LoginPage;
import webdriver.Driver;

import static constants.Constants.DASHBOARD_URL;

public class HomePageSteps {
    private LoginPage loginPage;
    private BasePage basePage;
    private HeaderPage homePage;
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HeaderPage(driver);
    }

    @Then("Verify Home page is opened")
    public void verifyHomePageIsOpened() {
        Assert.assertEquals(loginPage.getUrl(), DASHBOARD_URL);
    }

    @And("the user successfully logs out of the system")
    public void theUserSuccessfullyLogsOutOfTheSystem() {
        homePage.clickLogoutButton();
    }
}
