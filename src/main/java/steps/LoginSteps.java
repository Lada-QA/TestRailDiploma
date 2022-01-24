package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import utils.PropertyReader;

import static constants.Constants.AUTH_LOGIN;
import static utils.Waiters.waitForPageLoaded;

@Log4j2
public class LoginSteps extends AbstractSteps {

    @When("User opens TestRail login page")
    public void openLoginPage() {
        loginPage.openPage();
    }


    @And("filling in standard email and password on Login page")
    public void fillingFieldsWithEmailAndPassword() {
        loginPage.fillingFieldsForLogin(System.getenv().getOrDefault(System.getProperty("email"), PropertyReader.getProperty("email")),
                System.getenv().getOrDefault(System.getProperty("password"), PropertyReader.getProperty("password")));
    }

    @When("User clicks login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("filling in invalid email and password on Login page")
    public void fillingInNotStandardEmailAndPasswordOnLoginPage() {
        loginPage.fillingFieldsForLoginWithInvalidData(System.getenv().getOrDefault(System.getProperty("invalidEmail"), PropertyReader.getProperty("invalidEmail")),
                System.getenv().getOrDefault(System.getProperty("invalidPassword"), PropertyReader.getProperty("invalidPassword")));
    }

    @Then("User getting error text - Sorry, there was a problem.")
    public void getErrorText() {
        Assert.assertEquals(loginPage.getErrorMessage(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Then("Verify Login page is opened")
    public void verifyLoginPageIsOpened() {
        waitForPageLoaded();
        Assert.assertEquals(loginPage.getUrl(), AUTH_LOGIN);
    }
}