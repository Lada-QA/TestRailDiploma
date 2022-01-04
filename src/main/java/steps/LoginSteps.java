package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("User opens TestRail login page")
    public void openLoginPage() {
        loginPage.openPage();
    }


    @And("filling in standard email and password on Login page")
    public void fillingFieldsWithEmailAndPassword() {
        loginPage.fillingFieldsForLogin(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
    }

    @When("User clicks login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
}
