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
import org.testng.annotations.Test;

import static constants.Constants.*;

public class HomePageSteps extends AbstractSteps {

    int idNewProjectAPI;
    int idProjectFromApi;
    int idSuiteFromApi;

    @Test(testName = "Verify page", description = "Verify Home page is opened")
    @Then("Verify Home page is opened")
    public void verifyHomePageIsOpened() {
        Assert.assertEquals(loginPage.getUrl(), DASHBOARD_URL);
    }

    @Test(testName = "Logout", description = "Logout of the system")
    @And("the user successfully logs out of the system")
    public void theUserSuccessfullyLogsOutOfTheSystem() {
        headerPage.clickLogoutButton();
    }

    @Test(testName = "Created new project", description = "Send POST request for created new project via API")
    @Given("User send POST a new project {string} and announcement {string} using API")
    public void userSetPostNewProjectUsingAPI(String nameProject, String nameAnnouncement) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement(nameAnnouncement)
                .showAnnouncement(true)
                .build();
        idNewProjectAPI = new ProjectsAdapter().createNewProject(project);
    }

    @Test(testName = "Verify project", description = "Verify that project was created via API")
    @Then("Verify project is created successfully via API")
    public void verifyProjectIsCreatedSuccessfully() {
        String body = new ProjectsAdapter().getProject(idNewProjectAPI);
        Project project = new Gson().fromJson(body, Project.class);
        String nameProjectFromApi = project.getName();
        String announcementFromApi = project.getAnnouncement();
        Assert.assertEquals(project.getName(), nameProjectFromApi);
        Assert.assertEquals(project.getAnnouncement(), announcementFromApi);
    }

    @Test(testName = "Update the project", description = "Send POST request for updating the created project")
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
        idSuiteFromApi = new SuitesAdapter().createSuite(suite, PROJECT_ID);
    }

    @Then("Verify suite is created successfully via API")
    public void verifySuiteIsCreatedSuccessfully() {
        String body = new SuitesAdapter().getSuite(idSuiteFromApi);
        Suite suite = new Gson().fromJson(body, Suite.class);
        String nameSuiteFromAPI = suite.getName();
        String descriptionFromAPI = suite.getDescription();
        Assert.assertEquals(suite.getName(), nameSuiteFromAPI);
        Assert.assertEquals(suite.getDescription(), descriptionFromAPI);
    }

    @Given("User send POST a new project {string} using API")
    public void userSendPostCreateNewProjectUsingAPI(String nameProject) {
        Project project = Project.builder()
                .name(nameProject)
                .announcement("name announcement")
                .build();
        idProjectFromApi = new ProjectsAdapter().createNewProject(project);
    }

    @Then("User send POST request for delete the project {string}")
    public void userSendPostRequestForDeleteTheProject(String nameProject) {
        ProjectsAdapter projectsAdapter = new ProjectsAdapter();
        Project project = Project.builder()
                .name(nameProject)
                .announcement("name announcement")
                .build();
        projectsAdapter.deleteProject(project, idProjectFromApi);
    }

    @And("Verify project is delete successfully via API")
    public void verifyProjectIsDeleteSuccessfullyViaAPI() {
        int code = new ProjectsAdapter().getStatusCode(idProjectFromApi);
        Assert.assertEquals(code, 401);
    }
}
