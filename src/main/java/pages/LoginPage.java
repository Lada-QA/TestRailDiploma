package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='name']")
    private WebElement inputFieldEmail;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputFieldPassword;

    @FindBy(xpath = "//*[@id='button_primary']")
    private WebElement clickLoginButton;

public void fillingFieldForLogin(String email, String password){
    inputFieldEmail.sendKeys(email);
    inputFieldPassword.sendKeys(password);
}
public void clickLogInButton(){
    clickLoginButton.click();
}
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
