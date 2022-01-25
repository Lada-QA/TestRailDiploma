package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;
import static utils.Waiters.waitForPageLoaded;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='name']")
    public WebElement inputFieldEmail;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement inputFieldPassword;

    @FindBy(xpath = "//*[@id='button_primary']")
    public WebElement clickLoginButton;

    @FindBy(xpath = "//*[@class='error-text']")
    public WebElement getErrorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl(BASE_URL);
    }

    public void fillingFieldsForLogin(String email, String password) {
        waitForPageLoaded();
        log.info("Entering the email for login: " + email);
        inputFieldEmail.sendKeys(email);
        log.info("Entering the password for login: " + password);
        inputFieldPassword.sendKeys(password);

    }

    public void clickLoginButton() {
        waitForElementLocated(driver, clickLoginButton, 10);
        clickLoginButton.click();
    }

    public void fillingFieldsForLoginWithInvalidData(String email, String password) {
        waitForPageLoaded();
        log.info("Entering the invalid email: " + email);
        inputFieldEmail.sendKeys(email);
        log.info("Entering the invalid password: " + password);
        inputFieldPassword.sendKeys(password);
    }

    public String getErrorMessage() {
        waitForElementLocated(driver, getErrorText, 10);
        log.info("Receiving an error message when entering invalid data");
        return getErrorText.getText();
    }
}
