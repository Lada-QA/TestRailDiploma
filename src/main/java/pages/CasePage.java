package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasePage extends BasePage {

    public CasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='title']")
    public WebElement setTitle;

    @FindBy(xpath = "//*[@id='accept']")
    public WebElement clickAddTestCaseButton;

    public SuitePage addNewTestCase(String testName) {
        setTitle.sendKeys(testName);
        clickAddTestCaseButton.click();
        return new SuitePage(driver);
    }
}
