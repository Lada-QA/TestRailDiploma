package webdriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;


@Log4j2
public class Driver {
    private Driver() {
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Before(order = 1)
    public static void setup() {
        initDriver();
    }

    public static void initDriver() {
        if (System.getProperty("browser") != null) {
            if (System.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                log.debug("Chrome browser is started!");
                driver.set(new ChromeDriver());
            } else if (System.getProperty("browser").equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            } else if (System.getProperty("browser").equals("opera")) {
                WebDriverManager.operadriver().setup();
                driver.set(new OperaDriver());
            }
        } else {
            try {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            } catch (Exception e) {
                log.fatal("FATAL ERROR: Driver is not started!");
            }
        }
        log.debug("Browser is started in fullscreen mode.");
        driver.get().manage().window().maximize();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public static void closeBrowser(Scenario scenario) {
        if (driver != null) {
            if(scenario.isFailed()) {
                takeScreenshot(driver.get());
            }
            driver.get().close();
        }
    }
}
