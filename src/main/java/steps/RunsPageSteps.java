package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webdriver.Driver;


public class RunsPageSteps extends AbstractSteps {
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
    }

    @And("goes to the project and add new test run")
    public void goesToTheProjectAndAddNewTestRun() {
        headerPage.clickTestSuiteLinkForProject();
        runsPage.addNewRunTestForProject();
    }

    @Then("Verify test run was added")
    public void verifyTestRunWasAdded() {
        Assert.assertEquals(runsPage.getSuccessMessage(), "Successfully added the new test run.");
    }
}