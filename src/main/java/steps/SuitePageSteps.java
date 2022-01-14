package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class SuitePageSteps extends AbstractSteps {

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