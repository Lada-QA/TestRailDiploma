package steps;

import adapters.ProjectsAdapter;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.Project;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HeaderPage;
import pages.LoginPage;
import webdriver.Driver;

import static constants.Constants.DASHBOARD_URL;
import static constants.Constants.PROJECT_ID;

public class HomePageSteps {
    private LoginPage loginPage;
    private BasePage basePage;
    private HeaderPage homePage;
    WebDriver driver;

    @Before
    public void initPages() {
        driver = Driver.getDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HeaderPage(driver);
    }

    @Then("Verify Home page is opened")
    public void verifyHomePageIsOpened() {
        Assert.assertEquals(loginPage.getUrl(), DASHBOARD_URL);
    }

    @And("the user successfully logs out of the system")
    public void theUserSuccessfullyLogsOutOfTheSystem() {
        homePage.clickLogoutButton();
    }

    @Given("User set POST a new project using API")
    public void userSetPOSTANewProjectUsingAPI() {
        Project project = Project.builder()
                .name("This is a test project")
                .announcement("This is test project for API")
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().createNewProject(project);
    }

    @Then("User receive valid Response")
    public void userReceiveValidResponse() {
        new ProjectsAdapter()
                .get("/25");
        Assert.assertEquals(ProjectsAdapter.PROJECT_ID, PROJECT_ID);
    }
}
