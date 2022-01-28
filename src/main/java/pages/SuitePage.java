package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;

@Log4j2
public class SuitePage extends BasePage {

    public SuitePage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_TEST_SUITE = "//*[@href='index.php?/suites/view/%s']";
    public static final String ADD_TEST_CASE = "//*[@class='button-group']//*[@href='index.php?/cases/add/%s']";

    @FindBy(xpath = "//*[@id='addSectionInline']")
    public WebElement clickSectionLine;

    @FindBy(xpath = "//*[@id='editSectionName']")
    public WebElement setSectionName;

    @FindBy(xpath = "//*[@id='editSectionDescription_display']")
    public WebElement setSectionDescription;

    @FindBy(xpath = "//*[@id='editSectionSubmit']")
    public WebElement clickAddSection;

    @FindBy(xpath = "//*[text()='This is a section test']")
    public WebElement sectionText;

    @FindBy(xpath = "//div[contains(@class,'grid-actions')]//a[contains(text(),'ase')] ")
    public WebElement caseInSection;

    @FindBy(xpath = "//*[@class='icon-button-accept']")
    public WebElement submitSave;

    @FindBy(xpath = "//*[contains(@class, 'addForm')]/*[contains(@class,'form-control')]")
    public WebElement inputCaseTitle;

    @FindBy(xpath = "//*[@class='message message-success']")
    public WebElement getMessageSuccess;


    public SuitePage clickOnTheTestSuite(int idSuite) {
        log.info("Click on the desired search test suite via id");
        driver.findElement(By.xpath(String.format(ADD_TEST_SUITE, idSuite))).click();
        return this;
    }

    public SuitePage clickAddSection(String sectionName, String sectionDescription) {
        clickSectionLine.click();
        log.info("Entering name for section test suite: " + sectionName);
        setSectionName.sendKeys(sectionName);
        log.info("Entering description for section test suite: " + sectionDescription);
        setSectionDescription.sendKeys(sectionDescription);
        clickAddSection.click();
        return this;
    }

    public boolean sectionIsDisplayed() {
        waitForElementLocated(driver, sectionText, 10);
        return sectionText.isDisplayed();
    }

    public String testCaseIsDisplayed() {
        return getMessageSuccess.getText();
    }

    public CasePage clickTestCase(int idSuite) {
        log.info("Add new test case for suite via id: " + idSuite);
        driver.findElement(By.xpath(String.format(ADD_TEST_CASE, idSuite))).click();
        return new CasePage(driver);
    }

    public SuitePage addNewTestCaseInSection(String caseName) {
        waitForElementLocated(driver, caseInSection, 3);
        caseInSection.click();
        log.info("Add new test case with name: " + caseName);
        inputCaseTitle.sendKeys(caseName);
        submitSave.click();
        return this;
    }
}