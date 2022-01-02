package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.PropertyReader;

@Log4j2
public class LoginSteps {
    public static final String BASE_URL = "https://lada29.testrail.io/index.php?/auth/login";
    private LoginPage loginPage;
    WebDriver driver;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("Open site TestRail")
    public void openSiteTestRail() {
        loginPage = new LoginPage(driver);
        log.info("Open url: " + BASE_URL);
        driver.get(BASE_URL);
    }

    @When("Filling fields with email and password")
    public void fillingFieldsWithEmailAndPassword() {
        loginPage.fillingFieldForLogin(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
    }

    @Then("Click login button and getting to the main page of the site")
    public void gettingToTheMainPageOfTheSite() {
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getUrl(), "https://lada29.testrail.io/index.php?/dashboard");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
