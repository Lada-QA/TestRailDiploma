package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public RunsPage addNewRunTestForProject() {
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
        log.info("Receiving the Success message when saved the Test Run");
        return getMessage.getText();
    }
}