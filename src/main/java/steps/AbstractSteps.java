package steps;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.*;
import webdriver.Driver;

abstract class AbstractSteps {
    BasePage basePage;
    CasePage casePage;
    HeaderPage headerPage;
    LoginPage loginPage;
    MilestonePage milestonePage;
    RunsPage runsPage;
    SuitePage suitePage;
    WebDriver driver;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        casePage = new CasePage(driver);
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
        milestonePage = new MilestonePage(driver);
        runsPage = new RunsPage(driver);
        suitePage = new SuitePage(driver);
        headerPage = new HeaderPage(driver);
    }
}