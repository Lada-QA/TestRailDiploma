package adapters;


import io.restassured.response.ResponseBody;
import objects.Project;

public class ProjectsAdapter extends BaseAdapter {


    public ResponseBody createNewProject(Project project) {
        return
                post(ADD_PROJECT_API, this.converter.toJson(project)).body();
    }

    public String getProject() {
        return this.get(GET_PROJECT_API).asString();
    }

    public ResponseBody updateProject(Project project) {
        return post(UPDATE_PROJECT_API, this.converter.toJson(project)).body();
    }
}