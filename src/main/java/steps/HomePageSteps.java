package steps;

import adapters.ProjectsAdapter;
import adapters.SuitesAdapter;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import objects.Project;
import objects.Suite;
import org.testng.Assert;

import static constants.Constants.*;

public class HomePageSteps extends AbstractSteps {

    public static int ID_NEW_PROJECT_FROM_API;
    public static int ID_PROJECT_FROM_API;
    public static int ID_SUITE_FROM_API;

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
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        ID_NEW_PROJECT_FROM_API = new ProjectsAdapter().createNewProject(project);
    }

    @Then("Verify project is created successfully via API")
    public void verifyProjectIsCreatedSuccessfully() {
        String body = new ProjectsAdapter().getProject(ID_NEW_PROJECT_FROM_API);
        Project project = new Gson().fromJson(body, Project.class);
        String nameProjectFromApi = project.getName();
        String announcementFromApi = project.getAnnouncement();
        Assert.assertEquals(project.getName(), nameProjectFromApi);
        Assert.assertEquals(project.getAnnouncement(), announcementFromApi);
    }

    @And("User send POST request for updating the project {string} with changed announcement {string} using API")
    public void userSetPostRequestForUpdatingTheProject(String nameProject, String nameAnnouncement) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        new ProjectsAdapter().updateProject(project, ID_NEW_PROJECT_FROM_API);
    }

    @And("User send POST request for add new suite {string} with description {string} in the project using API")
    public void userSetPostRequestForAddNewSuiteInTheProject(String nameSuite, String descriptionSuite) {
        Suite suite = Suite.builder()
                .name(nameSuite)
                .description(descriptionSuite)
                .build();
        ID_SUITE_FROM_API = new SuitesAdapter().createSuite(suite, ID_NEW_PROJECT_FROM_API);
    }

    @Then("Verify suite is created successfully via API")
    public void verifySuiteIsCreatedSuccessfully() {
        String body = new SuitesAdapter().getSuite(ID_SUITE_FROM_API);
        Suite suite = new Gson().fromJson(body, Suite.class);
        String nameSuiteFromAPI = suite.getName();
        String descriptionFromAPI = suite.getDescription();
        Assert.assertEquals(suite.getName(), nameSuiteFromAPI);
        Assert.assertEquals(suite.getDescription(), descriptionFromAPI);
    }

    @Given("User send POST to create a new project {string} using API")
    public void userSendPostCreateNewProjectUsingAPI(String nameProject) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement("name announcement")
                .build();
        ID_PROJECT_FROM_API = new ProjectsAdapter().createNewProject(project);
    }

    @Then("User send POST request for delete the project {string}")
    public void userSendPostRequestForDeleteTheProject(String nameProject) {
        ProjectsAdapter projectsAdapter = new ProjectsAdapter();
        Project project = Project.builder()
                .name(nameProject)
                .build();
        projectsAdapter.deleteProject(project, ID_PROJECT_FROM_API);
    }

    @And("Verify project is delete successfully via API")
    public void verifyProjectIsDeleteSuccessfullyViaAPI() {
        int code = new ProjectsAdapter().getStatusCode(ID_PROJECT_FROM_API);
        Assert.assertEquals(code, 401);
    }
}
