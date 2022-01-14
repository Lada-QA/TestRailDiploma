package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class RunsPageSteps extends AbstractSteps {

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