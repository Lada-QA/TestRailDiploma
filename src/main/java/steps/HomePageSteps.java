package steps;

import adapters.ProjectsAdapter;
import com.google.gson.Gson;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import objects.Project;
import objects.ProjectList;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HeaderPage;
import pages.LoginPage;
import webdriver.Driver;

import static constants.APIConstants.GET_PROJECT_API;
import static constants.Constants.DASHBOARD_URL;

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
    public void userSetPostNewProjectUsingAPI() {
        Project project = Project.builder()
                .name("This is a test project")
                .announcement("This is test project for API")
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().createNewProject(project);
    }

    @Then("Verify project is created successfully via API")
    public void userReceiveValidResponse() {
        new ProjectsAdapter()
                .get(GET_PROJECT_API);
        String body = new ProjectsAdapter().getProject();
        ProjectList projectList = new Gson().fromJson(body, ProjectList.class);
        String nameProjectFromApi = projectList.getProjects().get(1).getName();
        String announcementFromApi = projectList.getProjects().get(1).getAnnouncement();
        Assert.assertEquals(projectList.getProjects().get(0).getName(), nameProjectFromApi);
        Assert.assertEquals(projectList.getProjects().get(0).getAnnouncement(), announcementFromApi);
    }
}
