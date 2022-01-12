package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HeaderPage;
import pages.MilestonePage;
import webdriver.Driver;

public class MilestonePageSteps {
    private BasePage basePage;
    private MilestonePage milestonePage;
    private HeaderPage headerPage;
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        milestonePage = new MilestonePage(driver);
        headerPage = new HeaderPage(driver);
    }

    @And("goes to the project and add new milestone {string}")
    public void goesToTheProjectAndAddNewMilestone(String nameMilestone) {
        headerPage.clickTestSuiteLinkForProject();
        milestonePage.addNewMilestoneForProject(nameMilestone, "This is references", "This is description");
    }

    @Then("Verify milestone was added")
    public void verifyMilestoneWasAdded() {
        Assert.assertEquals(milestonePage.getMessageSuccess(), "Successfully added the new milestone.");
    }
}