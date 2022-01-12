package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HeaderPage;
import pages.RunsPage;
import webdriver.Driver;


public class RunsPageSteps {
    private BasePage basePage;
    private HeaderPage headerPage;
    private RunsPage runsPage;
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        headerPage = new HeaderPage(driver);
        runsPage = new RunsPage(driver);
    }

    @And("goes to the project and add new test run")
    public void goesToTheProjectAndAddNewTestRun() {
        headerPage.clickTestSuiteLinkForProject();
        runsPage.addNewRunTestForProject();
    }

    @Then("Verify test run was added")
    public void verifyTestRunWasAdded() {
        Assert.assertEquals(runsPage.getMessageSuccess(), "Successfully added the new test run.");
    }
}