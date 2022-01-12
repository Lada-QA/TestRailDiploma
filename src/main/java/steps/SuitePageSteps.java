package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.CasePage;
import pages.HeaderPage;
import pages.SuitePage;
import webdriver.Driver;


public class SuitePageSteps {
    private BasePage basePage;
    private SuitePage suitePage;
    private HeaderPage headerPage;
    private CasePage casePage;
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        suitePage = new SuitePage(driver);
        headerPage = new HeaderPage(driver);
        casePage = new CasePage(driver);
    }


    @When("User add section {string} and description {string} in project - This is a test project API")
    public void userAddSectionThisIsASectionInProjectThisIsATestProjectAPI(String sectionName, String sectionDescription) {
        headerPage.clickTestSuiteLinkForProject()
                .clickOnTheTestSuite()
                .clickAddSection(sectionName, sectionDescription);
    }

    @Then("Verify section was added")
    public void verifySectionWasAdded() {
        Assert.assertTrue(suitePage.sectionIsDisplayed());
    }

    @And("add test case {string}")
    public void addTestCaseThisIsATestCase(String testCaseTitle) {
        headerPage.clickTestSuiteLinkForProject()
                .clickOnTheTestSuite()
                .clickTestCase()
                .addNewTestCase(testCaseTitle);
    }

    @Then("Verify test case was added")
    public void verifyTestCaseWasAdded() {
        Assert.assertEquals(suitePage.testCaseIsDisplayed(), "Successfully added the new test case. Add another");
    }
}