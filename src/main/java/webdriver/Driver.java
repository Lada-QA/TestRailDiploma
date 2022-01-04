package webdriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Data
public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before(order = 1)
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public static void closeBrowser() {
        driver.quit();
    }
}
