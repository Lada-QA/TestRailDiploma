package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForPageLoaded;

@Log4j2
public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final String SUITE_TEST_LINK = "//*[@id='project-%s']//*[contains(text(),'suite')]";

    @FindBy(xpath = "//*[@id='navigation-user']/span[@class='caret']")
    public WebElement clickDropDownMenu;
    @FindBy(xpath = "//*[@id='navigation-user-logout']")
    public WebElement clickLogout;

    public void clickLogoutButton() {
        waitForPageLoaded();
        log.info("Click dropDown menu for choose the option");
        clickDropDownMenu.click();
        log.info("Click on the desired option - Log Out");
        clickLogout.click();
    }

    public SuitePage clickTestSuiteLinkForProject(int idProject) {
        log.info("Click on the link for opening project on the 'Test Suites&Cases' page via id: "+ idProject);
        driver.findElement(By.xpath(String.format(SUITE_TEST_LINK, idProject))).click();
        return new SuitePage(driver);
    }
}