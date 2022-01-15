package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"classpath:features"},
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
        , tags = "@SmokeTest"
)
public class TestRailTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
