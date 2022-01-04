package pages;


import constants.Constants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class BasePage implements Constants {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openURL(String url) {
        log.info("Open url: " + url);
        driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
