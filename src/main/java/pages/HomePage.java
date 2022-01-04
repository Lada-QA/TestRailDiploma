package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='navigation-user']/span[@class='caret']")
    public WebElement clickDropDownMenu;
    @FindBy(xpath = "//*[@id='navigation-user-logout']")
    public WebElement clickLogout;

    public void clickLogoutButton() {
        clickDropDownMenu.click();
        clickLogout.click();
    }
}