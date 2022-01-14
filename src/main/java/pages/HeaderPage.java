package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final String SUITE_TEST_LINK = "//*[@id='project-%s']//*[text()='Test Suites']";

    @FindBy(xpath = "//*[@id='navigation-user']/span[@class='caret']")
    public WebElement clickDropDownMenu;
    @FindBy(xpath = "//*[@id='navigation-user-logout']")
    public WebElement clickLogout;

    public void clickLogoutButton() {
        clickDropDownMenu.click();
        clickLogout.click();
    }

    public SuitePage clickTestSuiteLinkForProject() {
        driver.findElement(By.xpath(String.format(SUITE_TEST_LINK, PROJECT_ID))).click();
        return new SuitePage(driver);
    }
}