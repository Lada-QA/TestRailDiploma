package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;
import static utils.Waiters.waitForPageLoaded;

@Log4j2
public class RunsPage extends BasePage {

    public RunsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id ='choose_suite_id']/*")
    public WebElement setSuite;

    @FindBy(xpath = "//*[@id ='navigation-runs']")
    public WebElement runsNavigation;

    @FindBy(xpath = "//*[@class='button-group']/a")
    public WebElement clickAddTestRunButton;

    @FindBy(xpath = "//*[@class='chzn-single']//ancestor::*[@id='milestone_id_chzn']/*")
    public WebElement dropDownActiveMilestone;

    @FindBy(id = "milestone_id_chzn_o_2")
    public WebElement setActiveMilestone;

    @FindBy(xpath = "//*[@id = 'assignedto_id_chzn']/*")
    public WebElement dropDownAssigned;

    @FindBy(xpath = "//*[@id = 'assignedto_id_chzn']//*[text()='Me']")
    public WebElement setAssigned;

    @FindBy(xpath = "//*[contains(@class,'button-ok')]/ancestor::*[@id='chooseSuiteForm']//button")
    public WebElement clickButtonOk;

    @FindBy(xpath = "//*[@class = 'message message-success']")
    public WebElement getMessage;

    @FindBy(id = "accept")
    public WebElement clickSafeAddTestRun;

    @FindBy(xpath = "//td[@class='id']/*")
    public WebElement clickSectionTest;

    @FindBy(xpath = "//*[contains(@class,'text-secondary')]")
    public WebElement clickEditLink;

    @FindBy(xpath = "//*[@class='chzn-single']")
    public WebElement clickDropDownStatusMenu;

    @FindBy(id = "addResultStatus_chzn_o_0")
    public WebElement chooseTestStatusAndClick;

    @FindBy(id = "addResultComment_display")
    public WebElement inputComment;

    @FindBy(xpath = "//*[@id='addResultAssignTo_chzn']/*")
    public WebElement clickDropDownAssign;

    @FindBy(id = "addResultAssignTo_chzn_o_2")
    public WebElement chooseAndClickToAssign;

    @FindBy(id = "addResultSubmit")
    public WebElement clickButtonEditResult;

    @FindBy(xpath = "//*[contains(@class,'change-column-content')]")
    public WebElement textCommentIsDisplayed;

    public RunsPage addNewRunTestForProject() {
        waitForPageLoaded();
        log.info("Clicking 'Test Runs&Results' on the project navigation");
        runsNavigation.click();
        log.info("Clicking 'Add Test Run' on the Runs page");
        clickAddTestRunButton.click();
        log.info("Choosing and click the test suite from drop down menu on the modal window");
        setSuite.click();
        log.info("Clicking button 'Ok' to safe the selection");
        clickButtonOk.click();
        log.info("Clicking on the field to select active Milestone from Drop Down menu");
        dropDownActiveMilestone.click();
        log.info("Click active Milestone from Drop Down menu");
        setActiveMilestone.click();
        log.info("Clicking on the field to select assigned from Drop Down menu");
        dropDownAssigned.click();
        log.info("Choose and click assigned");
        setAssigned.click();
        log.info("Click 'AddTestRun' to save new Test Run");
        clickSafeAddTestRun.click();
        return this;
    }

    public String getSuccessMessage() {
        waitForElementLocated(driver, getMessage, 10);
        log.info("Receiving the Success message when saved the Test Run");
        return getMessage.getText();
    }

    public RunsPage addTestResult(String textComment) {
        waitForElementLocated(driver, runsNavigation, 5);
        runsNavigation.click();
        log.info("Clicking 'Add Test Run' on the Runs page");
        clickAddTestRunButton.click();
        log.info("Choosing and click the test suite from drop down menu on the modal window");
        setSuite.click();
        log.info("Clicking button 'Ok' to safe the selection");
        clickButtonOk.click();
        clickSafeAddTestRun.click();
        clickSectionTest.click();
        waitForElementLocated(driver, clickEditLink, 5);
        clickEditLink.click();
        waitForElementLocated(driver, clickDropDownStatusMenu, 5);
        clickDropDownStatusMenu.click();
        waitForElementLocated(driver, chooseTestStatusAndClick, 5);
        chooseTestStatusAndClick.click();
        log.info("Was input comment: " + textComment);
        inputComment.sendKeys(textComment);
        clickDropDownAssign.click();
        chooseAndClickToAssign.click();
        clickButtonEditResult.click();
        return this;
    }

    public boolean testResultWasAdded() {
        waitForElementLocated(driver, textCommentIsDisplayed, 5);
        return textCommentIsDisplayed.isDisplayed();
    }
}