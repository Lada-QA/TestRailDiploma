package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webdriver.Driver;

public class MilestonePageSteps extends AbstractSteps {
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
    }

    @And("goes to the project and add new milestone {string}")
    public void goesToTheProjectAndAddNewMilestone(String nameMilestone) {
        headerPage.clickTestSuiteLinkForProject();
        milestonePage.addNewMilestoneForProject(nameMilestone, "This is references", "This is description");
    }

    @Then("Verify milestone was added")
    public void verifyMilestoneWasAdded() {
        Assert.assertEquals(milestonePage.getSuccessMessage(), "Successfully added the new milestone.");
    }
}