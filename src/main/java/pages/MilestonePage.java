package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        clickMilestones.click();
        clickAddMilestone.click();
        inputNameMilestone.sendKeys(nameMilestone);
        inputReferences.sendKeys(references);
        inputDescription.sendKeys(description);
        clickToSaveMilestoneButton.click();
        return this;
    }

    public String getSuccessMessage() {
        return getMessageMilestone.getText();
    }
}