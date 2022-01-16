package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static steps.HomePageSteps.ID_NEW_PROJECT_FROM_API;

public class MilestonePageSteps extends AbstractSteps {

    @And("goes to the project and add new milestone {string}")
    public void goesToTheProjectAndAddNewMilestone(String nameMilestone) {
        headerPage.clickTestSuiteLinkForProject(ID_NEW_PROJECT_FROM_API);
        milestonePage.addNewMilestoneForProject(nameMilestone, "This is references", "This is description");
    }

    @Then("Verify milestone was added")
    public void verifyMilestoneWasAdded() {
        Assert.assertEquals(milestonePage.getSuccessMessage(), "Successfully added the new milestone.");
    }
}