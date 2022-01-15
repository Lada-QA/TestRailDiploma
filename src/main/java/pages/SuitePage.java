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

    public static final String ADD_TEST_SUITE = "//*[@id='suite-%s']//*[@href='index.php?/suites/view/%s']";

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

    @FindBy(id = "addCase")
    public WebElement clickAddTestCase;

    @FindBy(xpath = "//*[@class='message message-success']")
    public WebElement getMessageSuccess;


    public SuitePage clickOnTheTestSuite() {
        log.info("Click on the desired search test suite via id");
        driver.findElement(By.xpath(String.format(ADD_TEST_SUITE, SUITE_ID, SUITE_ID))).click();
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
        waitForElementLocated(driver, sectionText, 3);
        return sectionText.isDisplayed();
    }

    public String testCaseIsDisplayed() {
        return getMessageSuccess.getText();
    }

    public CasePage clickTestCase() {
        clickAddTestCase.click();
        return new CasePage(driver);
    }
}