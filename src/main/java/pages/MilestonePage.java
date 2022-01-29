package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForPageLoaded;

@Log4j2
public class MilestonePage extends BasePage {

    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "navigation-milestones")
    public WebElement clickMilestones;

    @FindBy(xpath = "//*[@class='button-group']/*")
    public WebElement clickAddMilestone;

    @FindBy(id = "name")
    public WebElement inputNameMilestone;

    @FindBy(id = "reference")
    public WebElement inputReferences;

    @FindBy(id = "description_display")
    public WebElement inputDescription;

    @FindBy(id = "accept")
    public WebElement clickToSaveMilestoneButton;

    @FindBy(xpath = "//*[contains(@class, 'message-success')]")
    public WebElement getMessageMilestone;

    public MilestonePage addNewMilestoneForProject(String nameMilestone, String references, String description) {
        waitForPageLoaded();
        log.info("Clicking 'Milestone' on the project navigation");
        clickMilestones.click();
        log.info("Clicking 'Add Milestone' on the Milestones page");
        clickAddMilestone.click();
        log.info("Entering name for new Milestone: " + nameMilestone);
        inputNameMilestone.sendKeys(nameMilestone);
        log.info("Entering references for the Milestone: " + references);
        inputReferences.sendKeys(references);
        log.info("Entering description for the Milestone: " + description);
        inputDescription.sendKeys(description);
        log.info("Clicking 'Add Milestone' to save the Milestone");
        clickToSaveMilestoneButton.click();
        return this;
    }

    public String getSuccessMessage() {
        log.info("Receiving the Success message when saved the Milestone");
        return getMessageMilestone.getText();
    }
}