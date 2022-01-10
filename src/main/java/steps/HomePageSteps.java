package steps;

import adapters.ProjectsAdapter;
import com.google.gson.Gson;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import objects.Project;
import objects.Suite;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HeaderPage;
import pages.LoginPage;
import webdriver.Driver;

import static constants.Constants.DASHBOARD_URL;

public class HomePageSteps {
    private LoginPage loginPage;
    private BasePage basePage;
    private HeaderPage homePage;
    WebDriver driver;
    int projectId = 65;
    int suiteId = 2;

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

    @Given("User set POST a new project {string} and announcement {string} using API")
    public void userSetPostNewProjectUsingAPI(String nameProject, String nameAnnouncement) {
        Project project = Project.builder()
                .id(projectId)
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().createNewProject(project);
    }

    @Then("Verify project is created successfully via API")
    public void verifyProjectIsCreatedSuccessfully() {
        String body = new ProjectsAdapter().getProject(projectId);
        Project project = new Gson().fromJson(body, Project.class);
        String nameProjectFromApi = project.getName();
        String announcementFromApi = project.getAnnouncement();
        Assert.assertEquals(project.getName(), nameProjectFromApi);
        Assert.assertEquals(project.getAnnouncement(), announcementFromApi);
    }

    @Given("User set POST request for updating the project {string} with changed announcement {string} using API")
    public void userSetPostRequestForUpdatingTheProject(String nameProject, String nameAnnouncement) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().updateProject(project, projectId);
    }

    @Given("User set POST request for add new suite {string} with description {string} in the project using API")
    public void userSetPostRequestForAddNewSuiteInTheProject(String nameSuite, String descriptionSuite) {
        Suite suite = Suite.builder()
                .name(nameSuite)
                .description(descriptionSuite)
                .build();
        new ProjectsAdapter().createSuite(suite, projectId);
    }

    @Then("Verify suite is created successfully via API")
    public void verifySuiteIsCreatedSuccessfully() {
        String body = new ProjectsAdapter().getSuite(suiteId);
        Suite suite = new Gson().fromJson(body, Suite.class);
        String nameSuiteFromAPI = suite.getName();
        String descriptionFromAPI = suite.getDescription();
        Assert.assertEquals(suite.getName(), nameSuiteFromAPI);
        Assert.assertEquals(suite.getDescription(), descriptionFromAPI);
    }
}
