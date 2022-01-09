package constants;

import static constants.Constants.BASE_URL;

public interface APIConstants {
    String APPLICATION_JSON_VALUE = "application/json";
    String CONTENT_TYPE_VALUE = "Content-Type";
    String ADD_PROJECT_API = BASE_URL + "/api/v2/add_project";
    String GET_PROJECT_API = BASE_URL + "/api/v2/get_project/56";
    String UPDATE_PROJECT_API = BASE_URL + "/api/v2/update_project/56";
}
