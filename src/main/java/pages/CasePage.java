package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;
import static utils.Waiters.waitForPageLoaded;

@Log4j2
public class CasePage extends BasePage {

    public CasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='title']")
    public WebElement setTitle;

    @FindBy(xpath = "//*[@id='accept']")
    public WebElement clickAddTestCaseButton;

    public SuitePage addNewTestCase(String testName) {
        waitForPageLoaded();
        log.info("Entering the name of the test case: " + testName);
        setTitle.sendKeys(testName);
        waitForElementLocated(driver, clickAddTestCaseButton, 10);
        log.info("Click button - Add Case");
        clickAddTestCaseButton.click();
        return new SuitePage(driver);
    }
}
