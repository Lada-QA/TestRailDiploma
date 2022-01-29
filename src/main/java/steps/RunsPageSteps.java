package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class RunsPageSteps extends AbstractSteps {

    @Then("goes to the project and add new test run")
    public void goesToTheProjectAndAddNewTestRun() {
        runsPage.addNewRunTestForProject();
    }

    @And("Verify test run was added")
    public void verifyTestRunWasAdded() {
        Assert.assertEquals(runsPage.getSuccessMessage(), "Successfully added the new test run.");
    }

    @And("goes to the runs page and add the test result")
    public void goesToTheRunsPageAndAddTheTestResult() {
        runsPage.addTestResult("This test is passed");
    }

    @Then("Verify test result was added")
    public void verifyTestResultWasAdded() {
        Assert.assertTrue(runsPage.isTestResultAdded());
    }
}