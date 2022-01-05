package adapters;


import io.restassured.response.ResponseBody;
import objects.Project;

public class ProjectsAdapter extends BaseAdapters {


    public ResponseBody createNewProject(Project project) {
        return
                post(PROJECT_API, this.converter.toJson(project)).body();
    }
}