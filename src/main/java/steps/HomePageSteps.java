package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import webdriver.Driver;

public class HomePageSteps {
    private LoginPage loginPage;
    private BasePage basePage;
    private HomePage homePage;
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Then("Verify Home page is opened")
    public void verifyHomePageIsOpened() {
        Assert.assertEquals(loginPage.getUrl(), "https://lada29.testrail.io/index.php?/dashboard");
    }

    @And("the user successfully logs out of the system")
    public void theUserSuccessfullyLogsOutOfTheSystem() {
        homePage.clickLogoutButton();
    }
}
