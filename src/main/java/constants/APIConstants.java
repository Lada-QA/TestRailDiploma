package constants;

import static constants.Constants.BASE_URL;

public interface APIConstants {
    String APPLICATION_JSON_VALUE = "application/json";
    String CONTENT_TYPE_VALUE = "Content-Type";
    String ADD_PROJECT_API = BASE_URL + "/api/v2/add_project";
    String GET_PROJECT_API = BASE_URL + "/api/v2/get_project/%s";
    String UPDATE_PROJECT_API = BASE_URL + "/api/v2/update_project/%s";
    String ADD_SUITE_API  = BASE_URL + "/api/v2/add_suite/%s";
    String GET_SUITE_API = BASE_URL + "/api/v2/get_suite/%s";
    String DELETE_PROJECT_API = BASE_URL + "/api/v2/delete_project/%s";
    String ADD_CASE_FIELD_API = BASE_URL + "/api/v2/add_case_field";
    String ADD_TEST_PLAN_API = BASE_URL + "/api/v2/add_plan/%s";
    String GET_TEST_PLAN_API = BASE_URL + "/api/v2/get_plan/%s";
}
