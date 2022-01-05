package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        inputFieldEmail.sendKeys(email);
        inputFieldPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        clickLoginButton.click();
    }

    public void fillingFieldsForLoginWithInvalidData(String email, String password) {
        inputFieldEmail.sendKeys(email);
        inputFieldPassword.sendKeys(password);
    }

    public String getErrorMessage() {
        return getErrorText.getText();
    }
}
