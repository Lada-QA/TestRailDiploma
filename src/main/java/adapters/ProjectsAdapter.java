package adapters;


import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import objects.Project;
import objects.Suite;

public class ProjectsAdapter extends BaseAdapter {


    public ResponseBody createNewProject(Project project) {
        return
                post(ADD_PROJECT_API, this.converter.toJson(project)).body();
    }

    public String getProject(int projectId) {
        return this.get(String.format(GET_PROJECT_API, projectId)).body().asString();
    }

    public ResponseBody updateProject(Project project, int projectId) {
        return post(String.format(UPDATE_PROJECT_API, projectId), this.converter.toJson(project)).body();
    }

    public ResponseBody createSuite(Suite suite, int projectId) {
        return post(String.format(ADD_SUITE_API, projectId), this.converter.toJson(suite)).body();
    }

    public String getSuite(int projectId) {
        return this.get(String.format(GET_SUITE_API, projectId)).asString();
    }

    public int deleteProject(Project project, int projectId) {
        return post(String.format(DELETE_PROJECT_API, projectId), this.converter.toJson(project)).getStatusCode();
    }

    public int getStatusCode(int projectID) {
        return RestAssured.get(String.format(GET_PROJECT_API, projectID)).getStatusCode();
    }
}