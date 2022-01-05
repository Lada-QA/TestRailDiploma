package adapters;

import com.google.gson.Gson;
import constants.Constants;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdapters implements Constants {

    Gson converter = new Gson();

    @Before
    public void setup() {
        final String baseUrl = BASE_URL;
    }

    public String get(String url) {
        return given()
                .auth()
                .preemptive()
                .basic(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .header(CONTENT_TYPE_VALUE, APPLICATION_JSON_VALUE)
                .when()
                .get(PROJECT_ID + url)
                .then()
                .log().all()
                .extract().body().asString();
    }

    public Response post(String url, String body) {
        return given()
                .auth()
                .preemptive()
                .basic(System.getProperty("email", PropertyReader.getProperty("email")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .header(CONTENT_TYPE_VALUE, APPLICATION_JSON_VALUE)
                .body(body)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
}