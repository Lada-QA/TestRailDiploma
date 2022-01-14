package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RunsPage extends BasePage {

    public RunsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[@id ='choose_suite_id']/*")
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
        runsNavigation.click();
        clickAddTestRunButton.click();
        setSuite.click();
        clickButtonOk.click();
        dropDownActiveMilestone.click();
        setActiveMilestone.click();
        dropDownAssigned.click();
        setAssigned.click();
        clickSafeAddTestRun.click();
        return this;
    }

    public String getSuccessMessage() {
        return  getMessage.getText();
    }
}