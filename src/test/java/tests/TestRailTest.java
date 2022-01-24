package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import steps.TestListener;


@CucumberOptions(
        features = {"classpath:features"},
        glue = {"steps", "webdriver"},
        tags = "@SmokeTest or @Ui or @API",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber-report/cucumber.json"}
)
@Listeners(TestListener.class)
public class TestRailTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
