package adapters;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import objects.Project;

public class ProjectsAdapter extends BaseAdapter {


    public int createNewProject(Project project) {
        return
                post(ADD_PROJECT_API, this.converter.toJson(project)).body().path("id");
    }

    public String getProject(int projectId) {
        return this.get(String.format(GET_PROJECT_API, projectId)).body().asString();
    }

    public Response updateProject(Project project, int projectId) {
        return post(String.format(UPDATE_PROJECT_API, projectId), this.converter.toJson(project)).body().path("id");
    }

    public int deleteProject(Project project, int projectId) {
        return post(String.format(DELETE_PROJECT_API, projectId), this.converter.toJson(project)).getStatusCode();
    }

    public int getStatusCode(int projectID) {
        return RestAssured.get(String.format(GET_PROJECT_API, projectID)).getStatusCode();
    }
}