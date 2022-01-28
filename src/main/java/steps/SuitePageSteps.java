package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static steps.HomePageSteps.ID_NEW_PROJECT_FROM_API;
import static steps.HomePageSteps.ID_SUITE_FROM_API;

public class SuitePageSteps extends AbstractSteps {

    @When("User add section {string} and description {string} in project - This is a test project API")
    public void userAddSectionThisIsASectionInProjectThisIsATestProjectAPI(String sectionName, String sectionDescription) {
        headerPage.clickTestSuiteLinkForProject(ID_NEW_PROJECT_FROM_API)
                .clickOnTheTestSuite(ID_SUITE_FROM_API)
                .clickAddSection(sectionName, sectionDescription);
    }

    @Then("Verify section was added")
    public void verifySectionWasAdded() {
        Assert.assertTrue(suitePage.sectionIsDisplayed());
    }

    @And("add test case {string}")
    public void addTestCaseThisIsATestCase(String testCaseTitle) {
        headerPage.clickTestSuiteLinkForProject(ID_NEW_PROJECT_FROM_API)
                .clickOnTheTestSuite(ID_SUITE_FROM_API)
                .clickTestCase(ID_SUITE_FROM_API)
                .addNewTestCase(testCaseTitle);
    }

    @Then("Verify test case was added")
    public void verifyTestCaseWasAdded() {
        Assert.assertEquals(suitePage.testCaseIsDisplayed(), "Successfully added the new test case. Add another");
    }

    @When("User add new test case {string} in section")
    public void userAddNewTestCaseInSection(String caseName) {
        suitePage.addNewTestCaseInSection(caseName);
    }
}