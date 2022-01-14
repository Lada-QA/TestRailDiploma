package steps;

import adapters.ProjectsAdapter;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import objects.Project;
import objects.Suite;
import org.testng.Assert;

import static constants.APIConstants.DELETE_PROJECT_ID;
import static constants.Constants.*;

public class HomePageSteps extends AbstractSteps {

    @Then("Verify Home page is opened")
    public void verifyHomePageIsOpened() {
        Assert.assertEquals(loginPage.getUrl(), DASHBOARD_URL);
    }

    @And("the user successfully logs out of the system")
    public void theUserSuccessfullyLogsOutOfTheSystem() {
        headerPage.clickLogoutButton();
    }

    @Given("User send POST a new project {string} and announcement {string} using API")
    public void userSetPostNewProjectUsingAPI(String nameProject, String nameAnnouncement) {
        Project project = Project.builder()
                .id(PROJECT_ID)
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().createNewProject(project);
    }

    @Then("Verify project is created successfully via API")
    public void verifyProjectIsCreatedSuccessfully() {
        String body = new ProjectsAdapter().getProject(PROJECT_ID);
        Project project = new Gson().fromJson(body, Project.class);
        String nameProjectFromApi = project.getName();
        String announcementFromApi = project.getAnnouncement();
        Assert.assertEquals(project.getName(), nameProjectFromApi);
        Assert.assertEquals(project.getAnnouncement(), announcementFromApi);
    }

    @Given("User send POST request for updating the project {string} with changed announcement {string} using API")
    public void userSetPostRequestForUpdatingTheProject(String nameProject, String nameAnnouncement) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().updateProject(project, PROJECT_ID);
    }

    @Given("User send POST request for add new suite {string} with description {string} in the project using API")
    public void userSetPostRequestForAddNewSuiteInTheProject(String nameSuite, String descriptionSuite) {
        Suite suite = Suite.builder()
                .name(nameSuite)
                .description(descriptionSuite)
                .build();
        new ProjectsAdapter().createSuite(suite, PROJECT_ID);
    }

    @Then("Verify suite is created successfully via API")
    public void verifySuiteIsCreatedSuccessfully() {
        String body = new ProjectsAdapter().getSuite(SUITE_ID);
        Suite suite = new Gson().fromJson(body, Suite.class);
        String nameSuiteFromAPI = suite.getName();
        String descriptionFromAPI = suite.getDescription();
        Assert.assertEquals(suite.getName(), nameSuiteFromAPI);
        Assert.assertEquals(suite.getDescription(), descriptionFromAPI);
    }

    @Given("User send POST a new project {string} using API")
    public void userSendPostCreateNewProjectUsingAPI(String nameProject) {
        Project project = Project.builder()
                .id(DELETE_PROJECT_ID)
                .name(nameProject)
                .announcement("name announcement")
                .build();
        new ProjectsAdapter().createNewProject(project);
    }

    @Then("User send POST request for delete the project {string}")
    public void userSendPostRequestForDeleteTheProject(String nameProject) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement("name announcement")
                .build();
        new ProjectsAdapter().deleteProject(project, DELETE_PROJECT_ID);
    }

    @And("Verify project is delete successfully via API")
    public void verifyProjectIsDeleteSuccessfullyViaAPI() {
        int code = new ProjectsAdapter().getStatusCode(DELETE_PROJECT_ID);
        Assert.assertEquals(code, 401);
    }
}
