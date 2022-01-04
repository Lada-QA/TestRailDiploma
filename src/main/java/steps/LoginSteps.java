package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;
import utils.PropertyReader;
import webdriver.Driver;

@Log4j2
public class LoginSteps {
    private BasePage basePage;
    private LoginPage loginPage;
    WebDriver driver;

    @Before
    public void initProjectsPage() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("User opens TestRail base page")
    public void openPage() {
        loginPage.openPage();
    }


    @When("Filling fields with email and password")
    public void fillingFieldsWithEmailAndPassword() {
        loginPage.fillingFieldsForLogin(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
    }

    @Then("Click login button")
    public void gettingToTheMainPageOfTheSite() {
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getUrl(), "https://lada29.testrail.io/index.php?/dashboard");
    }
}
